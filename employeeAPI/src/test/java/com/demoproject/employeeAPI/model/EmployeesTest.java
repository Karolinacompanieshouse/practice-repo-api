package com.demoproject.employeeAPI.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeesTest {

    private Employees testEmployees;
    private Employee testEmployee;
    @BeforeEach
    void setUp() {
        testEmployee = new Employee();
        testEmployees = new Employees();
        testEmployee.setFirstName("Test");
        testEmployee.setLastName("Test");

    }

    @Test
    void setAndGetEmployees() {
        testEmployees.setEmployees(Collections.singletonList(testEmployee));
        assertThat(testEmployees.getEmployees(),is(Collections.singletonList(testEmployee)));
    }
}