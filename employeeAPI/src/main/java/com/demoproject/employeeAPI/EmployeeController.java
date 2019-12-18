package com.demoproject.employeeAPI;

import com.demoproject.employeeAPI.model.Employee;
import com.demoproject.employeeAPI.model.Employees;
import com.demoproject.employeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    EmployeeController(final EmployeeService service) {
        this.service = service;
    }
    @PostMapping("/saveEmployee")
    public void saveEmployee(@RequestBody Employee employee) {
        service.postEmployee(employee);
        System.out.println("Saved to database!!");
    }

    @GetMapping(value = "/allEmployees")
    public ResponseEntity<Employees> getAllEmployees() {

        Employees employees = new Employees();
        employees.setEmployees(service.getAllEmployees());
        System.out.println("Displayed all employees!!");
        return ResponseEntity.ok().body(employees);
    }

    @PostMapping(value = "/deleteEmployee")
        public void deleteEmployee(@RequestBody Employee employee){
        service.deleteEmployee(employee);
        System.out.println("Deleted employee!!");
    }



}

