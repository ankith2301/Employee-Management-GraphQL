package com.service.impl;

import com.entities.Employee;
import com.mappers.DataMapper;
import com.models.EmployeeDTO;
import com.repository.EmployeeRepository;
import com.repository.EmployerRepository;
import com.repository.ServiceRepository;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployerRepository employerRepository;
    private final ServiceRepository serviceRepository;
    private final DataMapper dataMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployerRepository employerRepository, ServiceRepository serviceRepository, DataMapper dataMapper) {
        this.employeeRepository = employeeRepository;
        this.employerRepository = employerRepository;
        this.serviceRepository = serviceRepository;
        this.dataMapper = dataMapper;
    }

    @Override
    public String createEmployee(EmployeeDTO employee, Long employerID, Long serviceID) {
        Employee employeeEntity = dataMapper.toEntity(employee);
        employeeEntity.setEmployer(employerRepository.findById(employerID).get());
        employeeEntity.setService(serviceRepository.findById(serviceID).get());
        employeeRepository.save(employeeEntity);
        return "Created SuccessFully";
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return dataMapper.toEmployeeModelList(employeeRepository.findAll());
    }
}
