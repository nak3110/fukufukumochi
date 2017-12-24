package com.fukufuku.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String helloAdmin(Model model){
        model.addAttribute("message", "Hello Thymeleaf!!");
        return "admin";
    }
}