package com.tsb.repo;

import com.tsb.model.entity.FinishedMatch;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log
public class FinishedMatchesRepo extends AbstractRepo<UUID, FinishedMatch> {
    @Override
    public FinishedMatch save(FinishedMatch finishedMatch) {
        sessionFactory.inTransaction(session -> session.persist(finishedMatch));
        return finishedMatch;
    }

    @Override
    public Optional<FinishedMatch> findById(UUID id) {
        return Optional.ofNullable(sessionFactory.fromSession(session -> session.find(FinishedMatch.class, id)));
    }

    public long count() {
        return sessionFactory.fromSession(session -> session.createQuery("select count(*) from FinishedMatch",
                        Long.class).getSingleResult());
    }

    public List<FinishedMatch> findByPagination(int pageNumber, int pageSize) {
        int offset = pageSize * (pageNumber - 1);
        log.info("findByPageAndSize offset " + offset + ",  page size " + pageSize);
        return sessionFactory.fromSession(session -> session
                .createQuery("select match from FinishedMatch match", FinishedMatch.class)
                .setFirstResult(offset)
                .setMaxResults(pageSize)
                .getResultList());
    }

    public long countByPlayerName(String playerName) {
        return sessionFactory.fromSession(session -> session
                .createQuery("select count(*) from FinishedMatch where player1.name = :name or" +
                                " player2.name = :name", Long.class)
                .setParameter("name", playerName)
                .getSingleResult());
    }

    public List<FinishedMatch> findByPlayerNameAndPagination(String playerName, int pageNumber, int pageSize) {
        int offset = pageSize * (pageNumber - 1);
        log.info("findByPageAndSize offset " + offset + ",  page size " + pageSize);
        return sessionFactory.fromSession(session -> session
                .createQuery("select match from FinishedMatch match where player1.name = :name or" +
                        " player2.name = :name", FinishedMatch.class)
                .setParameter("name", playerName)
                .setFirstResult(offset)
                .setMaxResults(pageSize)
                .getResultList());
    }
}
