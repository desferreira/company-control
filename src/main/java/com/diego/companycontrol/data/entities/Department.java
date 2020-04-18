package com.diego.companycontrol.data.entities;

import com.diego.companycontrol.data.entities.enums.DepartmentRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@ToString
@Entity
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter @Setter
    private String name;

    public Department(){};

    public Department(DepartmentRole role){
        this.name = role.name();
    }


}
