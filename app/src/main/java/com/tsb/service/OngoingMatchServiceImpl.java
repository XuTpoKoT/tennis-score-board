package com.tsb.service;

import com.tsb.entity.Player;
import com.tsb.exception.MatchNotFoundException;
import com.tsb.model.OngoingMatch;
import com.tsb.model.PlayerNumber;
import com.tsb.repo.PlayerRepo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OngoingMatchServiceImpl implements OngoingMatchService {
    public static final OngoingMatchServiceImpl INSTANCE = new OngoingMatchServiceImpl();
    private final PlayerRepo playerRepo = new PlayerRepo();
    private final ConcurrentHashMap<UUID, OngoingMatch> matchMap = new ConcurrentHashMap<>();
    @Override
    public UUID startMatch(String firstPlayerName, String secondPlayerName) {
        log.info("startMatch called with " + firstPlayerName + " and " + secondPlayerName);

        Player player1 = playerRepo.findByName(firstPlayerName).orElseGet(
                () -> playerRepo.save(new Player(firstPlayerName)));
        Player player2 = playerRepo.findByName(secondPlayerName).orElseGet(
                () -> playerRepo.save(new Player(secondPlayerName)));
        OngoingMatch newMatch = new OngoingMatch(player1, player2);
        UUID newMatchId = UUID.randomUUID();
        matchMap.put(newMatchId, newMatch);

        log.info("Match " + newMatchId + " created.");
        return newMatchId;
    }

    @Override
    public void aceWon(UUID matchId, PlayerNumber playerNumber) {
        var match = matchMap.get(matchId);
        match.aceWon(playerNumber);
    }

    @Override
    public OngoingMatch findById(UUID matchId) {
        log.info("find by id called with " + matchId);
        OngoingMatch match = matchMap.get(matchId);
        if (match == null) {
            throw new MatchNotFoundException("Match with id " + matchId + " not found.");
        }
        return match;
    }

    public void removeMatch(UUID matchId) {
        matchMap.remove(matchId);
    }

    @Override
    public Collection<OngoingMatch> findAll() {
        return matchMap.values();
    }
}
