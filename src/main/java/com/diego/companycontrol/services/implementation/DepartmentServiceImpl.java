package com.diego.companycontrol.services.implementation;

import com.diego.companycontrol.data.entities.Department;
import com.diego.companycontrol.repositories.DepartmentRepository;
import com.diego.companycontrol.services.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Department> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Department findById(Long id) {
        Optional<Department> departmentOptional = this.repository.findById(id);
        if(departmentOptional.isPresent()){
            return departmentOptional.get();
        }
        return null;
    }

    @Override
    public List<Department> findByName(String name) {
        return this.repository.findDepartmentByNameContaining(name);
    }

    @Override
    public Department createDepartment(Department department) {
        return this.repository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        this.repository.deleteById(id);
    }
}
