package rave.code.bse.web.service.algorithms.sort;

import rave.code.data.model.web.bse.stock.PriceShockerStock;

import java.util.Comparator;

public class CurrentPriceComparator implements Comparator<PriceShockerStock> {

    @Override
    public int compare(PriceShockerStock object1, PriceShockerStock object2) {
        return (object1.getCurrentPrice() <= object2.getCurrentPrice()) ? -1 : 1;
    }
}