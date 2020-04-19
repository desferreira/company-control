package com.diego.companycontrol.config;

import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.entities.Department;
import com.diego.companycontrol.data.entities.Frequency;
import com.diego.companycontrol.data.entities.enums.DepartmentRole;
import com.diego.companycontrol.data.entities.enums.EmployeeRole;
import com.diego.companycontrol.data.entities.factories.EmployeeFactory;
import com.diego.companycontrol.repositories.DepartmentRepository;
import com.diego.companycontrol.repositories.EmployeeRepository;
import com.diego.companycontrol.repositories.FrequencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
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
        Department d1 = new Department(DepartmentRole.TECNOLOGIA);
        log.info((String.format("Criando o department %s", d1.toString())));

        Department d2 = new Department(DepartmentRole.MARKETING);
        log.info((String.format("Criando o department %s", d2.toString())));

        departmentRepository.saveAll(Arrays.asList(d1, d2));

        Employee e1 = new EmployeeFactory().createNewEmployee(null,"Diego Ferreira", new Date(),
                "diegoferreira@hotmail.com", d1, 3500.0,
                EmployeeRole.EMPLOYEE);
        log.info((String.format("Criando o employee %s", e1.toString())));

        Employee e2 = new EmployeeFactory().createNewEmployee(null,"John Smith", new Date(),
                "diegoferreira@hotmail.com", d2, 6500.0,
                EmployeeRole.EXECUTIVE);
        log.info((String.format("Criando o employee %s", e2.toString())));

        employeeRepository.saveAll(Arrays.asList(e1, e2));

        Frequency ef1 = new Frequency(LocalDateTime.now(), LocalDateTime.now(), e1);

        Frequency ef2 = new Frequency(LocalDateTime.now(), LocalDateTime.now(), e2);

        frequencyRepository.saveAll(Arrays.asList(ef1, ef2));

        e1.addFrequency(ef1);
        e2.addFrequency(ef2);

        employeeRepository.saveAll(Arrays.asList(e1, e2));

    }
}
