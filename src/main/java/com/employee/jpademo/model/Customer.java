package com.employee.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Constraint;

@Getter
@Setter
@Entity
@Table(name= "customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Master{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    @Column
    private double expenses;

    @Column
    private int mob_num;
}
