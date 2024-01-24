package com.assac453.crud.service;

import java.util.List;

public interface CRUDService<T> {
    T save(T item);
    T update(int id, T item);
    T delete(int id);
    List<T> getAll();
    T getById(int id);

}
