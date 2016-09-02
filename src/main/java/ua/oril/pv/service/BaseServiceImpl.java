package ua.oril.pv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.oril.pv.dao.DomainDao;

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
    DomainDao domainDao;

    public T findById(Object id) {
        return null;
    }
    @Transactional
    public void create(T entity) {

        entityManager.persist(entity);

    }

    public void delete(T entity) {

    }

    public T update(T entity) {
        return null;
    }

    public List findAll() {
        return domainDao.findAll();
    }
}
