package com.diego.companycontrol.controllers;

import com.diego.companycontrol.repositories.FrequencyPageableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/frequencies")
public class FrequencyController {

    @Autowired
    private FrequencyPageableRepository frequencyPageableRepository;

    @GetMapping
    public ResponseEntity<?> findAllFrequencies(Pageable pageable){
        return ResponseEntity.ok().body(this.frequencyPageableRepository.findAll(pageable));
    }

}
