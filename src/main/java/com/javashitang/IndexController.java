package com.javashitang;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lilimin
 * @since 2022-01-01
 */
@RestController
public class IndexController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
