package com.curanov.springboot.managment.employee_managment_system_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @NotBlank(message = "Name is required field")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "Surname is required field")
    @Size(min = 2, max = 50, message = "Surname should be between 2 and 50 characters")
    private String surname;
    @Column(name = "department")
    @NotBlank(message = "Department is required field")
    private String department;
    @Column(name = "email")
    @NotBlank(message = "Email is required field")
    @Email(message = "Email should be valid!")
    private String email;
    @Column(name = "salary")
    @NotNull(message = "Salary is required field")
    @Min(value = 999, message = "Salary should be more than 1000 Euro")
    private int salary;

    public Employee() {
    }

    public Employee(String name, String surname, String department, String email, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.email = email;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
