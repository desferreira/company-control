package com.diego.companycontrol.data.entities.enums;

import lombok.Getter;
import lombok.Setter;

public enum EmployeeRole {

    EMPLOYEE(0),
    LIDER(2),
    EXECUTIVE(3),
    OWNER(4);


    @Getter @Setter
    private int code;

    EmployeeRole(int code){
        this.code = code;
    }

    public static EmployeeRole valueOf(int code){
        for (EmployeeRole e : EmployeeRole.values()){
            if (e.getCode() == code){
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("The code %d is not a valide type", code));
    }


}
