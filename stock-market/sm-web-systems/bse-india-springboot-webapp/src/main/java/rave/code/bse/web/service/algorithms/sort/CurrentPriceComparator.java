package rave.code.bse.web.service.algorithms.sort;

import rave.code.data.model.web.bse.PriceShockerDetailModel;

import java.util.Comparator;

public class CurrentPriceComparator implements Comparator<PriceShockerDetailModel> {

    @Override
    public int compare(PriceShockerDetailModel object1, PriceShockerDetailModel object2) {
        return (object1.getCurrentPrice() <= object2.getCurrentPrice()) ? -1 : 1;
    }
}