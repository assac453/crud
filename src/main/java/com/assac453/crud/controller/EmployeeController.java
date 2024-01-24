package com.assac453.crud.controller;

import com.assac453.crud.dto.EmployeeDto;
import com.assac453.crud.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/new")
    public EmployeeDto save(@RequestBody EmployeeDto dto){
        return service.save(dto);
    }

    @PatchMapping("/update/{id}")
    public EmployeeDto update(@PathVariable int id, @RequestBody EmployeeDto dto){
        return service.update(id, dto);
    }

    @GetMapping("/")
    public List<EmployeeDto> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public EmployeeDto deleteById(@PathVariable int id){
        return service.delete(id);
    }

}
