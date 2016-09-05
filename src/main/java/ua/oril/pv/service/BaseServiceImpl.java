package ua.oril.pv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.oril.pv.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by pevsat on 02.09.2016.
 */
@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    BaseDao<T> baseDao;

    public T findById(Object id) {
        T obj  = baseDao.findById(id);
        return obj;
    }
    @Transactional
    public void create(T entity) {

        entityManager.persist(entity);

    }

    public void delete(T entity) {
        baseDao.delete(entity);
    }

    public T update(T entity) {
        return baseDao.update(entity);
    }

    public List findAll() {
        return baseDao.findAll();
    }
}
