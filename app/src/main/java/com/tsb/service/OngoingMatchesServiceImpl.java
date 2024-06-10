package com.tsb.service;

import com.tsb.exception.MatchNotFoundException;
import com.tsb.mapper.MatchMapper;
import com.tsb.model.core.OngoingMatch;
import com.tsb.model.core.PlayerNumber;
import com.tsb.model.dto.OngoingMatchDto;
import com.tsb.model.entity.Player;
import com.tsb.repo.PlayerRepo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class OngoingMatchesServiceImpl implements OngoingMatchesService {
    public static final OngoingMatchesServiceImpl INSTANCE = new OngoingMatchesServiceImpl();
    private final MatchMapper matchMapper = Mappers.getMapper(MatchMapper.class);
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
    public List<OngoingMatchDto> findAll() {
        return matchMap.entrySet().stream().map(es -> matchMapper.fromOngoingMatch(es.getKey(), es.getValue()))
            .toList();
    }
}
