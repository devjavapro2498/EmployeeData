package com.ed.employeedata.service;

import com.ed.employeedata.entity.EmpEntity;
import com.ed.employeedata.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmpRepo empRepo;
    public void addEmp(EmpEntity empEntity){
        empRepo.save(empEntity);
    }


   public List<EmpEntity> getAllEmp(){
       return empRepo.findAll();
    }

}
