//CRUD SERVICES - required in implementing CRUD - includes: setObject, getObject, deleteObject
package com.sogeti.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sogeti.employee.model.Employee;
import com.sogeti.employee.repository.EmployeeRepository;

@Service
public class CrudService{
    @Autowired
    EmployeeRepository employeeRepository;

    //crud?
    public Employee addEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    //crud?
    public Employee getEmployee(Long id){
        return employeeRepository.findEmployeeById(id);
    }

    //crud?
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    //crud?
    public int deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return 200;//success
    }

    //crud?
    public Employee getEmployeeByName(String name){
        return employeeRepository.findEmployeeByNameEquals(name);
    }
}
