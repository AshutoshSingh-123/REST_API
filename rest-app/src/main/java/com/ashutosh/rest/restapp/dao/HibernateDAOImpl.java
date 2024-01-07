package com.ashutosh.rest.restapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateDAOImpl<T> implements HibernateDAO<T> {

    private EntityManager entityManager;
    @Autowired
    public HibernateDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<T> findAll(FinderSpecification<T> finderSpecification) {
        TypedQuery<T> query=entityManager.createQuery("FROM "+finderSpecification.getType().getSimpleName(),finderSpecification.getType());
        return query.getResultList();
    }

    @Override
    public T findById(FinderSpecification<T> finderSpecification, Long id) {
        return entityManager.find(finderSpecification.getType(),id);
    }

    @Override
    @Transactional
    public void save(T object) {
        entityManager.persist(object);
    }

    @Override
    @Transactional
    public T update(T object) {
        return entityManager.merge(object);
    }

    @Override
    @Transactional
    public void delete(FinderSpecification<T> finderSpecification, Long id) {
        T x= entityManager.find(finderSpecification.getType(),id);
        entityManager.remove(x);
    }
}
