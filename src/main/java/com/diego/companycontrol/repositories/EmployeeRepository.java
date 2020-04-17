package com.diego.companycontrol.repositories;

import com.diego.companycontrol.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeeByNameContains(String namePart);

}
