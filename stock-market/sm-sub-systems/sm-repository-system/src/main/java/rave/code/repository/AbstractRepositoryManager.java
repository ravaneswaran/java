package rave.code.repository;

import rave.code.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepositoryManager<T>{

    private final EntityManager entityManager;
    protected  Class<T> type;

    public AbstractRepositoryManager(Class<T> type) {
        this.type = type;
        this.entityManager = RepositoryManager.getInstance().createEntityManager();
    }

    public EntityManager getEntityManager() {
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
        EntityTransaction entityTransaction = this.getEntityManager().getTransaction();
        entityTransaction.begin();
        for (T stockBaseEntity : entities) {
            AbstractEntity abstractStockBaseEntity = (AbstractEntity)stockBaseEntity;
            if (abstractStockBaseEntity.isNewEntity()) {
                this.getEntityManager().persist(stockBaseEntity);
            } else {
                this.getEntityManager().merge(stockBaseEntity);
            }
        }
        entityTransaction.commit();
    }

    public List<T> executeQuery(Query query){
        return query.getResultList();
    }

    public abstract Map<String, T> getEntityMap();
}
