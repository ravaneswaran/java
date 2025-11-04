package rave.code.tech.analysis.indicators;

import rave.code.tech.analysis.stoploss.StopLoss;

public class ATRStopLossIndicator extends StopLoss {

    private double value;
    private double atr;

    public ATRStopLossIndicator(double entryPrice, double value, double atr) {
        super(entryPrice);
    }

}
