package com.springboot.springbootMVC.service;

import com.springboot.springbootMVC.dao.EmployeeRepository;
import com.springboot.springbootMVC.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee theEmployee);

    void delete(int theId);
}
