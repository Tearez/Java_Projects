package com.telerikacademy.spirnghibernatedemo.data;

import com.telerikacademy.spirnghibernatedemo.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee getById(int id);
    List<Employee> listAll();
}
