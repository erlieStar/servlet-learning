package com.javashitang.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ResponseWrite {

    public static void writeResult(HttpServletResponse response, String msg) {
        try {
            response.reset();
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(msg);
        } catch (Exception e) {
            log.error("http response write exception, result is: {}", msg);
        }
    }
}
