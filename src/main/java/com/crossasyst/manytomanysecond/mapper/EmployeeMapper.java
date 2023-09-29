package com.crossasyst.manytomanysecond.mapper;


import com.crossasyst.manytomanysecond.entity.EmployeeEntity;
import com.crossasyst.manytomanysecond.model.EmployeeRequest;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    public EmployeeEntity modelToEntity(EmployeeRequest employeeRequest);

    public EmployeeRequest entityToModel(EmployeeEntity employeeEntity);

    public List<EmployeeRequest> entityToModels(List<EmployeeEntity> employeeEntity);

}
