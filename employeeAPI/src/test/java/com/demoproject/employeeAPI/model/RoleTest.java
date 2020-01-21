package com.demoproject.employeeAPI.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoleTest {

    private Role testRole;
    @BeforeEach
    void setUp() {
        testRole = new Role();
    }

    @Test
    void setAndGetRoleName() {
        testRole.setRoleName("Test");
        assertThat(testRole.getRoleName(),is("Test"));
    }


    @Test
    void setAndGetBandMin() {
        testRole.setBandMin(10);
        assertThat(testRole.getBandMin(),is(10.0));
    }


    @Test
    void setAndGetBandMax() {
        testRole.setBandMax(50);
        assertThat(testRole.getBandMax(),is(50.0));
    }

}