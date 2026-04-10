package com.medcare.backend.Service;

import com.medcare.backend.DTO.DepartmentDTO;
import com.medcare.backend.Model.Department;
import com.medcare.backend.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

   

    public DepartmentDTO getDepartmentById(Integer id){
        Department department = departmentRepository.findById(id).orElseThrow();

        return new DepartmentDTO(
            department.getId(),
            department.getName(),
            department.getConsultationFee()
        );
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

  

    
    public Department createDepartment(DepartmentDTO dto) {
        Department department = new Department();
        
        
        department.setName(dto.getName());
        department.setConsultationFee(dto.getConsultationFee());
        
        return departmentRepository.save(department);
    }

    
    public Department updateDepartment(Integer id, DepartmentDTO dto) {
    
        Department existingDepartment = departmentRepository.findById(id).orElseThrow();

        
        if (dto.getName() != null) {
            existingDepartment.setName(dto.getName());
        }
        
        if (dto.getConsultationFee() != null) { 
            existingDepartment.setConsultationFee(dto.getConsultationFee());
        }

        return departmentRepository.save(existingDepartment);
    }
}