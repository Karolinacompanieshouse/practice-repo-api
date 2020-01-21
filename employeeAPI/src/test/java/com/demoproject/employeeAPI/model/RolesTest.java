package com.demoproject.employeeAPI.model;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RolesTest {

    private Roles testRoles;
    private Role testRole;
    @BeforeEach
    void setUp() {
        testRoles = new Roles();
        testRole = new Role();
        testRole.setRoleName("NAME");
        testRole.setBandMin(200);
        testRole.setBandMax(400);
    }

    @Test
    void setAndGetRoles() {
        testRoles.setRoles(Collections.singletonList(testRole));
        assertThat(testRoles.getRoles(),is(Collections.singletonList(testRole)));
    }

}