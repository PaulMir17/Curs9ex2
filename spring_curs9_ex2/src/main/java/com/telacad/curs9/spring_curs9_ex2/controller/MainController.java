package com.telacad.curs9.spring_curs9_ex2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/api")
public class MainController {

    @GetMapping("/hello")
    public String hello(){

        return "Hello World";
    }
}
