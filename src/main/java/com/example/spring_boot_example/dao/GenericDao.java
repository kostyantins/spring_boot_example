package com.example.spring_boot_example.dao;

import com.example.spring_boot_example.repository.ClusterRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class GenericDao<E> {

    private JpaRepository<E, Object> repositoryClass;
    private Class<E> entityClass;

    public GenericDao(JpaRepository<E, Object> repositoryClass, Class<E> entityClass) {
        this.repositoryClass = repositoryClass;
        this.entityClass = entityClass;
    }

    public E create(E entity) {
        return repositoryClass.save(entity);
    }

    public E delete(E entity) {
        return repositoryClass.save(entity);
    }
}
