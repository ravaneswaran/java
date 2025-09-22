package rave.code.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public abstract class NotThreadSafeDatabaseManager<T> {

    private static final String PERSISTENCE_UNIT_NAME = "stock_market";

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    private Class<T> type;

    public NotThreadSafeDatabaseManager(Class<T> type) {
        this.type = type;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        this.entityManager = factory.createEntityManager();
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void closeEntityManager() {
        if (null != entityManager && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public T findBy(String primaryKey) {
        return entityManager.find(this.type, primaryKey);
    }

    public T save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public T delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public T update(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    // method introduced specially to move the data to the history tables...
    public List<T> findAll() {
        String queryString = "from ? entity".replace("?", this.type.getName());
        Query query = entityManager.createQuery(queryString, this.type);
        return query.getResultList();
    }
}