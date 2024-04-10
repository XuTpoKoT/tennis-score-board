package com.tsb.repo;

import java.util.Optional;

public interface Repo<K, E> {
    E save(E e);
    Optional<E> findById(K id);

}
