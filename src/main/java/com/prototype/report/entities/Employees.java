package com.prototype.report.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees")
public class Employees implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employee_id;

    @Column
    private String employee_name;

    @Column
    private double salary;

    @ManyToOne
    @JoinColumn(name="department_id", referencedColumnName = "department_id")
    private Department department;

    public Employees(){
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
