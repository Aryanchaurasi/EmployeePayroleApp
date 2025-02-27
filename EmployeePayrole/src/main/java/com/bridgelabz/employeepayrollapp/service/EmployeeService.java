package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeService {
    private final Map<Integer, EmployeeModel> employeeMap = new HashMap<>();
    public final EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository) {

        this.repository = repository;
    }
    public List<EmployeeModel> getAllEmployees() {
        log.info("Fetching all Employees");
        return repository.findAll();
    }

    public Optional<EmployeeModel> getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}",id);
        return repository.findById(id);
    }
    public EmployeeModel updateEmployee(Long id, EmployeeModel updatedEmployee) {
        log.info("Fetching employee with ID: {}",id);
        return repository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setSalary(updatedEmployee.getSalary());
            log.info("Updated employee details: {}",employee);
            return repository.save(employee);
        }).orElseThrow(() -> {
            log.error("Employee with ID {} not found",id);
            return new RuntimeException("Employee not found");
        });
    }
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with ID: {}",id);
        repository.deleteById(id);
    }


    public EmployeeModel getEmployeeById(int id) {
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
        }
        return employeeMap.get(id);
    }

    public EmployeeModel addEmployee(EmployeeModel employeeDTO) {
        int newId = employeeMap.size() + 1;
        employeeMap.put(newId, employeeDTO);
        return employeeDTO;
    }
}