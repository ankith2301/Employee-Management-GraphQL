package com.service;

import com.models.EmployerDTO;

import java.util.List;

public interface EmployerService {
    String createEmployer(EmployerDTO employer, List<Long> serviceIdList);

    List<EmployerDTO> getAllEmployers();
}
