package com.telerikacademy.springjdbcdemo.data;

import com.telerikacademy.springjdbcdemo.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAll();

    List<Employee> findByName(String name);

}
