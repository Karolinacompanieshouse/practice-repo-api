package com.demoproject.employeeAPI.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import com.demoproject.employeeAPI.model.Employee;
import com.demoproject.employeeAPI.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    private EmployeeService testService;
    private Employee testEmployee;

    @Mock
    private EmployeeRepository testRepository;
    @BeforeEach
    void setUp() {
        testService = new EmployeeService(testRepository);
        testEmployee = new Employee();
        testEmployee.setFirstName("FIRST");
        testEmployee.setLastName("LAST");
    }

    @Test
    void postEmployee() {
        testService.postEmployee(testEmployee);
        verify(testRepository).postEmployee(testEmployee);
    }

    @Test
    void getAllEmployees() {
        testService.postEmployee(testEmployee);
        testService.getAllEmployees();
        verify(testRepository).getAllEmployees();
    }

    @Test
    void deleteEmployee() {
        testService.postEmployee(testEmployee);
        testService.deleteEmployee(testEmployee);
        verify(testRepository).deleteEmployee(testEmployee);
    }

    @Test
    void updateEmployee() {
        testService.postEmployee(testEmployee);
        testService.updateEmployee(testEmployee);
        verify(testRepository).updateEmployee(testEmployee);
    }

    @Test
    void getAllRoles() {
        testService.getAllRoles();
        verify(testRepository).getAllRoles();
    }
}