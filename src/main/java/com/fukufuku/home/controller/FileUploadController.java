package com.fukufuku.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileUploadController {

    @GetMapping("/hello")
    public String hello() {
        return "fileUpload";
    }
}
