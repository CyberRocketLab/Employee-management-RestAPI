package com.curanov.springboot.managment.employee_managment_system_api.service;

import com.curanov.springboot.managment.employee_managment_system_api.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> showAllEmployees();

    public Employee getEmployee(int id);

    public Employee saveEmployee(Employee employee);

    public void deleteEmployee(int id);

    public List<Employee> findAllBySurname(String surname);

    public List<Employee> findEmployeeSalaryLessThan(int salary);


}
