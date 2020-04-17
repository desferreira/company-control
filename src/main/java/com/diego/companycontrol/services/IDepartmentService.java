package com.diego.companycontrol.services;

import com.diego.companycontrol.data.entities.Department;

import java.util.List;

public interface IDepartmentService {

    List<Department> findAll();
    Department findById(Long id);
    List<Department> findByName(String name);
    Department createDepartment(Department department);
    void deleteDepartment(Long id);

}
