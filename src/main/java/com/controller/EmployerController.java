package com.controller;

import com.models.EmployerDTO;
import com.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("app/employer")
public class EmployerController {
    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployer(@RequestBody EmployerDTO employerDTO, @RequestParam List<Long> serviceIdList) {
        return new ResponseEntity<String>(employerService.createEmployer(employerDTO, serviceIdList), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<EmployerDTO>> getAllEmployers() {
        return new ResponseEntity<List<EmployerDTO>>(employerService.getAllEmployers(), HttpStatus.CREATED);
    }
}
