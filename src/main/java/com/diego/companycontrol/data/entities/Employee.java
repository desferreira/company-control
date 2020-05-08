package com.diego.companycontrol.data.entities;

import com.diego.companycontrol.data.entities.enums.EmployeeRole;
import com.diego.companycontrol.data.entities.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String CPF;

    @Getter @Setter
    @JsonFormat(pattern = "YYYY/MM/dd")
    private Date birthDate;

    @Getter @Setter
    private String email;

    @Getter @Setter
    @ManyToOne
    private Department department;

    @Getter @Setter
    private Double baseSalary;

    @Getter @Setter
    private EmployeeRole role;

    @Getter @Setter
    private EmployeeStatus status;

    @Getter @Setter
    @OneToMany
    private List<Frequency> frequency = new ArrayList<>();

    public Employee(Long id, String name, String CPF, Date birthDate, String email, Department department, Double baseSalary, EmployeeRole role){
        this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.birthDate = birthDate;
        this.email = email;
        this.department = department;
        this.baseSalary = baseSalary;
        this.role = role;
        this.status = EmployeeStatus.ATIVO;
    }

    public Double getBonus() {
        return this.baseSalary;
    }

    public void addFrequency(Frequency frequency){
        this.frequency.add(frequency);
    }

}
