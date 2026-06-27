package rave.code.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Deprecated
public abstract class ThreadSafeDatabaseManager<T> extends NotThreadSafeDatabaseManager<T> {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("stock_market");;
    private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();

    protected Class<T> type;

    public ThreadSafeDatabaseManager(Class<T> type) {
        super(type);
        this.type = type;
        this.initialize();
    }

    private void initialize(){
        EntityManager localEntityManager = threadLocal.get();
        if (localEntityManager == null || !localEntityManager.isOpen()) {
            localEntityManager = entityManagerFactory.createEntityManager();
            threadLocal.set(localEntityManager);
        }
    }

    public EntityManager getEntityManager() {
        EntityManager entityManager = threadLocal.get();
        if(null != entityManager){
            return entityManager;
        } else {
            initialize();
            return threadLocal.get();
        }
    }

    public void closeEntityManager() {EntityManager localEntityManager = threadLocal.get();
        if (localEntityManager == null || !localEntityManager.isOpen()) {
            localEntityManager = entityManagerFactory.createEntityManager();
            threadLocal.set(localEntityManager);
        }
        EntityManager entityManager = threadLocal.get();
        if (entityManager != null) {
            entityManager.close();
            threadLocal.remove();
        }
    }

    public T findBy(String primaryKey) {
        return getEntityManager().find(this.type, primaryKey);
    }

    public T save(T entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public T delete(T entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public T update(T entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    // method introduced specially to move the data to the history tables...
    public List<T> findAll() {
        String queryString = "from ? entity".replace("?", this.type.getName());
        Query query = getEntityManager().createQuery(queryString, this.type);
        return query.getResultList();
    }
}
