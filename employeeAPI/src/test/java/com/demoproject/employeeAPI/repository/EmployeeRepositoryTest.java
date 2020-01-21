package com.demoproject.employeeAPI.repository;

import java.util.List;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import static org.mockito.Mockito.verify;

import com.demoproject.employeeAPI.model.Employee;
import com.demoproject.employeeAPI.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

@ExtendWith(MockitoExtension.class)

class EmployeeRepositoryTest {

    private EmployeeRepository testRepository;
    private Employee testEmployee;

    @Mock
    private MongoTemplate testMongo;
    @BeforeEach
    void setUp() {
        testRepository = new EmployeeRepository(testMongo);
        testEmployee = new Employee();
        testEmployee.setFirstName("HEWWO");
        testEmployee.setLastName("THERE");
        testEmployee.setSalary(42.0);
    }

    @Test
    void postEmployee() {
        testRepository.postEmployee(testEmployee);
        verify(testMongo).save(testEmployee);
    }

    @Test
    void getAllEmployees() {
        testRepository.postEmployee(testEmployee);
        testRepository.getAllEmployees();
        verify(testMongo).findAll(Employee.class);
    }

    @Test
    void deleteEmployee() {
        testRepository.postEmployee(testEmployee);
        testRepository.deleteEmployee(testEmployee);
        Query query = buildQuery(testEmployee);
        verify(testMongo).findAndRemove(query, Employee.class);
    }

    @Test
    void updateEmployee() {
        testRepository.postEmployee(testEmployee);
        testRepository.updateEmployee(testEmployee);
        Query query = buildQuery(testEmployee);
        Update update = new Update().set("salary", testEmployee.getSalary());
        verify(testMongo).findAndModify(query, update, Employee.class);
    }

    @Test
    void getAllRoles() {
        testRepository.getAllRoles();
        verify(testMongo).findAll(Role.class);
    }

    private Query buildQuery(Employee employee){
        Query query = new Query();
        query.addCriteria(
                new Criteria().andOperator(
                        Criteria.where("firstName").is(employee.getFirstName()),
                        Criteria.where("lastName").is(employee.getLastName())
                )
        );
        return query;
    }
}