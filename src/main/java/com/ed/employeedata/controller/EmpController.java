package com.ed.employeedata.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {
    @GetMapping("/")
    String getEmpList(){

        return "index";
    }
}
