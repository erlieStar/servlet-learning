package com.makenv.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//注意加上/
@WebServlet("/checkcookie.do")
public class CheckCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();

        for (int i=0; i<cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("username")) {
                String username = cookie.getValue();
                out.println("Hello " + username);
                break;
            }
        }

        HttpSession session = req.getSession();
        out.println("your password is " + session.getAttribute("password"));
    }
}
