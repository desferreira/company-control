package com.diego.companycontrol.data.entities.enums;

import lombok.Getter;
import lombok.Setter;

public enum DepartmentRole {

    TECNOLOGIA(0),
    DESIGN(1),
    MARKETING(2),
    RH(3);


    @Getter
    @Setter
    private int code;

    DepartmentRole(int code){ this.code = code; }

    public static DepartmentRole valueOf(int code){
        for (DepartmentRole e : DepartmentRole.values()){
            if (e.getCode() == code){
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("The code %d is not a valid type", code));
    }
}
