package ru.kpfu.sem1.studclinic.dao;

import java.util.List;

public interface Dao<T> {
    T get(int id);

    List<T> getAll();

    void save(T t);
}
