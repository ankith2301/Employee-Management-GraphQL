package com.mappers;

import com.entities.Employee;
import com.entities.Employer;
import com.entities.Service;
import com.models.EmployeeDTO;
import com.models.EmployerDTO;
import com.models.ServiceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataMapper {
    EmployeeDTO toModel(Employee employee);

    List<EmployeeDTO> toEmployeeModelList(List<Employee> employees);

    Employee toEntity(EmployeeDTO employeeDTO);

    EmployerDTO toModel(Employer employer);

    List<EmployerDTO> toEmployerModelList(List<Employer> employers);

    Employer toEntity(EmployerDTO employerDTO);

    ServiceDTO toModel(Service service);

    List<ServiceDTO> toServiceModelList(List<Service> services);

    Service toEntity(ServiceDTO serviceDTO);
}
