package com.tsb.controller;

import com.tsb.service.OngoingMatchesService;
import com.tsb.service.OngoingMatchesServiceImpl;
import com.tsb.util.JspPath;
import com.tsb.util.ParameterValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/new-match")
public class NewMatchController extends HttpServlet {

    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesServiceImpl.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspPath.getPathJsp("new-match")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstPlayerName = ParameterValidator.getPlayerName(req, "first_player");
        String secondPlayerName = ParameterValidator.getPlayerName(req, "second_player");

        UUID matchId = ongoingMatchesService.startMatch(firstPlayerName, secondPlayerName);
        resp.sendRedirect(String.format("%s/match-score?id=%s", req.getContextPath(), matchId));
    }
}
