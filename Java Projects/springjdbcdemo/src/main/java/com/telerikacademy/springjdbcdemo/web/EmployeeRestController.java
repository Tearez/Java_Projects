package com.telerikacademy.springjdbcdemo.web;


import com.telerikacademy.springjdbcdemo.models.Employee;
import com.telerikacademy.springjdbcdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private EmployeeService service;

    @Autowired
    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @RequestMapping("/find/{name}")
    List<Employee> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }
}
