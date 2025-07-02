package com.employeeservice.controllers;

import com.employeeservice.model.Employee;
import com.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        logger.info("Employee add: {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        logger.info("Employees find");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        logger.info("Employees find: id={}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartmentId(@PathVariable Long departmentId) {
        logger.info("Employees find: departmentId={}", departmentId);
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
