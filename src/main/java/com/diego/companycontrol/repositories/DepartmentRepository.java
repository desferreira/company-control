package com.diego.companycontrol.repositories;

import com.diego.companycontrol.data.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findDepartmentByName(String namePart);

}
