package com.springboot.springbootMVC.service;

import com.springboot.springbootMVC.dao.EmployeeRepository;
import com.springboot.springbootMVC.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {
        this.employeeRepository = theemployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        Employee theEmployee = null;

        if (result.isPresent()){
            theEmployee =result.get();
        }
        else {
            throw new RuntimeException("Didn't not find id - " + id);
        }

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        employeeRepository.save(theEmployee);

    }

    @Override
    public void delete(int theId) {

        employeeRepository.deleteById(theId);

    }
}
