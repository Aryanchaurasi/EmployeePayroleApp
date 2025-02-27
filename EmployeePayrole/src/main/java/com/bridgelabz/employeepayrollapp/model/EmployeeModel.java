package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Valid
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @NotBlank(message = "Name cannot be empty")
    public String name;
    @NotBlank(message = "Department cannot be empty")
    public String department;
    @NotBlank(message = "Sallary cannot be empty")
    public double salary;

//    // Constructors
//    public EmployeeModel() {}
//
//    public EmployeeModel(String name, String department, double salary) {
//        this.name = name;
//        this.department = department;
//        this.salary = salary;
//    }
//
//    // Getters & Setters
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
}
