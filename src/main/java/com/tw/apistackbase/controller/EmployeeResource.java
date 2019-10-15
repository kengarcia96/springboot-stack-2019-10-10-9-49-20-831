package com.tw.apistackbase.controller;

import com.tw.apistackbase.domain.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class EmployeeResource {

    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeList);
    }

    @PostMapping(path = "/employee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employees) {
        employeeList.add(employees);
        return ResponseEntity.ok("Added Employee:" + employees.getName());
    }

    @DeleteMapping(path = "/employee/remove/{id}", produces = {"application/json"})
    public ResponseEntity<String> removeEmployee(@PathVariable Integer id) {

        Employee employeeID = employeeList.stream().filter(employee -> id == employee.getId()).findFirst().orElse(null);
        employeeList.remove(employeeID);

        return ResponseEntity.ok("Deleted Employee Record: " + employeeID.getName());
    }

    @PutMapping(path = "/employee/update/{id}", produces = {"application/json"})
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {

        Employee employeeID = employeeList.stream().filter(employeeRecord -> id == employeeRecord.getId()).findFirst().orElse(null);
        employeeList.remove(employeeID);
        employeeList.add(employee);

        return ResponseEntity.ok("Updated Employee Record: " + employee.getName());
    }




}
