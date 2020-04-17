package com.diego.companycontrol.services.implementation;

import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.repositories.EmployeeRepository;
import com.diego.companycontrol.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> optionalEmployee = this.repository.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        return null;
    }

    @Override
    public List<Employee> findByName(String name) {
        return this.repository.findEmployeeByNameContains(name);
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        this.repository.deleteById(id);
    }
}
