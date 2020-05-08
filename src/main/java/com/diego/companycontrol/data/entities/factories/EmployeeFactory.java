package com.diego.companycontrol.data.entities.factories;

import com.diego.companycontrol.data.entities.*;
import com.diego.companycontrol.data.entities.enums.EmployeeRole;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeFactory {

    public static Employee createNewEmployee(Long id, String name, String CPF, Date birthDate, String email, Department department, Double baseSalary, EmployeeRole role){
        switch(role){
            case EMPLOYEE:
                return new Employee(id, CPF, name, birthDate, email, department, baseSalary, role);
            case LIDER:
                return new Leader(id, CPF, name, birthDate, email, department, baseSalary, role);
            case EXECUTIVE:
                return new Executive(id, CPF, name, birthDate, email, department, baseSalary, role);
            case OWNER:
                return new Owner(id, CPF, name, birthDate, email, department, baseSalary, role);
            default:
                return null;
        }
    }


}
