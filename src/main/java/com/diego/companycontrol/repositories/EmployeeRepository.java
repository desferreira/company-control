package com.diego.companycontrol.repositories;

import com.diego.companycontrol.data.entities.Department;
import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.entities.enums.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeeByRole(EmployeeRole role);
    List<Employee> findEmployeeByNameContains(String namePart);
    List<Employee> findEmployeeByDepartment(Department department);


}
