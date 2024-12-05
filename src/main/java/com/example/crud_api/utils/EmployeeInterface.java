package com.example.crud_api.utils;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.crud_api.model.Employee;

public interface EmployeeInterface {

    ResponseEntity<List<Employee>> getAllEmployees();

    ResponseEntity<Employee> getEmployeeById(@PathVariable int id);

    ResponseEntity<String> addEmployee(@RequestBody Employee employee);

    ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employee);

    ResponseEntity<String> deleteEmployee(@PathVariable int id);

}
