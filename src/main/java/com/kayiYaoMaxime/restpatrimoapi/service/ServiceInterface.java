package com.kayiYaoMaxime.restpatrimoapi.service;

import java.util.List;

/**
 *
 * @param <D> the dto class
 * @param <E> the entity class
 * @param <T> the primary class
 */
public interface ServiceInterface<D, E, T>{

    public E create(D dto);
    public E update(T id, D dto);
    public boolean delete(T id);
    public List<E> getAll();
    public E getById(T id);
}
