package com.tsb.repo;

import com.tsb.util.SessionFactoryHolder;
import org.hibernate.SessionFactory;

import java.util.Optional;

public interface Repo<K, E> {
    E save(E e);
    Optional<E> findById(K id);

}
