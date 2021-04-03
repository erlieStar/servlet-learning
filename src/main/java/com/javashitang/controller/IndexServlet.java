package com.javashitang.controller;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns="/index", initParams = {
        @WebInitParam(name = "library.name", value = "javashitang")
})
public class IndexServlet extends HttpServlet {

    private String libraryName;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.libraryName = config.getInitParameter("library.name");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("welcome to " + libraryName + " library");
    }
}
