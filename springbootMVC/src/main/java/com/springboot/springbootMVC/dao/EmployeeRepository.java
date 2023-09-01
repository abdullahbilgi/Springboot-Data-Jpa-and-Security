package com.springboot.springbootMVC.dao;

import com.springboot.springbootMVC.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
