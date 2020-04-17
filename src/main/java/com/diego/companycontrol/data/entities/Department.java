package com.diego.companycontrol.data.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity @Table
@Data @NoArgsConstructor
public class Department {

    @Id @GeneratedValue @Column(name = "department_id")
    @Getter
    private Long id;

    @Getter @Setter @Column(name = "department_name")
    private String name;

    @OneToMany
    @JoinTable(name = "employee")
    @Getter @Setter
    private List<Employee> employees = new ArrayList<>();

    public Department(String name){
        this.name = name;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

}
