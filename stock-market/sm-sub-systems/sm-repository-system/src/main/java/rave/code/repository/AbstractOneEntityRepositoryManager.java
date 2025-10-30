package rave.code.repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class AbstractOneEntityRepositoryManager<T> extends AbstractRepositoryManager<T> {

    public AbstractOneEntityRepositoryManager(Class<T> type) {
        super(type);
    }

    @Override
    public Map<String, T> getEntityMap() {
        throw new RuntimeException("Operation prohibited...");
    }

    @Override
    public void bulkUpsert(List<T> entities) {
        throw new RuntimeException("Operation prohibited...");
    }

    @Override
    public List<T> findAll() {
        throw new RuntimeException("Operation prohibited...");
    }

    public T find() {
        String queryString = "from ? entity".replace("?", this.type.getName());
        Query query = getEntityManager().createQuery(queryString, this.type);
        List<T> resultList = query.getResultList();
        if (resultList != null && resultList.size() > 1) {
            throw new RuntimeException("Illicit item found...only one entity should present in the table.");
        } else {
            List<T> listItems = query.getResultList();
            if (listItems.size() == 0) {
                return null;
            } else {
                return (T) listItems.get(0);
            }
        }
    }
}
