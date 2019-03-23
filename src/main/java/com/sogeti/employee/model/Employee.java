//EMPLOYEE CLASS - for handling employee object
package com.sogeti.employee.model;

import javax.persistence.*;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}