package rave.code.repository;

import rave.code.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractRepositoryManager<T> {

    private static final Logger LOGGER = Logger.getLogger(AbstractRepositoryManager.class.getName());

    private EntityManager entityManager;
    protected Class<T> type;

    public AbstractRepositoryManager(Class<T> type) {
        this.type = type;
    }

    public EntityManager getEntityManager() {
        if (!(null != this.entityManager && this.entityManager.isOpen())) {
            this.entityManager = RepositoryManager.getInstance().createEntityManager();
        }
        return this.entityManager;
    }

    public T findBy(String primaryKey) {
        return this.getEntityManager().find(this.type, primaryKey);
    }

    public T save(T entity) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        //entityManager.close();
        return entity;
    }

    public T delete(T entity) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        //entityManager.close();
        return entity;
    }

    public T update(T entity) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        //entityManager.close();
        return entity;
    }

    // method introduced specially to move the data to the history tables...
    public List<T> findAll() {
        String queryString = "from ? entity".replace("?", this.type.getName());
        Query query = this.getEntityManager().createQuery(queryString, this.type);
        return query.getResultList();
    }

    public void bulkUpsert(List<T> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (T stockBaseEntity : entities) {
            if (null != stockBaseEntity) {
                AbstractEntity abstractStockBaseEntity = (AbstractEntity) stockBaseEntity;
                if (abstractStockBaseEntity.isNewEntity()) {
                    entityManager.persist(stockBaseEntity);
                } else {
                    entityManager.merge(stockBaseEntity);
                }
            } else {
                LOGGER.log(Level.SEVERE, "stock base entity found to be null...");
            }
        }
        entityTransaction.commit();
        //entityManager.close();
    }

    public List<T> executeQuery(Query query) {
        return query.getResultList();
    }

    public abstract Map<String, T> getEntityMap();
}
