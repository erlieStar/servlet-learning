package com.javashitang.listener;

import com.javashitang.model.Dog;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    /*
     * 监听器，上下文初始化时加载一些属性类，如数据库连接
     */
    public void contextInitialized(ServletContextEvent sce) {
        //由事件得到ServletContext
        ServletContext sc = sce.getServletContext();
        String dogBreed = sc.getInitParameter("breed");
        Dog d = new Dog(dogBreed);
        sc.setAttribute("dog", d);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
