package br.com.evo.giulio.enterprise.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private static PersistenceManager instance = null;

    private EntityManagerFactory entityManagerFactory = null;

    private PersistenceManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("evoRest");
    }

    public static PersistenceManager getInstance() {

        if (instance == null) {
            instance = new PersistenceManager();
        }

        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}

