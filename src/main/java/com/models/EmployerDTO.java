package com.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDTO {
    private Long id;
    private String name;
    private int age;
    private String gmail;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
