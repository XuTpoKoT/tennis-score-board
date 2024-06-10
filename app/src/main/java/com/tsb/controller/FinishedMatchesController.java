package com.tsb.controller;

import com.tsb.exception.EntityNotFoundException;
import com.tsb.mapper.MatchMapper;
import com.tsb.model.dto.FinishedMatchDto;
import com.tsb.service.FinishedMatchesService;
import com.tsb.service.FinishedMatchesServiceImpl;
import com.tsb.util.JspPath;
import com.tsb.util.ParameterValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(urlPatterns = "/matches")
@Slf4j
public class FinishedMatchesController extends HttpServlet {

    private final FinishedMatchesService finishedMatchesService = FinishedMatchesServiceImpl.INSTANCE;
    private final MatchMapper matchMapper = Mappers.getMapper(MatchMapper.class);
    private final int DEFAULT_PAGE_SIZE = 6;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNumber = Objects.isNull(req.getParameter("pageNumber")) ? 1 :
                ParameterValidator.getPositiveInteger(req, "pageNumber");
        int pageSize = Objects.isNull(req.getParameter("pageSize")) ? DEFAULT_PAGE_SIZE :
                ParameterValidator.getPositiveInteger(req, "pageSize");
        log.info("pageNumber: " + pageNumber + ", pageSize: " + pageSize);
        if (Objects.nonNull(req.getParameter("filter_by_player_name"))) {
            String playerName = req.getParameter("filter_by_player_name");
            int countMatches = finishedMatchesService.getCountMatchesByPlayerName(playerName);
            int lastPage = (int) Math.ceil((double) countMatches / pageSize);
            log.info("playerName: " + playerName);
            log.info("Count finished matches with player " + playerName +": " + countMatches);
            List<FinishedMatchDto> matches = finishedMatchesService.findByPlayerNameAndPagination(
                            playerName, pageNumber, pageSize).stream()
                    .map(matchMapper::fromFinishedMatch).toList();
            req.setAttribute("matches", matches);
            req.setAttribute("lastPage", lastPage);
            req.setAttribute("filterPlayerName", playerName);
        } else {
            int countMatches = finishedMatchesService.getCountMatches();
            log.info("Count finished matches: " + countMatches);
            int lastPage = (int) Math.ceil((double) countMatches / pageSize);
            if (pageSize * (pageNumber - 1) > countMatches && pageNumber > 1) {
                throw new EntityNotFoundException("завершенные матчи");
            }
            List<FinishedMatchDto> matches = finishedMatchesService.findByPagination(pageNumber, pageSize).stream()
                    .map(matchMapper::fromFinishedMatch).toList();
            req.setAttribute("matches", matches);
            req.setAttribute("lastPage", lastPage);
        }
        req.getRequestDispatcher(JspPath.getPathJsp("matches"))
                .forward(req, resp);
    }
}
