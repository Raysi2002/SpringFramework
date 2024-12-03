package com.raysi.simplespringbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    
    @RequestMapping("/login")
    @ResponseBody
    public String loginPage(){
        return  "<h1>Login page</h1>";
    }
}
