package com.tsb.service;

import com.tsb.entity.FinishedMatch;
import com.tsb.repo.FinishedMatchRepo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FinishedMatchServiceImpl implements FinishedMatchService {
    public static final FinishedMatchServiceImpl INSTANCE = new FinishedMatchServiceImpl();
    private final FinishedMatchRepo finishedMatchRepo = new FinishedMatchRepo();

    @Override
    public FinishedMatch save(FinishedMatch match) {
        return finishedMatchRepo.save(match);
    }

    @Override
    public List<FinishedMatch> getAllFinishedMatches() {
        return null;
    }

    @Override
    public List<FinishedMatch> getFinishedMatchesByPlayerName(String playerName) {
        return null;
    }
}
