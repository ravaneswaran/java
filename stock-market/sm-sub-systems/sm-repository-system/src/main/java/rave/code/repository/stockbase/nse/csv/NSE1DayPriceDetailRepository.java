package rave.code.repository.stockbase.nse.csv;

import rave.code.entity.stockbase.nse.csv.NSE1DayPriceDetailEntity;

public class NSE1DayPriceDetailRepository extends AbstractNSEStockBaseCSVRepository<NSE1DayPriceDetailEntity> {

    public NSE1DayPriceDetailRepository() {
        super(NSE1DayPriceDetailEntity.class);
    }

}
