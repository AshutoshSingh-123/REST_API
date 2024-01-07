package com.ashutosh.rest.restapp.controllers;

import com.ashutosh.rest.restapp.entity.Employee;
import com.ashutosh.rest.restapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> employee(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> employee(@PathVariable Long id){

        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<HttpStatus> save(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/employees")
    public ResponseEntity<HttpStatus> update(@RequestBody Employee employee){
        employeeService.update(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
