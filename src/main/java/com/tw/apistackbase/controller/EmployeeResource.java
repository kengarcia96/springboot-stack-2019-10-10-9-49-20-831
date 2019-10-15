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

    @PostMapping(path = "/employee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employees) {
        employeeList.add(employees);
        return ResponseEntity.ok("Added Member:" + employees.getName());
    }



    @DeleteMapping(path = "/employee/remove/{id}")
    public ResponseEntity<Integer> removeEmployee(@PathVariable Integer id) {

//        Employee ids = null;
        for(Employee ids : employeeList){
            if(ids.getId() == (id))
                ids.remove(ids);
        }

//        employeeList.remove(id);
//        return ResponseEntity.ok("Removed Member");
        return ResponseEntity.ok(id);
    }


    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeList);
    }

}
