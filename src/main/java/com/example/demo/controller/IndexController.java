package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        var a = Aaa.builder().content("test").build();
        return a.toString();
    }
    
}
