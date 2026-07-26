package rave.code.tech.analysis.indicators.truerange;

import rave.code.tech.analysis.Candle;

public class TrueRange {

    protected Candle candle;

    public TrueRange(double openPrice, double closePrice, double highPrice, double lowPrice, double previousClose, double percentageChange){
        this(new Candle(openPrice, closePrice, highPrice, lowPrice, previousClose, percentageChange));
    }

    public TrueRange(Candle candle) {
        this.candle = candle;
    }

    public double getMax() {
        return Math.max(this.candle.getHighPrice() - this.candle.getLowPrice(), Math.max(Math.abs(this.candle.getHighPrice() - this.candle.getPreviousClose()), Math.abs(this.candle.getLowPrice() - this.candle.getPreviousClose())));
    }
}
