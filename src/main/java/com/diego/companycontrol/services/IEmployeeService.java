package com.diego.companycontrol.services;

import com.diego.companycontrol.data.entities.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();
    Employee findById(Long id);
    List<Employee> findByName(String name);
    Employee insertEmployee(Employee employee);
    void deleteEmployee(Long id);

}
