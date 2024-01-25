package com.assac453.crud.util;

import com.assac453.crud.dto.DepartmentDto;
import com.assac453.crud.dto.EmployeeDto;
import com.assac453.crud.entity.Department;
import com.assac453.crud.entity.Employee;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityToDtoMapper {
    public static DepartmentDto entityToDto(Department entity){
        return DepartmentDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .build();
    }

    public static EmployeeDto entityToDto(Employee entity){
        return EmployeeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
