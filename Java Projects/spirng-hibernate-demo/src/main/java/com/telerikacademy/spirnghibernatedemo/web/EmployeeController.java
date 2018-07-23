package com.telerikacademy.spirnghibernatedemo.web;


import com.telerikacademy.spirnghibernatedemo.models.Employee;
import com.telerikacademy.spirnghibernatedemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") int id){
        return service.getById(id);
    }

    @GetMapping("/")
    public List<Employee> getAll(){
        return service.getAll();
    }
}
