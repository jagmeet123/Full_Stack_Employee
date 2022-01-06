package net.springbootbackend.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.springbootbackend.springbootbackend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
