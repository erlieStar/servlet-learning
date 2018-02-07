package com.makenv.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//注意加上/
@WebServlet("/cookietest.do")
public class CookieTest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Cookie cookie = new Cookie("username", username);
        //在客户端上存活30分钟
        cookie.setMaxAge(30 * 60);
        resp.addCookie(cookie);

        HttpSession session = req.getSession();
        //设置会话的有效时间为30 * 60
        session.setMaxInactiveInterval(30 * 60);
        session.setAttribute("password", password);

        RequestDispatcher view = req.getRequestDispatcher("cookieresult.jsp");
        view.forward(req, resp);
    }
}
