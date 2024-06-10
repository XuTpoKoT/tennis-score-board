package com.tsb.controller;

import com.tsb.model.core.MatchScore;
import com.tsb.model.core.OngoingMatch;
import com.tsb.model.core.PlayerNumber;
import com.tsb.model.entity.FinishedMatch;
import com.tsb.service.FinishedMatchesService;
import com.tsb.service.FinishedMatchesServiceImpl;
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


@WebServlet(urlPatterns = "/match-score")
public class MatchScoreController extends HttpServlet {
    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesServiceImpl.INSTANCE;
    private final FinishedMatchesService finishedMatchesService = FinishedMatchesServiceImpl.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = ParameterValidator.getUUID(req, "id");
        OngoingMatch match = ongoingMatchesService.findById(id);
        MatchScore matchScore = match.getScore();
        req.setAttribute("id", id);
        req.setAttribute("firstPlayer", match.getPlayer1());
        req.setAttribute("secondPlayer", match.getPlayer2());
        req.setAttribute("matchScore", matchScore.getMatchScoreDisplayName());
        req.setAttribute("setScore", matchScore.getSetScoreDisplayName());
        req.setAttribute("gameScore", matchScore.getGameScoreDisplayName());
        req.getRequestDispatcher(JspPath.getPathJsp("match-score")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UUID matchId = UUID.fromString(req.getParameter("id"));
        PlayerNumber playerNumber = PlayerNumber.valueOf(req.getParameter("player"));
        ongoingMatchesService.aceWon(matchId, playerNumber);
        OngoingMatch ongoingMatch = ongoingMatchesService.findById(matchId);
        if (ongoingMatch.isFinished()) {
            FinishedMatch finishedMatch = FinishedMatch.fromOngoingMatch(ongoingMatch);
            finishedMatchesService.save(finishedMatch);
            ongoingMatchesService.removeMatch(matchId);
            resp.sendRedirect(String.format("%s/main", req.getContextPath()));
        } else {
            resp.sendRedirect(String.format("%s/match-score?id=%s", req.getContextPath(), matchId));
        }
    }
}
