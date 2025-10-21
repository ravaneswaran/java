package rave.code.bse.web.service.algorithms.sort;

import rave.code.data.model.web.bse.BSEStockModel;

import java.util.Comparator;

public class LastPriceComparator implements Comparator<BSEStockModel> {

    @Override
    public int compare(BSEStockModel object1, BSEStockModel object2) {
        return (object1.getLastPrice() <= object2.getLastPrice()) ? -1 : 1;
    }
}
