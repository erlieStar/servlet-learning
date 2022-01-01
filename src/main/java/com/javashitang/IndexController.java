package com.javashitang;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lilimin
 * @since 2022-01-01
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
