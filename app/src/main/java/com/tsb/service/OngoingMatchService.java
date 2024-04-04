package com.tsb.service;

import com.tsb.model.OngoingMatch;
import com.tsb.model.PlayerNumber;

import java.util.UUID;

public interface OngoingMatchService {
    UUID startMatch(String firstPlayerName, String secondPlayerName);
    void pointWon(UUID matchId, PlayerNumber playerNumber);
    OngoingMatch getMatch(UUID matchId);
    void removeMatch(UUID matchId);
}
