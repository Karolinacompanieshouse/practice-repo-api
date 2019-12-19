package com.demoproject.employeeAPI.repository;

import com.demoproject.employeeAPI.model.Employee;
import com.demoproject.employeeAPI.model.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;

@Repository
public class EmployeeRepository {

    private MongoTemplate template;

    @Autowired
    public EmployeeRepository(final MongoTemplate template) {
        this.template = template;
    }

    public void postEmployee(Employee employee) {
        template.save(employee);
    }


    public List<Employee> getAllEmployees() {
        return  template.findAll(Employee.class);
    }


    public void deleteEmployee(Employee employee){

        String first = employee.getFirstName();
        String second = employee.getLastName();

        Query query = new Query();
        query.addCriteria(
                new Criteria().andOperator(
                        Criteria.where("firstName").is(first),
                        Criteria.where("lastName").is(second)
                )
        );
        template.findAndRemove(query, Employee.class);
    }

    public void updateEmployee(Employee employee){
    String first = employee.getFirstName();
    String second = employee.getLastName();

    Query query = new Query();
        query.addCriteria(
                new Criteria().andOperator(
            Criteria.where("firstName").is(first),
                        Criteria.where("lastName").is(second)
                )
                        );

    Update update = new Update().set("salary", employee.getSalary());
        template.findAndModify(query, update, Employee.class);

}

    public List<Role> getAllRoles() {
        return  template.findAll(Role.class);
    }
}


