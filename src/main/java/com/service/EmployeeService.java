package com.service;

import com.models.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    String createEmployee(EmployeeDTO employee, Long employerID, Long serviceID);

    List<EmployeeDTO> getAllEmployees();
}
