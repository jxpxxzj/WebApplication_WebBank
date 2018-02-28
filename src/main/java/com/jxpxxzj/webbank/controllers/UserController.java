package com.jxpxxzj.webbank.controllers;

import com.jxpxxzj.webbank.auth.AuthPassport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @AuthPassport
    @RequestMapping("/user/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @AuthPassport
    @RequestMapping("/user/remaining")
    public ModelAndView remaining() {
        return new ModelAndView("remaining");
    }
}
