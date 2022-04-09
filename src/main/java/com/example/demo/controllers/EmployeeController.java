package com.example.demo.controllers;

import com.example.demo.entities.Employee;
import com.example.demo.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepo eRepo;

    @GetMapping("/")
    public ModelAndView show(){
        ModelAndView mav = new ModelAndView("list");
        List<Employee> list = eRepo.findAll();
        mav.addObject("employees", list);
        return mav;
    }
}
