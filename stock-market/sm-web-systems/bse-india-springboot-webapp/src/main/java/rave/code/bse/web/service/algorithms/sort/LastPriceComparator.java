package rave.code.bse.web.service.algorithms.sort;

import rave.code.data.model.web.bse.stock.Stock;

import java.util.Comparator;

public class LastPriceComparator implements Comparator<Stock> {

    @Override
    public int compare(Stock object1, Stock object2) {
        return (object1.getLastPrice() <= object2.getLastPrice()) ? -1 : 1;
    }
}
