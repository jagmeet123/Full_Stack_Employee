package net.springbootbackend.springbootbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.springbootbackend.springbootbackend.Exceptions.ResourceNotFound;
import net.springbootbackend.springbootbackend.model.Employee;
import net.springbootbackend.springbootbackend.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;

import java.io.Console;
import java.util.*;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/create-Employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        System.out.println("employess:" + employee);
        return employeeRepository.save(employee);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Employee with id: " + id + " not found"));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/update-employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Employee not found"));
        System.out.println("updateEmployee" + updateEmployee.getFirstName() + employeeDetails.getFirstName());

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Employee Not found"));
        employeeRepository.delete(employee);
        List<Employee> AllEmployee = employeeRepository.findAll();
        return ResponseEntity.ok(AllEmployee);
    }

}
