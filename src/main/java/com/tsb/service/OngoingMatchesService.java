package com.tsb.service;

import com.tsb.model.core.OngoingMatch;
import com.tsb.model.core.PlayerNumber;
import com.tsb.model.dto.OngoingMatchDto;

import java.util.List;
import java.util.UUID;

public interface OngoingMatchesService {
    UUID startMatch(String firstPlayerName, String secondPlayerName);
    void aceWon(UUID matchId, PlayerNumber playerNumber);
    OngoingMatch findById(UUID matchId);
    void removeMatch(UUID matchId);
    List<OngoingMatchDto> findAll();
}
