package com.diego.companycontrol.config;

import com.diego.companycontrol.repositories.DepartmentRepository;
import com.diego.companycontrol.repositories.EmployeeRepository;
import com.diego.companycontrol.repositories.FrequencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private FrequencyRepository frequencyRepository;

    Logger log = Logger.getLogger("instantiation");

    @Override
    public void run(String... args) throws Exception {


    }
}
