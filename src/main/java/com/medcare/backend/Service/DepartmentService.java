package com.medcare.backend.Service;

import com.medcare.backend.Model.Department;
import com.medcare.backend.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }


}
