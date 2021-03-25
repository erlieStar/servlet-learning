package com.javashitang.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String location = sc.getInitParameter("configLocation");
        System.out.println(location);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
