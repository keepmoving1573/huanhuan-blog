package com.huan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by ptmind on 2016/5/21.
 */
@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "Hello World");
        return "welcome";
    }

}