package com.example.crud_api.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud_api.model.Employee;
import com.example.crud_api.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id);
    }

    public void addEmployee(Employee employee) {
        repository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        repository.update(employee);
    }

    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
