package com.diego.companycontrol.services.implementation;

import com.diego.companycontrol.data.entities.Department;
import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.entities.Frequency;
import com.diego.companycontrol.data.entities.enums.DepartmentRole;
import com.diego.companycontrol.data.entities.enums.EmployeeRole;
import com.diego.companycontrol.data.entities.factories.EmployeeFactory;
import com.diego.companycontrol.data.forms.EmployeeForm;
import com.diego.companycontrol.data.forms.FrequencyForm;
import com.diego.companycontrol.repositories.DepartmentRepository;
import com.diego.companycontrol.repositories.EmployeeRepository;
import com.diego.companycontrol.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmployeeService implements IEmployeeService {

    Logger logger = Logger.getLogger("EmployeeService");

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> optionalEmployee = this.repository.findById(id);
        logger.log(Level.INFO, String.format("Finding the employee with id %o", id));
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        return null;
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
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");

        Department department = this.departmentRepository.findDepartmentByName(form.departmentName);
        if(department == null){
            department = this.departmentRepository.save(new Department(DepartmentRole.valueOf(form.departmentName)));
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
            Frequency frequency = new Frequency(form.startHour, form.finalHour, employee);
            employee.addFrequency(frequency);
            return employee;
        }
        return null;
    }
}
