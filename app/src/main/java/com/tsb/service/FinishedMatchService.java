package com.tsb.service;

import com.tsb.entity.FinishedMatch;

import java.util.List;

public interface FinishedMatchService {
    FinishedMatch save(FinishedMatch match);
    List<FinishedMatch> getAllFinishedMatches();
    List<FinishedMatch> getFinishedMatchesByPlayerName(String playerName);
}
