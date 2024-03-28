package com.tsb;

import com.tsb.entity.Player;
import com.tsb.util.SessionFactoryHolder;
import org.hibernate.Session;

public class App {

    public static void main(String[] args)  {
        try (Session session = SessionFactoryHolder.get().openSession() ){
            // Player player = new Player("Иван");
            // SessionFactoryHolder.get().inTransaction(session -> session.persist(player));

            Player player = session.find(Player.class,"Иван");
            System.out.println(player.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End.");
    }
}
