package com.diego.companycontrol.data.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DepartmentForm {

    @NotNull @NotEmpty
    public String name;

}
