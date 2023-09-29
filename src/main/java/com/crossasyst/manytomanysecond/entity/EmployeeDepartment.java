package com.crossasyst.manytomanysecond.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_Id")
    private EmployeeEntity employees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_Id")
    private DepartmentEntity departments;
}
