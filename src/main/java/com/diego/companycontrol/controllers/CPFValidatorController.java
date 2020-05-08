package com.diego.companycontrol.controllers;

import com.diego.companycontrol.utils.CPFValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validate")
public class CPFValidatorController {

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Boolean> validateCPF(@PathVariable String cpf){
        return ResponseEntity.ok().body(CPFValidator.isCPF(cpf));
    }

}
