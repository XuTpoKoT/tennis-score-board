package com.tsb.service;

import com.tsb.model.entity.FinishedMatch;
import com.tsb.repo.FinishedMatchesRepo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FinishedMatchesServiceImpl implements FinishedMatchesService {
    public static final FinishedMatchesServiceImpl INSTANCE = new FinishedMatchesServiceImpl();
    private final FinishedMatchesRepo finishedMatchesRepo = new FinishedMatchesRepo();

    @Override
    public FinishedMatch save(FinishedMatch match) {
        return finishedMatchesRepo.save(match);
    }

    @Override
    public int getCountMatches() {
        return (int) finishedMatchesRepo.count();
    }
    @Override
    public int getCountMatchesByPlayerName(String playerName) {
        return (int) finishedMatchesRepo.countByPlayerName(playerName);
    }

    @Override
    public List<FinishedMatch> findByPlayerNameAndPagination(String playerName, int pageNumber, int pageSize) {
        return finishedMatchesRepo.findByPlayerNameAndPagination(playerName, pageNumber, pageSize);
    }

    @Override
    public List<FinishedMatch> findByPagination(int pageNumber, int pageSize) {
        return finishedMatchesRepo.findByPagination(pageNumber, pageSize);
    }


}
