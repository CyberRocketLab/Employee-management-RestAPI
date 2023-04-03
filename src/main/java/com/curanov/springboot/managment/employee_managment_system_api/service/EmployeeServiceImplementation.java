package com.curanov.springboot.managment.employee_managment_system_api.service;

import com.curanov.springboot.managment.employee_managment_system_api.dao.EmployeeRepository;
import com.curanov.springboot.managment.employee_managment_system_api.entity.Employee;
import com.curanov.springboot.managment.employee_managment_system_api.exception.EmployeeServiceException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> showAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        if (employeeList.isEmpty()) {
            throw new EmployeeServiceException("The are no Employees in the Database!");
        }

        return employeeList;
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeServiceException("Employee with ID:" + id + " not found!"));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeServiceException("Cannot Delete Employee with ID: " + id + ". Employee not found!")
        );
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllBySurname(String surname) {
        List<Employee> employeeList =
                employeeRepository.findAllBySurname(surname);

        if (employeeList.isEmpty()) {
            throw new EmployeeServiceException("There are no Employees with SURNAME: " + surname);
        }

        return employeeList;
    }

    @Override
    public List<Employee> findEmployeeSalaryLessThan(int salary) {
        List<Employee> employeeList = employeeRepository.findAllBySalaryLessThan(salary);

        if (employeeList.isEmpty()) {
            throw new EmployeeServiceException("There is no Employee salary less then: " + salary);
        }

        return employeeList;
    }


}
