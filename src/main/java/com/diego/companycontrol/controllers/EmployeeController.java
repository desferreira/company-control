package com.diego.companycontrol.controllers;

import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.forms.EmployeeForm;
import com.diego.companycontrol.data.forms.FrequencyForm;
import com.diego.companycontrol.services.implementation.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees(){
        return ResponseEntity.ok().body(this.employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Employee> createNewEmployee(@RequestBody EmployeeForm employeeForm){
        return ResponseEntity.ok().body(this.employeeService.createFromEmployeeForm(employeeForm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.employeeService.findById(id));
    }

    @PostMapping("/register/{id}")
    public ResponseEntity<Employee> registerFrequency(@PathVariable Long id, @RequestBody FrequencyForm form){
        return ResponseEntity.ok().body(this.employeeService.insertFrequency(id, form));
    }


}
