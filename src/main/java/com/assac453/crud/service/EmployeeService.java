package com.assac453.crud.service;

import com.assac453.crud.dto.EmployeeDto;
import com.assac453.crud.entity.Employee;
import com.assac453.crud.repository.EmployeeRepository;
import com.assac453.crud.util.DtoToEntityMapper;
import com.assac453.crud.util.EntityToDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService implements CRUDService<EmployeeDto>{

    private final EmployeeRepository repository;
    private final DepartmentService departmentService;

    public List<EmployeeDto> getEmployeesWithSpecificDepartmentId(int id){
        return departmentService.getAllEmployeeWithSpecificDepartmentId(id);
    }

    @Override
    public EmployeeDto save(EmployeeDto item) {
        repository.save(DtoToEntityMapper.dtoToEntity(item));
        return item;
    }

    @Override
    public EmployeeDto update(int id, EmployeeDto item) {
        if(!repository.existsById(id)){
            return null;
        }
        Employee updated = DtoToEntityMapper.dtoToEntity(item);
        updated.setId(id);
        repository.save(updated);
        return item;
    }

    @Override
    public EmployeeDto delete(int id) {
        EmployeeDto byId = getById(id);
        if (byId == null){
            return null;
        }
        repository.deleteById(id);
        return byId;
    }

    @Override
    public List<EmployeeDto> getAll() {
        return repository
                .findAll()
                .stream()
                .map(EntityToDtoMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getById(int id) {
        return repository
                .findById(id)
                .map(EntityToDtoMapper::entityToDto)
                .orElse(null);
    }
}
