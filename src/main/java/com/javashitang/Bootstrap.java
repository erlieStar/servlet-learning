package com.javashitang;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lilimin
 * @since 2022-01-01
 */
@Configuration
@ComponentScan("com.javashitang")
public class Bootstrap {

    public static void main(String[] args) {
        Application.run(Bootstrap.class);
        System.out.println("ccc");
    }
}
