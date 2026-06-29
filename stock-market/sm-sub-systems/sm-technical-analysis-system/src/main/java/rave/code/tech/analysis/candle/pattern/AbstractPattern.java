package rave.code.tech.analysis.candle.pattern;

public abstract class AbstractPattern implements Pattern{

    protected int minimumCandles;

    public AbstractPattern(int minimumCandles){
        this.minimumCandles = minimumCandles;
    }

}
