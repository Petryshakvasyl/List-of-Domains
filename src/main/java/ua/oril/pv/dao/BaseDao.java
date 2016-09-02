package ua.oril.pv.dao;

import java.util.List;

/**
 * Created by pevsat on 02.09.2016.
 */
public interface BaseDao<T> {

    T findById(Object id);

    public List<T> findAll();

    void create(T entity);

    void delete(T entity);

    T update(T entity);

}
