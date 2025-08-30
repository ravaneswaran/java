package rave.code.repository.stockbase.nse.csv;

import rave.code.repository.stockbase.nse.AbstractNSEStockBaseRepository;

public abstract class AbstractNSEStockBaseCSVRepository<T> extends AbstractNSEStockBaseRepository<T> {

    public AbstractNSEStockBaseCSVRepository(Class<T> type) {
        super(type);
    }
}
