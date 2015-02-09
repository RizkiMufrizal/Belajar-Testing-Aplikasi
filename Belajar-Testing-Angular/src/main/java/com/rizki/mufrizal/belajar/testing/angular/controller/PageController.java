package com.rizki.mufrizal.belajar.testing.angular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    
}
