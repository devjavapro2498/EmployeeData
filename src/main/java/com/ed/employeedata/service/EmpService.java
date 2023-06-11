package com.ed.employeedata.service;

import com.ed.employeedata.entity.EmpEntity;
import com.ed.employeedata.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    EmpRepo empRepo;

    public void addEmp(EmpEntity empEntity) {
        empRepo.save(empEntity);
    }


    public List<EmpEntity> getAllEmp() {

        return empRepo.findAll();
    }

    public EmpEntity getDetailsById(int id) {
        Optional<EmpEntity> emp = empRepo.findById(id);
        if (emp.isPresent()) {
            return emp.get();
        }
        return null;
    }
public void deleteEmpById(int id) {
      empRepo.deleteById(id);
}
}
