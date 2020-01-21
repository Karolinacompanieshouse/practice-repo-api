package com.demoproject.employeeAPI.model;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    private Employee testEmployee;
    @BeforeEach
    void setUp() {
        testEmployee = new Employee();
    }

    @Test
    void setAndGetFirstName() {
        testEmployee.setFirstName("Test");
        assertThat(testEmployee.getFirstName(),is("Test"));
    }

    @Test
    void setAndGetLastName() {
        testEmployee.setLastName("Test");
        assertThat(testEmployee.getLastName(),is("Test"));
    }


    @Test
    void setAndGetDateOfBirth() {
        testEmployee.setDateOfBirth("Test");
        assertThat(testEmployee.getDateOfBirth(),is("Test"));
    }


    @Test
    void SetAndGetPostcode() {
        testEmployee.setPostcode("Test");
        assertThat(testEmployee.getPostcode(),is("Test"));
    }

    @Test
    void setAndGetAddressLine1() {
        testEmployee.setAddressLine1("Test");
        assertThat(testEmployee.getAddressLine1(),is("Test"));
    }

    @Test
    void SetAndGetAddressLine2() {
        testEmployee.setAddressLine2("Test");
        assertThat(testEmployee.getAddressLine2(),is("Test"));
    }


    @Test
    void setAndGetSalary() {
        testEmployee.setSalary(100);
        assertThat(testEmployee.getSalary(),is(100.0));
    }

    @Test
    void setAndGetRole() {
        testEmployee.setRole("Test");
        assertThat(testEmployee.getRole(),is("Test"));
    }

}