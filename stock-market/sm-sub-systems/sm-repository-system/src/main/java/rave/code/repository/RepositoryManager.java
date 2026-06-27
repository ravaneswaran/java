package rave.code.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RepositoryManager {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("stock_market");

    private RepositoryManager() {
    }

    public static RepositoryManager getInstance() {
        return Holder.INSTANCE;
    }

    public EntityManager createEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public void shutdown() {
        if (ENTITY_MANAGER_FACTORY.isOpen()) {
            ENTITY_MANAGER_FACTORY.close();
        }
    }

    private static class Holder {
        private static final RepositoryManager INSTANCE = new RepositoryManager();
    }
}
