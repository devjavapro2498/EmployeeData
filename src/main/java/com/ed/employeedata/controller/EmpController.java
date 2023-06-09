package com.ed.employeedata.controller;
import com.ed.employeedata.entity.EmpEntity;
import com.ed.employeedata.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping("/")
    public String getEmpList(Model model) {
        List<EmpEntity> emp = empService.getAllEmp();
        model.addAttribute("emp", emp);
        return "index";
    }

    @GetMapping("/addEmp")
    public String AddEmp() {

        return "addEmp";
    }

    @PostMapping("/register")
    public String registerEmp(@ModelAttribute EmpEntity empEntity, HttpSession session) {
        empService.addEmp(empEntity);
        session.setAttribute("message", "Employee Added Successfully");

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String getDetailsParticularEmpId(@PathVariable int id, Model model) {
        EmpEntity emp = empService.getDetailsById(id);
        model.addAttribute("emp", emp);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmployeeDataForParticularId(@ModelAttribute EmpEntity empEntity, HttpSession session) {
        empService.addEmp(empEntity);
        session.setAttribute("message", "Employee Data Updated Successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployeeDataForParticularId(@PathVariable int id, HttpSession session) {
        empService.deleteEmpById(id);
        session.setAttribute("message","Employee Data Deleted Successfully");
        return "redirect:/";

    }
}