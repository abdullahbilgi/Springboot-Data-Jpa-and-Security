package com.springboot.springbootMVC.controller;

import com.springboot.springbootMVC.entity.Employee;
import com.springboot.springbootMVC.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String listEmployees(Model theModel){

        List<Employee> theEmployees = employeeService.findAll();

        theModel.addAttribute("employees",theEmployees);

        return "list-employees";
    }
}
