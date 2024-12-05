package com.example.crud_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crud_api.model.Employee;
import com.example.crud_api.service.EmployeeService;
import com.example.crud_api.utils.ApiResponse;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    private final String APP_NAME = "service employee";
    private final String VERSION = "1.1.0";

    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        ApiResponse<List<Employee>> response = new ApiResponse<>(
            APP_NAME,
            VERSION,
            "Employees fetched successfully.",
            employees
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@PathVariable int id) {
        Employee employee = service.getEmployeeById(id);
        ApiResponse<Employee> response = new ApiResponse<>(
            APP_NAME,
            VERSION,
            employee != null ? "Employee details fetched successfully." : "Employee not found.",
            employee
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addEmployee(@RequestBody Employee employee) {
        service.addEmployee(employee);
        ApiResponse<String> response = new ApiResponse<>(
            APP_NAME,
            VERSION,
            "Employee added successfully.",
            null
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employee.setId(id);
        service.updateEmployee(employee);
        ApiResponse<String> response = new ApiResponse<>(
            APP_NAME,
            VERSION,
            "Employee updated successfully.",
            null
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        ApiResponse<String> response = new ApiResponse<>(
            APP_NAME,
            VERSION,
            "Employee deleted successfully.",
            null
        );
        return ResponseEntity.ok(response);
    }
}
