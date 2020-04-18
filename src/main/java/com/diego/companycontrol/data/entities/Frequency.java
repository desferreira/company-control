package com.diego.companycontrol.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
@NoArgsConstructor
public class Frequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Instant startWork;

    @Getter @Setter
    private Instant finalWork;

    @Getter @Setter
    @OneToOne
    @JsonIgnore
    private Employee employee;

    public Frequency(Instant startWork, Instant finalWork, Employee employee) {
        this.startWork = startWork;
        this.finalWork = finalWork;
        this.employee = employee;
    }
}
