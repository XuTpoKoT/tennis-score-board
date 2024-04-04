package com.tsb.service;

import com.tsb.entity.Player;
import com.tsb.model.OngoingMatch;
import com.tsb.model.PlayerNumber;
import com.tsb.repo.PlayerRepo;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OngoingMatchServiceImpl implements OngoingMatchService {
    private final PlayerRepo playerRepo = new PlayerRepo();
    private final ConcurrentHashMap<UUID, OngoingMatch> matchMap = new ConcurrentHashMap<>();
    @Override
    public UUID startMatch(String firstPlayerName, String secondPlayerName) {
        Player player1 = playerRepo.findByName(firstPlayerName).orElseGet(
                () -> playerRepo.save(new Player(firstPlayerName)));
        Player player2 = playerRepo.findByName(secondPlayerName).orElseGet(
                () -> playerRepo.save(new Player(secondPlayerName)));
        var newMatchId = UUID.randomUUID();
        var newMatch = new OngoingMatch(player1, player2);
        matchMap.put(newMatchId, newMatch);
        return newMatchId;
    }

    @Override
    public void pointWon(UUID matchId, PlayerNumber playerNumber) {
        var match = matchMap.get(matchId);
        match.pointWon(playerNumber);
    }

    @Override
    public OngoingMatch getMatch(UUID matchId) {
        return matchMap.get(matchId);
    }


    public void removeMatch(UUID matchId) {
        matchMap.remove(matchId);
    }
}
