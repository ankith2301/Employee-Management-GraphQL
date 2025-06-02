package com.service;

import com.models.ServiceDTO;

import java.util.List;

public interface EmpService {
    String createService(ServiceDTO service);

    List<ServiceDTO> getAllServices();
}
