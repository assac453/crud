package com.assac453.crud.controller;

import com.assac453.crud.dto.DepartmentDto;
import com.assac453.crud.dto.EmployeeDto;
import com.assac453.crud.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;


    @GetMapping("/")
    public List<DepartmentDto> getAll(){
        return service.getAll();
    }

    @PostMapping("/new")
    public DepartmentDto save(@RequestBody DepartmentDto dto){
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public DepartmentDto deleteById(@PathVariable int id, @RequestBody DepartmentDto dto){
        return service.delete(id);
    }
    @PatchMapping("/update/{id}")
    public DepartmentDto update(@PathVariable int id, @RequestBody DepartmentDto dto){
        return service.update(id, dto);
    }

    @PostMapping("/employee")
    public EmployeeDto addEmployeeToDepartment(
            @RequestParam(required = true, name = "id") int id,
            @RequestBody EmployeeDto dto){
        return service.addToDepartment(id, dto);
    }
}
