/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpasecondarytable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ilkinabdullayev
 */
@Entity
@Table(name = "EMPLOYEE")
@SequenceGenerator(name = "EMPLOYEE_ID_SEQ",sequenceName = "EMPLOYEE_ID_SEQ",allocationSize = 50)
@SecondaryTable(name="EMPLOYEE_DETAILS",pkJoinColumns = {@PrimaryKeyJoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "EMP_ID")})
public class Employee {
    
    @Id
    @GeneratedValue(generator = "EMPLOYEE_ID_SEQ",strategy = GenerationType.SEQUENCE)
    @Column(name = "EMP_ID")
    private int employeeId;
    
    @Column(name = "FIRST_NAME")
    private String firstname;
    
    @Column(name = "LAST_NAME")
    private String lastname;
    
    @Column(name = "EMAIL",table = "EMPLOYEE_DETAILS")
    private String email;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "JOINING_DATE",table = "EMPLOYEE_DETAILS")
    private Date joiningDate;
    
    @Column(table = "EMPLOYEE_DETAILS")
    private double salary;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
