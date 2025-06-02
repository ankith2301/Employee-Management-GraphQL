package com.service.impl;

import com.entities.Employer;
import com.mappers.DataMapper;
import com.models.EmployerDTO;
import com.repository.EmployerRepository;
import com.repository.ServiceRepository;
import com.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {
    private final EmployerRepository employerRepository;
    private final DataMapper dataMapper;
    private final ServiceRepository serviceRepository;

    @Autowired
    public EmployerServiceImpl(EmployerRepository employerRepository, DataMapper dataMapper, ServiceRepository serviceRepository) {
        this.employerRepository = employerRepository;
        this.dataMapper = dataMapper;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public String createEmployer(EmployerDTO employer, List<Long> serviceIdList) {
        Employer employerEntity = dataMapper.toEntity(employer);
        employerEntity.setServices(serviceRepository.findByIdIn(serviceIdList));
        employerRepository.save(employerEntity);
        return "Created Successfully";
    }

    @Override
    public List<EmployerDTO> getAllEmployers() {
        return dataMapper.toEmployerModelList(employerRepository.findAll());
    }
}
