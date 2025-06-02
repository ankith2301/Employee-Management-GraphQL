package com.controller;

import com.models.EmployeeDTO;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("app/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create/{employerID}")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("employerID") Long employerID, @PathVariable("serviceID") Long serviceID) {
        return new ResponseEntity<String>(employeeService.createEmployee(employeeDTO, employerID, serviceID), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(EmployeeDTO employeeDTO) {
        return new ResponseEntity<List<EmployeeDTO>>(employeeService.getAllEmployees(), HttpStatus.CREATED);
    }
}
