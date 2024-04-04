package com.tsb.repo;

import com.tsb.entity.FinishedMatch;

import java.util.Optional;
import java.util.UUID;

public class FinishedMatchRepo extends AbstractRepo<UUID, FinishedMatch> {
    @Override
    public FinishedMatch save(FinishedMatch finishedMatch) {
        sessionFactory.inTransaction(session -> session.persist(finishedMatch));
        return finishedMatch;
    }

    @Override
    public Optional<FinishedMatch> findById(UUID id) {
        return Optional.ofNullable(sessionFactory.fromSession(session -> session.find(FinishedMatch.class, id)));
    }
}
