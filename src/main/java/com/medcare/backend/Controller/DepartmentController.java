package com.medcare.backend.Controller;

//


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.Model.Department;
import com.medcare.backend.Service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*") 

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public Department register(@RequestBody Department department) {
        //calls the service
        return departmentService.saveDepartment(department);
    }
}


