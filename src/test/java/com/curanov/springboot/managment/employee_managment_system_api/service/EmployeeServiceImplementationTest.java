package com.curanov.springboot.managment.employee_managment_system_api.service;

import com.curanov.springboot.managment.employee_managment_system_api.dao.EmployeeRepository;
import com.curanov.springboot.managment.employee_managment_system_api.entity.Employee;
import com.curanov.springboot.managment.employee_managment_system_api.exception.EmployeeServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

class EmployeeServiceImplementationTest {

    @Mock // Creating Mock Object
    EmployeeRepository employeeRepository;
    @InjectMocks // Inserting Mock Objects
    EmployeeServiceImplementation serviceImplementation;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    // Testing showAllEmployees() method
    @Test
    void testShowAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Doe", "IT","john.doe@gmail.com", 10000),
                new Employee("Jane", "Doe", "IT","jane.doe@gmail.com", 20000)
        );

        // Mock the repository to return a list of employees
        when(employeeRepository.findAll()).thenReturn(employees);

        // Call the tested method
        List<Employee> result = serviceImplementation.showAllEmployees();

        // Verify that the result matches the expected list of employees
        Assertions.assertEquals(employees,result);
    }

    // Testing showAllEmployees() method when Empty
    @Test
    void testShowAllEmployeesWhenEmpty() {
        // Mock the repository to return an empty list
        when(employeeRepository.findAll()).thenReturn(Arrays.asList());

        EmployeeServiceException exception =
                Assertions.assertThrows(EmployeeServiceException.class, () -> {
                    serviceImplementation.showAllEmployees();
                });

        Assertions.assertEquals("The are no Employees in the Database!", exception.getMessage());

    }

    // Testing getEmployee() method
    @Test
    void testGetEmployee() {
        Employee mockEmployee = new Employee("John", "Doe",
                "IT","john.doe@gmail.com", 10000);
        mockEmployee.setId(1);

        // Mock the repository to return an mockEmployee
        when(employeeRepository.findById(1)).thenReturn(Optional.of(mockEmployee));

        // Call the tested method
        Employee result = serviceImplementation.getEmployee(1);

        // Verify that the employeeRepository.findById() method was called with the correct ID
        verify(employeeRepository).findById(1);

        Assertions.assertEquals(mockEmployee, result);
    }

    // Testing getEmployee() method when Empty
    @Test
    void testGetEmployeeIsEmpty() {
        int id = 1;

        // Mock the repository to return an empty Employee
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        EmployeeServiceException exception =
                Assertions.assertThrows(EmployeeServiceException.class, () -> {
                    serviceImplementation.getEmployee(id);
                });

        Assertions.assertEquals("Employee with ID:" + id + " not found!", exception.getMessage());

    }

    // Testing saveEmployee() method
    @Test
    void testSaveEmployee() {
        Employee mockEmployee = new Employee("John", "Doe",
                "IT","john.doe@gmail.com", 10000);
        mockEmployee.setId(1);

        // Saving mockEmployee
        when(employeeRepository.save(mockEmployee)).thenReturn(mockEmployee);

        //Saving Employee
        Employee result = serviceImplementation.saveEmployee(mockEmployee);

        Assertions.assertEquals(mockEmployee, result);
    }

    // Testing testSaveEmployee() when it should update
    @Test
    void testSaveEmployeeUpdate() {
        // create a mock employee and save it
        Employee mockEmployee = new Employee("John", "Doe", "IT", "john.doe@gmail.com", 10000);
        mockEmployee.setId(1);
        when(employeeRepository.save(mockEmployee)).thenReturn(mockEmployee);
        Employee savedEmployee = serviceImplementation.saveEmployee(mockEmployee);

        // update the mock employee
        mockEmployee.setName("Jane");
        mockEmployee.setSalary(15000);

        // update the saved employee and verify that the changes are saved
        when(employeeRepository.save(mockEmployee)).thenReturn(mockEmployee);
        Employee updatedEmployee = serviceImplementation.saveEmployee(mockEmployee);

        Assertions.assertEquals(mockEmployee, updatedEmployee);
    }

}