package com.makenv.controller;

import com.makenv.model.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BeerSelect2 extends HttpServlet {

    /*
     * servlet和jsp的使用
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String c = req.getParameter("color");
        BeerExpert be = new BeerExpert();
        List result = be.getBrands(c);

        //为请求对象增加一个属性，供JSP使用
        req.setAttribute("styles", result);

        //为JSP实例化一个请求分派器
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        //使用请求分派器要求容器准备好JSP，并向JSP发送请求和响应
        view.forward(req, resp);
    }

}
