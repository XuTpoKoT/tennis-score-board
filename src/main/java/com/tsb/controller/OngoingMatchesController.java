package com.tsb.controller;

import com.tsb.model.dto.OngoingMatchDto;
import com.tsb.service.OngoingMatchesService;
import com.tsb.service.OngoingMatchesServiceImpl;
import com.tsb.util.JspPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ongoing-matches")
@Slf4j
public class OngoingMatchesController extends HttpServlet {

    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesServiceImpl.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Get ongoing matches");
        List<OngoingMatchDto> matches = ongoingMatchesService.findAll();
        req.setAttribute("matches", matches);
        req.getRequestDispatcher(JspPath.getPathJsp("ongoing-matches")).forward(req, resp);
    }
}
