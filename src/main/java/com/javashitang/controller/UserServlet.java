package com.javashitang.controller;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {

    private String helloWord;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.helloWord = config.getInitParameter("helloWord");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String userId = req.getParameter("userId");
        out.println(helloWord + " " + userId);
    }
}
