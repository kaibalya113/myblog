package com.myblog.main.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageController {

    @GetMapping({"/"})
    public ModelAndView index(Model model){
        ModelAndView mv = new ModelAndView("index");
        ResponseEntity<String> s = new ResponseEntity<>(HttpStatus.ACCEPTED); 
        model.addAttribute("name", "hello");
        System.out.println(s.getBody());
        model.addAttribute("status", s.getStatusCodeValue());
        //log.info("calling......");
       
        return mv;
    }
    @GetMapping({"dashboard"})
    public ModelAndView dashboard(Model model){
        ModelAndView mv = new ModelAndView("dashboard");
       
        
       
        return mv;
    }
}
