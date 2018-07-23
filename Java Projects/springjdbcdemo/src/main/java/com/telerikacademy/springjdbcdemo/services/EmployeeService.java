package com.telerikacademy.springjdbcdemo.services;

import com.telerikacademy.springjdbcdemo.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    List<Employee> findByName(String name);

}
