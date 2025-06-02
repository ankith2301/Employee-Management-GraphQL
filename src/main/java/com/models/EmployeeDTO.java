package com.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private int age;
    private String gmail;
    private double experience;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
