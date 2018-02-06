package com.makenv.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TestInitParams extends HttpServlet {

    /*
     * 获取servlet参数和应用上下文参数
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("test init parameters<br>");

        Enumeration e = getServletConfig().getInitParameterNames();

        while (e.hasMoreElements()) {
            out.println("<br>servlet param name = " + e.nextElement() + "<br>");
        }

        //获取servlet初始化参数
        out.println("servlet amdin email is " + getServletConfig().getInitParameter("adminEmail"));
        out.println("<br>");
        //获取上下文初始化参数
        out.println("context admin email is " + getServletContext().getInitParameter("adminEmail"));
        out.println("<br>");
        out.println("servlet main email is " + getServletConfig().getInitParameter("mainEmail"));
    }
}
