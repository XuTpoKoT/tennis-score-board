package com.tsb.util;

import com.tsb.entity.Player;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.Properties;

public class SessionFactoryHolder {
    private static SessionFactory sessionFactory;

    public static SessionFactory get() throws IOException {
        if (sessionFactory == null) {
            Configuration cfg = new Configuration();
            Properties p = new Properties();
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
            cfg.setProperties(p);
             cfg.addAnnotatedClass(Player.class);
            sessionFactory = cfg.buildSessionFactory();
        }
        return sessionFactory;
    }
}
