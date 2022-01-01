package com.javashitang;

import lombok.SneakyThrows;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

/**
 * @author lilimin
 * @since 2022-01-01
 */
public class MyTest {

    @SneakyThrows
    public static void main(String[] args) {
        String contextPath = "/";
        Tomcat tomcat = new Tomcat();
        String baseDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        tomcat.setBaseDir(baseDir);
        tomcat.setPort(8080);
        tomcat.addWebapp(contextPath, baseDir);
        tomcat.addServlet("/", "dis", new MyServlet());
        tomcat.start();
        tomcat.getServer().await();
    }
}
