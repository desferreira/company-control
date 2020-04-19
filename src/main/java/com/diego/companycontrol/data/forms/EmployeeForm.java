package com.diego.companycontrol.data.forms;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@ToString
public class EmployeeForm {

    @NotEmpty @NotNull
    public String name;

    @NotEmpty @NotNull
    @JsonFormat(pattern = "YYYY/MM/dd")
    public Date birthDate;

    @NotEmpty @NotNull
    public String email;

    @NotEmpty @NotNull
    public String departmentName;

    @NotEmpty @NotNull
    public Double baseSalary;

    @NotEmpty @NotNull
    public String role;

}
