package com.demoproject.employeeAPI;

import com.demoproject.employeeAPI.model.Employee;
import com.demoproject.employeeAPI.model.Employees;
import com.demoproject.employeeAPI.model.Role;
import com.demoproject.employeeAPI.model.Roles;
import com.demoproject.employeeAPI.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        System.out.println("Got all employees!!");
        Roles roles = new Roles();
        roles.setRoles(service.getAllRoles());
        for (Employee employee : employees.getEmployees()){
            for (Role role : roles.getRoles()){
                if (employee.getSalary() > role.getBandMin() && employee.getSalary() < role.getBandMax()){
                    employee.setRole(role.getRoleName());
                }
            }
            if (employee.getRole() == null || employee.getRole().equals("")){
                employee.setRole("fired");
            }
        }
        return ResponseEntity.ok().body(employees);
    }




    @PostMapping(value = "/deleteEmployee")
        public void deleteEmployee(@RequestBody Employee employee){
        service.deleteEmployee(employee);
        System.out.println("Deleted employee!!");
    }

    @PutMapping(value =  "/updateEmployee")
        public void updateEmployee(@RequestBody Employee employee){
        service.updateEmployee(employee);
        System.out.println("Update employee!!");
    }

    @GetMapping(value = "/allRoles")
    public ResponseEntity<Roles> getAllRoles() {

        Roles roles = new Roles();
        roles.setRoles(service.getAllRoles());
        System.out.println("Displayed all roles!!");
        return ResponseEntity.ok().body(roles);
    }



}

