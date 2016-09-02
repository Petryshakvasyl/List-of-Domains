package ua.oril.pv.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pevsat on 02.09.2016.
 */
@Service
public interface BaseService<T> {


    T findById(Object id);

    void create (T entity);

    void delete (T entity);

    T update (T entity);

    List<T> findAll ();
}
