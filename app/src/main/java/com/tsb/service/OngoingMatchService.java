package com.tsb.service;

import com.tsb.model.OngoingMatch;
import com.tsb.model.PlayerNumber;

import java.util.Collection;
import java.util.UUID;

public interface OngoingMatchService {
    UUID startMatch(String firstPlayerName, String secondPlayerName);
    void aceWon(UUID matchId, PlayerNumber playerNumber);
    OngoingMatch findById(UUID matchId);
    void removeMatch(UUID matchId);

    Collection<OngoingMatch> findAll();
}
