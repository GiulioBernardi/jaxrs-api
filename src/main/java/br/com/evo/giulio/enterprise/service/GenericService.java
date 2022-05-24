package br.com.evo.giulio.enterprise.service;

import br.com.evo.giulio.enterprise.dao.PersistenceManager;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class GenericService<T extends Serializable, PK extends Serializable> {

    private EntityManager entityManager = null;

    public abstract void inserir(T instance);

    public abstract void atualizar(T instance);

    public abstract void remover(Long id);

    public abstract T obter(Long id);

    public abstract List<T> listar();

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
        }

        return entityManager;
    }

    public void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
            }
            entityManager.close();
        }
    }
}