package com.ashutosh.rest.restapp.dao;

import java.util.List;

public interface HibernateDAO<T> {
    List<T> findAll(FinderSpecification<T> finderSpecification);
    T findById(FinderSpecification<T> finderSpecification,Long id);

    void save(T object);

    T update(T object);

    void delete(FinderSpecification<T> finderSpecification,Long id);
}
