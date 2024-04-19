package com.tsb.util;

import com.tsb.model.entity.FinishedMatch;
import com.tsb.model.entity.Player;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;


public class SessionFactoryHolder {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = buildSessionFactory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory get() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() throws IOException {
        Configuration cfg = new Configuration();
        Properties p = new Properties();
        p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        cfg.setProperties(p);
        cfg.addAnnotatedClass(Player.class);
        cfg.addAnnotatedClass(FinishedMatch.class);
        return cfg.buildSessionFactory();
    }
}
