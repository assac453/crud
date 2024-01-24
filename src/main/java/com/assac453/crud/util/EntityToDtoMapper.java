package com.assac453.crud.util;

import com.assac453.crud.dto.DepartmentDto;
import com.assac453.crud.dto.EmployeeDto;
import com.assac453.crud.entity.Department;
import com.assac453.crud.entity.Employee;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class EntityToDtoMapper {
    public static DepartmentDto entityToDto(Department entity){
        return DepartmentDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())

//                .employeesId(
//                        entity.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()))
//                        entity.getEmployees().stream()
//                            .map(EntityToDtoMapper::entityToDto)
//                            .collect(Collectors.toList()))
                .build();
    }

    public static EmployeeDto entityToDto(Employee entity){
        return EmployeeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .departmentId(entity.getDepartment().getId())
                .build();
    }
}
