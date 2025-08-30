package rave.code.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public abstract class AbstractRepository <T> {

    private static final String PERSISTENCE_UNIT_NAME = "stock_market";
    private static EntityManagerFactory factory;

    private EntityManager entityManager;

    private Class<T> type;

    public AbstractRepository(Class<T> type) {
        this.type = type;

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        this.entityManager = factory.createEntityManager();
    }

    protected EntityManager getEntityManager() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        if (null == this.entityManager) {
            this.entityManager = factory.createEntityManager();
        } else {
            if (!this.entityManager.isOpen()) {
                this.entityManager = factory.createEntityManager();
            }
        }
        return this.entityManager;
    }

    protected void closeEntityManager() {
        if (null != this.entityManager && this.entityManager.isOpen()) {
            this.entityManager.close();
        }
    }

    public T findBy(String primaryKey) {
        return this.entityManager.find(this.type, primaryKey);
    }

    public T save(T entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    public T delete(T entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    public T update(T entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    // method introduced specially to move the data to the history tables...
    public List<T> findAll() {
        EntityManager entityManager = this.getEntityManager();
        String queryString = "from ? entity".replace("?", this.type.getName());
        Query query = entityManager.createQuery(queryString, this.type);
        return query.getResultList();
    }

    public abstract void bulkUpsert(List<T> entities);

}