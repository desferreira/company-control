package com.diego.companycontrol.data.entities;

import com.diego.companycontrol.data.entities.enums.EmployeeRole;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "employee")
@Entity
@NoArgsConstructor
public class Leader extends Employee {
    public Leader(Long id, String name, Date birthDate, String email, Department department, Double baseSalary, EmployeeRole role) {
        super(id, name, birthDate, email, department, baseSalary, role);
    }

    @Override
    public Double getBonus(){
        return this.getBaseSalary()*1.10;
    }
}
