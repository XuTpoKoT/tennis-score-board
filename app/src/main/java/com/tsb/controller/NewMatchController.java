package com.tsb.controller;

import com.tsb.service.OngoingMatchService;
import com.tsb.service.OngoingMatchServiceImpl;
import com.tsb.util.JspPath;
import com.tsb.util.ValidParameter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/new-match")
public class NewMatchController extends HttpServlet {

    private final OngoingMatchService ongoingMatchService = OngoingMatchServiceImpl.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspPath.getPathJsp("new-match")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstPlayerName = ValidParameter.getValidPlayerName(req, "first_player");
        String secondPlayerName = ValidParameter.getValidPlayerName(req, "second_player");

        UUID matchId = ongoingMatchService.startMatch(firstPlayerName, secondPlayerName);
        resp.sendRedirect(String.format("%s/match-score?id=%s", req.getContextPath(), matchId));
    }
}
