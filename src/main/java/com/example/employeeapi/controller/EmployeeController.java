package com.example.employeeapi.controller;

import com.example.employeeapi.datasource.EmployeeRepository;
import com.example.employeeapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    String getEmployees(Model model) {
        List<Employee> employees = employeeRepository.getAllEmployees();
        model.addAttribute("message", "hello world");
        model.addAttribute("employees", employees);
        return "employees";
    }


    @GetMapping("/{id}")
    ResponseEntity getEmployee(@PathVariable("id") int id) {
        return new ResponseEntity<>(employeeRepository.getEmployee(id), HttpStatus.OK);
    }
}
