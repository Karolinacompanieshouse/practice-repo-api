package com.demoproject.employeeAPI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import com.demoproject.employeeAPI.model.Employee;
import com.demoproject.employeeAPI.repository.EmployeeRepository;
import com.demoproject.employeeAPI.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {



    private EmployeeController testController;
    private Employee testEmployee;

    @Mock
    private EmployeeService testService;

    @BeforeEach
    void setUp() {
        testController = new EmployeeController(testService);
        testEmployee = new Employee();
    }

    @Test
    void saveEmployee() {
        testController.saveEmployee(testEmployee);
        verify(testService).postEmployee(testEmployee);
    }

    @Test
    void getAllEmployees() {
        testController.getAllEmployees();
        verify(testService).getAllEmployees();
    }

    @Test
    void deleteEmployee() {
        testController.deleteEmployee(testEmployee);
        verify(testService).deleteEmployee(testEmployee);
    }

    @Test
    void updateEmployee() {
        testController.updateEmployee(testEmployee);
        verify(testService).updateEmployee(testEmployee);
    }

    @Test
    void getAllRoles() {
        testController.getAllRoles();
        verify(testService).getAllRoles();
    }
}