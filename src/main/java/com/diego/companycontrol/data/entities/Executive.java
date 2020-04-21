package com.diego.companycontrol.data.entities;

import com.diego.companycontrol.data.entities.enums.EmployeeRole;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Executive extends Employee {

    public Executive(Long id, String name, Date birthDate, String email, Department department, Double baseSalary, EmployeeRole role) {
        super(id, name, birthDate, email, department, baseSalary, role);
    }

    @Override
    public Double getBonus() {
        return this.getBaseSalary()*1.15;
    }
}
