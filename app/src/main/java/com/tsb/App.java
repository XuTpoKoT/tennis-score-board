package com.tsb;

import com.tsb.entity.Player;
import com.tsb.util.SessionFactoryHolder;

public class App {

    public static void main(String[] args) {
        try {
            Player player = new Player(123L);
            SessionFactoryHolder.get().inTransaction(session -> session.persist(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End.");
    }
}
