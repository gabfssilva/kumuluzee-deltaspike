package com.thedevpiece.kumuluzee.deltaspike;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class DefaultProducer {
    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    public EntityManager entityManager() {
        return entityManager;
    }

    public void close(@Disposes @Any EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
