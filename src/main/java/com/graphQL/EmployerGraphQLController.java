package com.graphQL;

import com.entities.Employer;
import com.entities.Service;
import com.repository.EmployerRepository;
import com.repository.ServiceRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployerGraphQLController {

    private final EmployerRepository employerRepository;
    private final ServiceRepository serviceRepository;

    public EmployerGraphQLController(EmployerRepository employerRepository, ServiceRepository serviceRepository) {
        this.employerRepository = employerRepository;
        this.serviceRepository = serviceRepository;
    }

    @QueryMapping
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    @QueryMapping
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }
}


