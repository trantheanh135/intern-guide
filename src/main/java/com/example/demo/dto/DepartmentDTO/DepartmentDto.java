package com.example.demo.dto.DepartmentDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DepartmentDto {
    private String departmentName;
    private String logo;
    private Byte status;
    private String Leader;
    private LocalDate beginningDate;
}
