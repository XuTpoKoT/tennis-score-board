package com.tsb.controller;

import com.tsb.util.JspPath;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

import java.io.IOException;

@WebFilter("/*")
@Log
public class ErrorHandlingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            // Проход цепочки фильтров
            chain.doFilter(request, response);
        } catch (Exception e) {
            // Обработка исключения
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            // Установка атрибута с сообщением об ошибке
            httpRequest.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
            log.info(e.getMessage());

            // Перенаправление на страницу ошибок
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(JspPath.getPathJsp("error"));
            dispatcher.forward(httpRequest, httpResponse);
        }
    }

    @Override
    public void destroy() {}
}
