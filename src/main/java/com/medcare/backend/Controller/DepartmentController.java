package com.medcare.backend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.DTO.DepartmentDTO;
import com.medcare.backend.Model.Department;
import com.medcare.backend.Service.DepartmentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*") 

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    
    @PostMapping("/add")
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody DepartmentDTO dto) {
        Department savedDepartment = departmentService.createDepartment(dto);
        return ResponseEntity.ok(savedDepartment);
    }

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Integer id) {
        try {
            DepartmentDTO department = departmentService.getDepartmentById(id);
            return ResponseEntity.ok(department);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }

    
    @PatchMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Integer id, @Valid @RequestBody DepartmentDTO dto) {
        try {
            Department updatedDepartment = departmentService.updateDepartment(id, dto);
            return ResponseEntity.ok(updatedDepartment);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}


