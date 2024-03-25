package com.tsb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
            cfg.addPackage("com.tsb.entity");
            sessionFactory = cfg.buildSessionFactory();
//            sessionFactory.getSessionFactoryOptions().
//            sessionFactory.exportMappedObjects(true);
        }
        return sessionFactory;
    }
}
