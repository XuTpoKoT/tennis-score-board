package com.tsb.controller;

import com.tsb.util.JspPath;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet("/main")
@Slf4j
public class MainPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("MainPageController");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(JspPath.getPathJsp("main"));
        requestDispatcher.forward(req, resp);
    }
}
