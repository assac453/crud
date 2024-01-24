package com.assac453.crud.util;

import com.assac453.crud.dto.DepartmentDto;
import com.assac453.crud.dto.EmployeeDto;
import com.assac453.crud.entity.Department;
import com.assac453.crud.entity.Employee;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class DtoToEntityMapper {
    public static Department dtoToEntity(DepartmentDto dto){
        return Department.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phone(dto.getPhone())
//                .employees(
//                        dto.getEmployeesId().stream().map(i -> {
//                            var some = new Employee();
//                            some.setId(i);
//                            return some;
//                        }).collect(Collectors.toList()))
//                        dto.getEmployeesId().stream()
//                                .map(DtoToEntityMapper::dtoToEntity)
//                                .collect(Collectors.toList()))
                .build();
    }


    public static Employee dtoToEntity(EmployeeDto dto){
        return Employee.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .department(
                        Department.builder()
                                .id(dto.getDepartmentId())
                                .build()
                )
                .build();
    }

}
