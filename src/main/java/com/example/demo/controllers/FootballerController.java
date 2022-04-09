package com.example.demo.controllers;


import com.example.demo.entities.Footballer;
import com.example.demo.repos.FootballerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FootballerController {

    @Autowired
    private FootballerRepo eRepo;

    @GetMapping({"/", "/main"})
    public ModelAndView show(){
        ModelAndView mav = new ModelAndView("list");
        List<Footballer> list = eRepo.findAll();
        mav.addObject("footballers", list);
        return mav;
    }

    @GetMapping("/addFootballerForm")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("adding-form");
        Footballer footballer = new Footballer();
        mav.addObject("new_footballer", footballer);
        return mav;
    }

    @PostMapping("/saveFootballer")
    public String saveFootballer(@ModelAttribute Footballer footballer){
        String name = footballer.getName();
        String fan = footballer.getFan_name();
        Integer number = footballer.getNumber();
        String team = footballer.getTeam();
        if (name.equals("")){
            return "adding-form";
        }
        if (fan.equals("")){
            footballer.setFan_name("Unknown");
        }
        if (number == null){
            footballer.setNumber(404);
        }
        if (team.equals("")){
            footballer.setTeam("Unknown");
        }
        eRepo.save(footballer);
        return "redirect:/main";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdate(@RequestParam Integer footballerId){
        Footballer footballer = eRepo.findById(footballerId).get();
        ModelAndView mav = new ModelAndView("update-form");
        mav.addObject("footballer", footballer);
        return mav;
    }

    @PostMapping("/updateFootballer")
    public String update(@ModelAttribute Footballer footballer){
        eRepo.save(footballer);
        return "redirect:/main";
    }
}
