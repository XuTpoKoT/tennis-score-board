package com.tsb.controller;

import com.tsb.util.JspPath;
import lombok.extern.java.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
@Log
public class MainPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("MainPageController");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(JspPath.getPathJsp("main"));
        requestDispatcher.forward(req, resp);
    }
}
