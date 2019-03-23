package com.sogeti.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.employee.model.Employee;
import com.sogeti.employee.services.CrudService;

@RestController
public class CrudController
{
    @Autowired
    CrudService crudService;

    @GetMapping(value="/employees/showAllEmployees")
    public List<Employee> getAllEmployees(){
    	
    	return crudService.getEmployees();
    }

    @PostMapping(value={"/employees/addEmployee"})
    public Employee addEmployee(@RequestBody Employee employee){
        return crudService.addEmployee(employee);
    }


    @PutMapping(value={"/employees/updateEmployee/{id}"})
    public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") Long id)
    {
        Employee employee = crudService.getEmployee(id);
        if(employee == null)
        {
            return crudService.addEmployee(emp);
        }
        else 
        {
            employee.setName(emp.getName());
            return crudService.addEmployee(employee);
        }
    }

    @DeleteMapping(value={"/employees/deleteEmployee/{id}"})
    public int deleteEmployee(@PathVariable("id") Long id){
        return crudService.deleteEmployee(id);
    }

    @GetMapping(value={"/employees/getEmployeeById/{id}"})
    public @ResponseBody
    Employee getEmployee(@PathVariable("id") Long id){
        return crudService.getEmployee(id);
    }


    @GetMapping(value="/employees/getEmployeeByName/{name}")
    public Employee getEmployeeByName(@PathVariable String name){
        return crudService.getEmployeeByName(name);
    }
}
