package com.assac453.crud.util;

import com.assac453.crud.dto.DepartmentDto;
import com.assac453.crud.dto.EmployeeDto;
import com.assac453.crud.entity.Department;
import com.assac453.crud.entity.Employee;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoToEntityMapper {
    public static Department dtoToEntity(DepartmentDto dto){
        return Department.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phone(dto.getPhone())
                .build();
    }


    public static Employee dtoToEntity(EmployeeDto dto){
        return Employee.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

}
