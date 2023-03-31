package com.curanov.springboot.managment.employee_managment_system_api.dao;

import com.curanov.springboot.managment.employee_managment_system_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllBySurname(String name);
    public List<Employee> findAllBySalaryLessThan(int salary);
}
