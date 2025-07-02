package com.employeeservice.repository;

import com.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees
            = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        return employees.stream().filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .toList();
    }

    public List<Employee> findAll() {
        return employees
                .stream()
                .sorted((o1, o2) -> o1.getId().compareTo(o2.getId()))
                .toList();
    }
}
