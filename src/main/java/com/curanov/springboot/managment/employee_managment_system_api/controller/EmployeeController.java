package com.curanov.springboot.managment.employee_managment_system_api.controller;

import com.curanov.springboot.managment.employee_managment_system_api.entity.Employee;
import com.curanov.springboot.managment.employee_managment_system_api.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.showAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "User with ID=" + id + " was deleted!";
    }

    @GetMapping("/employees/surname/{surname}")
    public List<Employee> showAllEmployeesBySurname(@PathVariable String surname) {
        return employeeService.findAllBySurname(surname);
    }

    @GetMapping("/employees/salary/{salary}")
    public List<Employee> showEmployeesSalaryLessThan(@PathVariable int salary) {
        return employeeService.findEmployeeSalaryLessThan(salary);
    }

}
