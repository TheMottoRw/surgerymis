package com.op.surgerymis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UiController {
    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String uiPage(){
        return "dashboard";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "login";
    }

}
