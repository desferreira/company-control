package com.diego.companycontrol.data.entities.enums;

import lombok.Getter;
import lombok.Setter;

public enum FrequencyStatus {
    OPEN(0),
    CLOSED(1);

    @Getter @Setter
    private int code;

    FrequencyStatus(int code){ this.code = code; }

    public static DepartmentRole valueOf(int code){
        for (DepartmentRole e : DepartmentRole.values()){
            if (e.getCode() == code){
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("The code %d is not a valid type", code));
    }


}
