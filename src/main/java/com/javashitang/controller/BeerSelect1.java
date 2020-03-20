package com.javashitang.controller;

import com.javashitang.model.BeerExpert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class BeerSelect1 extends HttpServlet {

    /*
     * servlet的基本使用
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //使用doPost来处理Http请求，因为Html表单指出method = POST
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Beer Selection Advice<br>");
        String colorValue = req.getParameter("color");
        BeerExpert be = new BeerExpert();
        List result = be.getBrands(colorValue);
        Iterator it = result.iterator();
        while (it.hasNext()) {
            out.print("<br>try: " + it.next());
        }
    }
}
