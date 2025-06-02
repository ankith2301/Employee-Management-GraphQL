package com.service.impl;

import com.mappers.DataMapper;
import com.models.ServiceDTO;
import com.repository.ServiceRepository;
import com.service.EmpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    private final ServiceRepository serviceRepository;
    private final DataMapper dataMapper;

    public EmpServiceImpl(ServiceRepository serviceRepository, DataMapper dataMapper) {
        this.serviceRepository = serviceRepository;
        this.dataMapper = dataMapper;
    }

    @Override
    public String createService(ServiceDTO service) {
        serviceRepository.save(dataMapper.toEntity(service));
        return "Created Successfully";
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        return dataMapper.toServiceModelList(serviceRepository.findAll());
    }
}
