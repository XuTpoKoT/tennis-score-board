package com.tsb.repo;

import com.tsb.util.SessionFactoryHolder;
import org.hibernate.SessionFactory;

public abstract class AbstractRepo<K, E> implements Repo<K, E> {
    protected final SessionFactory sessionFactory = SessionFactoryHolder.get();
}
