package com.controller;

import com.models.ServiceDTO;
import com.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/service")
public class ServiceController {
    private final EmpService empService;

    @Autowired
    public ServiceController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createService(@RequestBody ServiceDTO serviceDTO) {
        return new ResponseEntity<String>(empService.createService(serviceDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ServiceDTO>> getAllServices() {
        return new ResponseEntity<List<ServiceDTO>>(empService.getAllServices(), HttpStatus.CREATED);
    }
}
