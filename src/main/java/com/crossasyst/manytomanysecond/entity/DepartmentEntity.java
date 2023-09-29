package com.crossasyst.manytomanysecond.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employeeDepartments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;
    @Column(name = "dept_Name")
    private String deptName;

    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private List<EmployeeDepartment> employeeDepartments;
}
