package com.raysi.simplespringbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignupController {

    @RequestMapping("/signup")
    @ResponseBody
    public String loginPage(){
        return  "<h1>Signup page</h1>";
    }
}
