package com.sogeti.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sogeti.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public Employee findEmployeeById(Long id);
    public Employee findEmployeeByNameEquals(String name);
    public void deleteById(Long id);
}