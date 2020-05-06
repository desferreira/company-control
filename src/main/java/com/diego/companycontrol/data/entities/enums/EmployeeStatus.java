package com.diego.companycontrol.data.entities.enums;

import lombok.Getter;
import lombok.Setter;

public enum EmployeeStatus {
    INATIVO(0),
    ATIVO(1),
    PENDENTE(2);

    @Getter
    @Setter
    private int code;

    EmployeeStatus(int code){ this.code = code; }

    public static EmployeeStatus valueOf(int code){
        for (EmployeeStatus e : EmployeeStatus.values()){
            if (e.getCode() == code){
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("The code %d is not a valid type", code));
    }

}
