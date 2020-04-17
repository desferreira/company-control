package com.diego.companycontrol.repositories;

import com.diego.companycontrol.data.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findDepartmentByNameContaining(String namePart);
}
