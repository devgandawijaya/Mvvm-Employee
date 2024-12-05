package com.example.crud_api.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.crud_api.model.Employee;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper to map result set to Employee object
    private RowMapper<Employee> rowMapper = (rs, rowNum) -> {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setPosition(rs.getString("position"));
        employee.setSalary(rs.getDouble("salary"));
        return employee;
    };

    public List<Employee> findAll() {
        String sql = "SELECT id, name, position, salary FROM public.employee";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Employee findById(int id) {
        String sql = "SELECT id, name, position, salary FROM public.employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public int save(Employee employee) {
        String sql = "INSERT INTO public.employee (name, position, salary) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, employee.getName(), employee.getPosition(), employee.getSalary());
    }

    public int update(Employee employee) {
        String sql = "UPDATE public.employee SET name = ?, position = ?, salary = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getPosition(), employee.getSalary(), employee.getId());
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM public.employee WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
