package com.tsb.repo;

import com.tsb.model.entity.Player;

import java.util.Optional;

public class PlayerRepo extends AbstractRepo<Integer, Player> {
    @Override
    public Player save(Player player) {
        sessionFactory.inTransaction(session -> session.persist(player));
        return player;
    }

    @Override
    public Optional<Player> findById(Integer id) {
        return Optional.ofNullable(sessionFactory.fromSession(session -> session.find(Player.class, id)));
    }

    public Optional<Player> findByName(String name) {
        return sessionFactory.fromSession(session -> session
                .createSelectionQuery("from Player where name like :name", Player.class)
                .setParameter("name", name)
                .uniqueResultOptional());
    }
}
