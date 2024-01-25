package com.assac453.crud.service;

import com.assac453.crud.dto.DepartmentDto;
import com.assac453.crud.dto.EmployeeDto;
import com.assac453.crud.entity.Department;
import com.assac453.crud.entity.Employee;
import com.assac453.crud.repository.DepartmentRepository;
import com.assac453.crud.util.DtoToEntityMapper;
import com.assac453.crud.util.EntityToDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService implements CRUDService<DepartmentDto>{

    private final DepartmentRepository repository;

    public  List<EmployeeDto> getAllEmployeeWithSpecificDepartmentId(int id){
        Optional<Department> byId = repository.findById(id);
        return byId
                .map(
                        department ->
                                department.getEmployees()
                                        .stream()
                                        .map(EntityToDtoMapper::entityToDto)
                                        .collect(Collectors.toList())
                ).orElse(null);
    }

    public EmployeeDto addToDepartment(int id, EmployeeDto dto){
        Optional<Department> byId = repository.findById(id);
        if(byId.isEmpty()){
            return null;
        }
        Department department = byId.get();
        Employee e = DtoToEntityMapper.dtoToEntity(dto);
        e.setDepartment(department);
        department.getEmployees().add(e);
        repository.save(department);
        return dto;
    }


    @Override
    public DepartmentDto save(DepartmentDto item) {
        repository.save(DtoToEntityMapper.dtoToEntity(item));
        return item;
    }

    @Override
    public DepartmentDto update(int id, DepartmentDto item) {
        if(!repository.existsById(id)){
            return null;
        }
        Department updated = DtoToEntityMapper.dtoToEntity(item);
        updated.setId(id);
        repository.save(updated);
        return item;
    }

    @Override
    public DepartmentDto delete(int id) {
        DepartmentDto byId = getById(id);
        if(byId == null){
            return null;
        }
        repository.deleteById(id);
        return byId;
    }

    @Override
    public List<DepartmentDto> getAll() {
        return repository
                .findAll()
                .stream()
                .map(EntityToDtoMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getById(int id) {
        return repository
                .findById(id)
                .map(EntityToDtoMapper::entityToDto)
                .orElse(null);
    }
}
