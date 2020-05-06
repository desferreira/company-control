package com.diego.companycontrol.services.implementation;

import com.diego.companycontrol.data.entities.Department;
import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.entities.Frequency;
import com.diego.companycontrol.data.entities.enums.DepartmentRole;
import com.diego.companycontrol.data.entities.enums.EmployeeRole;
import com.diego.companycontrol.data.entities.enums.EmployeeStatus;
import com.diego.companycontrol.data.entities.enums.FrequencyStatus;
import com.diego.companycontrol.data.entities.factories.EmployeeFactory;
import com.diego.companycontrol.data.forms.EmployeeForm;
import com.diego.companycontrol.data.forms.FrequencyForm;
import com.diego.companycontrol.data.forms.FrequencyFormId;
import com.diego.companycontrol.exception.HttpException;
import com.diego.companycontrol.repositories.EmployeeRepository;
import com.diego.companycontrol.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    Logger logger = Logger.getLogger("EmployeeService");

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private FrequencyServiceImpl frequencyService;

    @Override
    public List<Employee> findAll() {
        return this.repository.findAll()
                .stream()
                .filter(employee -> employee.getStatus() == EmployeeStatus.ATIVO)
                .collect(Collectors.toList());
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> optionalEmployee = this.repository.findById(id);
        logger.log(Level.INFO, String.format("Finding the employee with id %o", id));
        if(!optionalEmployee.isPresent()){
            throw new HttpException(String.format("O usuário com id %d não existe", id), HttpStatus.NOT_FOUND, "Error");
        }
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> findByRole(EmployeeRole role) {
        return this.repository.findEmployeeByRole(role);
    }

    @Override
    public List<Employee> findByName(String name) {
        return this.repository.findEmployeeByNameContains(name);
    }

    @Override
    public Employee createFromEmployeeForm(EmployeeForm form) {
        logger.log(Level.INFO, String.format("Creating employee from form %s", form.toString()));

        Department department = this.departmentService.findDepartmentByName(form.departmentName);
        if(department == null){
            department = this.departmentService.createEmployee(new Department(DepartmentRole.valueOf(form.departmentName)));
        }

        Employee employee = new EmployeeFactory().createNewEmployee(null, form.name, form.birthDate,
                form.email, department, form.baseSalary, EmployeeRole.valueOf(form.role.toUpperCase()));

        return this.repository.save(employee);

    }

    @Override
    public Employee insertFrequency(Long id, FrequencyForm form){
        Optional<Employee> optionalEmployee = this.repository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            Frequency frequency = this.frequencyService.registerFrequencyFromForm(form, employee);
            this.frequencyService.saveFrequency(frequency);
            employee.addFrequency(frequency);
            this.repository.save(employee);
            return employee;
        }
        return null;
    }

    public Employee concludeFrequency(Long id, FrequencyFormId form){
        Optional<Employee> optionalEmployee = this.repository.findById(id);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            Frequency frequency = this.frequencyService.findFrequencyById(form.id);
            if (frequency.getStatus() == FrequencyStatus.OPEN){
                frequency.setFinalWork(form.finalHour);
                frequency.setStatus(FrequencyStatus.CLOSED);
                this.frequencyService.saveFrequency(frequency);
            }
            return employee;
        }
        throw new HttpException(String.format("The employee with id %o is not registered", id), HttpStatus.NOT_FOUND, "Error");
    }

    @Override
    public void removeEmployee(Long id) {
        Optional<Employee> employeeOptional = this.repository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employee.setStatus(EmployeeStatus.INATIVO);
            this.repository.save(employee);
        }else {
            throw new HttpException(String.format("The employee with id %o is not registered", id), HttpStatus.NOT_FOUND, "Error");
        }
    }

    @Override
    public Double getMeanSalaryByDepartment(Long departmentId) {
        Department department = this.departmentService.findById(departmentId);
        List<Employee> employees = this.repository.findEmployeeByDepartment(department);
        List<Employee> employeeList = this.repository.findAll();
        return employees.stream()
                .filter(employee -> employee.getDepartment().getId() == departmentId)
                .mapToDouble(Employee::getBonus)
                .average()
                .getAsDouble();
    }

    @Override
    public Double getMeanSalary() {
        List<Employee> employeesList = this.repository.findAll();
        Double meanSalary = employeesList
                .stream()
                .mapToDouble(Employee::getBonus)
                .average().getAsDouble();
        return meanSalary;
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeForm form) {
        Optional<Employee> optionalEmployee = this.repository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee updatedEmployee = this.updateEmployee(form, optionalEmployee.get());
            this.repository.save(updatedEmployee);
            return updatedEmployee;
        }
        throw new HttpException(String.format("The employee with id %o is not registered", id), HttpStatus.NOT_FOUND, "Error");
    }

    private Employee updateEmployee(EmployeeForm form, Employee old){
        old.setName(form.name);
        old.setBirthDate(form.birthDate);
        old.setEmail(form.email);
        old.setDepartment(this.departmentService.findDepartmentByName(form.departmentName));
        old.setBaseSalary(form.baseSalary);
        old.setRole(EmployeeRole.valueOf(form.role));
        return old;
    }
}
