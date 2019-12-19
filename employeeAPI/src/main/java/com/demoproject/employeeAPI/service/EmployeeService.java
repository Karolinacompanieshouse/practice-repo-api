package com.demoproject.employeeAPI.service;

import com.demoproject.employeeAPI.model.Employee;
import com.demoproject.employeeAPI.model.Role;
import com.demoproject.employeeAPI.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(final EmployeeRepository repository) {
        this.repository = repository;
    }

    public void postEmployee(final Employee employee) {
        repository.postEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    public void deleteEmployee(final Employee employee) {
        repository.deleteEmployee(employee);
    }

    public void updateEmployee(final Employee employee){
        repository.updateEmployee(employee);
    }

    public List<Role> getAllRoles() {
        return repository.getAllRoles();
    }
}

