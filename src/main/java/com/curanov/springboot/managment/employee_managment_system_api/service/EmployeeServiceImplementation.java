package com.curanov.springboot.managment.employee_managment_system_api.service;

import com.curanov.springboot.managment.employee_managment_system_api.dao.EmployeeRepository;
import com.curanov.springboot.managment.employee_managment_system_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> showAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> optionalEmployee =
                employeeRepository.findById(id);

        if (optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
        }
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllBySurname(String surname) {
        List<Employee> employeeList =
                employeeRepository.findAllBySurname(surname);
        return employeeList;
    }

    @Override
    public List<Employee> findEmployeeSalaryLessThan(int salary) {
        return employeeRepository.findAllBySalaryLessThan(salary);
    }


}
