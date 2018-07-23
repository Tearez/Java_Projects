package com.telerikacademy.spirnghibernatedemo.services;

import com.telerikacademy.spirnghibernatedemo.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getById(int id);
    List<Employee> getAll();
}
