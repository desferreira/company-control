package com.diego.companycontrol.data.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity @Table
@Data @NoArgsConstructor
public class Employee {

    @Id @GeneratedValue @Column(name = "employee_id")
    @Getter
    private Long id;

    @Column(name = "employee_name")
    @Getter @Setter
    private String name;

    @Column(name = "employee_birth")
    @Getter @Setter
    private Date birthDate;

    @Column(name = "employee_email")
    @Getter @Setter
    private String email;

    @OneToOne
    @JoinTable(name = "department")
    private Department department;


    public Employee(String name, Date birthDate, String email, Department department){
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.department = department;
    }

}
