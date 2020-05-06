package com.diego.companycontrol.controllers;

import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.forms.EmployeeForm;
import com.diego.companycontrol.data.forms.FrequencyForm;
import com.diego.companycontrol.data.forms.FrequencyFormId;
import com.diego.companycontrol.services.implementation.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Employee> createNewEmployee(@RequestBody EmployeeForm employeeForm){
        return ResponseEntity.ok().body(this.employeeServiceImpl.createFromEmployeeForm(employeeForm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.employeeServiceImpl.findById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
        this.employeeServiceImpl.removeEmployee(id);
        return ResponseEntity.ok().body("O usuário foi removido com sucesso!");
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeForm form){
        return ResponseEntity.ok().body(this.employeeServiceImpl.updateEmployee(id, form));
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
    public ResponseEntity<Double> getMeanSalaryByDepartment(@PathVariable Long department){
        return ResponseEntity.ok().body(this.employeeServiceImpl.getMeanSalaryByDepartment(department));
    }

    @GetMapping("/salary/mean")
    public ResponseEntity<Double> getMeanSalary(){
        return ResponseEntity.ok().body(this.employeeServiceImpl.getMeanSalary());
    }


}
