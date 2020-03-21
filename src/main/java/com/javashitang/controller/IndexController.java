package com.javashitang.controller;

import com.javashitang.annotation.Controller;
import com.javashitang.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("user")
    public String user() {
        return "user";
    }
}
