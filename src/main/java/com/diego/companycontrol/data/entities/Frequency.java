package com.diego.companycontrol.data.entities;

import com.diego.companycontrol.data.entities.enums.FrequencyStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
public class Frequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private LocalDateTime startWork;

    @Getter @Setter
    private LocalDateTime finalWork;

    @Getter @Setter
    @OneToOne(cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private Employee employee;

    @Getter @Setter
    private FrequencyStatus status;

    public Frequency(LocalDateTime startWork, LocalDateTime finalWork, Employee employee, FrequencyStatus status) {
        this.startWork = startWork;
        this.finalWork = finalWork;
        this.employee = employee;
        this.status = status;
    }
}
