package com.diego.companycontrol.data.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class EmployeeForm {

    @NotEmpty @NotNull
    public String name;

    @NotEmpty @NotNull
    public Date birthDate;

    @NotEmpty @NotNull
    public String email;

    @NotEmpty @NotNull
    public String departmentName;

}
