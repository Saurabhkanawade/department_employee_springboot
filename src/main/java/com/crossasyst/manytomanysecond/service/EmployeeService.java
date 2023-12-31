package com.crossasyst.manytomanysecond.service;


import com.crossasyst.manytomanysecond.entity.EmployeeEntity;
import com.crossasyst.manytomanysecond.mapper.EmployeeMapper;
import com.crossasyst.manytomanysecond.model.EmployeeRequest;
import com.crossasyst.manytomanysecond.model.EmployeeResponse;
import com.crossasyst.manytomanysecond.repository.DepartmentRepository;
import com.crossasyst.manytomanysecond.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;

    }

    public List<EmployeeRequest> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeRequest> employeeRequest = employeeMapper.entityToModels(employeeEntities);
        log.info("successfully get all data");
        return employeeRequest;
    }


    public EmployeeRequest getById(Long empId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
        EmployeeRequest employeeRequest = employeeMapper.entityToModel(employeeEntity);
        log.info("successfully get employee by Id");
        return employeeRequest;

    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = employeeRepository.save(employeeMapper.modelToEntity(employeeRequest));
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmpId(employeeEntity.getEmpId());
        log.info("successfully create employee");
        return employeeResponse;

    }

    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
        log.info("successfully delete employee");
    }

//    public EmployeeRequest updateEmployee(Long empId, EmployeeRequest employeeRequest) {
//        EmployeeEntity employeeEntity1 = employeeMapper.modelToEntity(employeeRequest);
//        employeeEntity1.setEmpId(empId);
//        employeeEntity1.getDepartment();
//        EmployeeEntity employeeEntity = employeeRepository.save(employeeEntity1);
//        log.info("successfully UpdateEmployee");
//
//        return employeeRequest;
//    }
//
//    public List<DepartmentRequest> findDepartmentByEmployeeId(Long employeeId) {
//        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
//        List<DepartmentEntity> departmentEntity = employeeEntity.getDepartment();
//        List<DepartmentRequest> departmentRequest = departmentMapper.entityToDeptModels(departmentEntity);
//        log.info("successfully get findDepartmentByEmployeeId ");
//
//        return departmentRequest;
//    }
//
//    public EmployeeRequest addDepartmentToEmployee(Long empId, Long deptId) {
//        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
//        DepartmentEntity departmentEntity = departmentRepository.findById(deptId).get();
//
//
//        List<DepartmentEntity> departments = employeeEntity.getDepartment();
//        departments.add(departmentEntity);
//        employeeRepository.save(employeeEntity);
//        log.info("successfully get all data");
//        return employeeMapper.entityToModel(employeeEntity);
//    }
//
//    public EmployeeRequest removeDepartmentFromEmployee(Long empId, Long deptId) {
//        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
//        DepartmentEntity departmentEntity = departmentRepository.findById(deptId).get();
//
//        List<DepartmentEntity> departments = employeeEntity.getDepartment();
//        departments.remove(departmentEntity);
//        employeeRepository.save(employeeEntity);
//        EmployeeRequest employeeRequest = employeeMapper.entityToModel(employeeEntity);
//        log.info("successfully get all data");
//        return employeeRequest;
//
//    }

}
