package com.tsb.service;

import com.tsb.model.entity.FinishedMatch;

import java.util.List;

public interface FinishedMatchesService {
    FinishedMatch save(FinishedMatch match);

    int getCountMatches();

    List<FinishedMatch> findByPagination(int pageNumber, int pageSize);

    int getCountMatchesByPlayerName(String playerName);

    List<FinishedMatch> findByPlayerNameAndPagination(String playerName, int pageNumber, int pageSize);
}
