package com.diego.companycontrol.controllers;

import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.forms.EmployeeForm;
import com.diego.companycontrol.data.forms.FrequencyForm;
import com.diego.companycontrol.data.forms.FrequencyFormId;
import com.diego.companycontrol.services.implementation.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees(){
        return ResponseEntity.ok().body(this.employeeServiceImpl.findAll());
    }

    @PostMapping
    public ResponseEntity<Employee> createNewEmployee(@RequestBody EmployeeForm employeeForm){
        return ResponseEntity.ok().body(this.employeeServiceImpl.createFromEmployeeForm(employeeForm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.employeeServiceImpl.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
        this.employeeServiceImpl.removeEmployee(id);
        return ResponseEntity.ok().body("O usuário foi removido com sucesso!");
    }

    @PostMapping("/register/{id}")
    public ResponseEntity<Employee> registerFrequency(@PathVariable Long id, @RequestBody FrequencyForm form){
        return ResponseEntity.ok().body(this.employeeServiceImpl.insertFrequency(id, form));
    }

    @PostMapping("/register/conclude/{id}")
    public ResponseEntity<Employee> registerFrequencyById(@PathVariable Long id, @RequestBody FrequencyFormId form){
        return ResponseEntity.ok().body(this.employeeServiceImpl.concludeFrequency(id, form));
    }

    @GetMapping("/salary/{department}")
    public ResponseEntity<Double> getMeanSalary(@PathVariable Long department){
        return ResponseEntity.ok().body(this.employeeServiceImpl.getMeanSalary(department));
    }


}
