package com.employee.jpademo.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "employees")
public class Employee extends Master{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private int salary;

    public String myName(){
        Employee e= new Employee();
        return e.getName();
    }
}

