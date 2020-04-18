package com.diego.companycontrol.services;

import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.entities.Frequency;
import com.diego.companycontrol.data.entities.enums.EmployeeRole;
import com.diego.companycontrol.data.forms.EmployeeForm;
import com.diego.companycontrol.data.forms.FrequencyForm;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();
    Employee findById(Long id);
    List<Employee> findByRole(EmployeeRole role);
    List<Employee> findByName(String name);
    Employee createFromEmployeeForm(EmployeeForm form);
    Employee insertFrequency(Long id, FrequencyForm frequency);

}
