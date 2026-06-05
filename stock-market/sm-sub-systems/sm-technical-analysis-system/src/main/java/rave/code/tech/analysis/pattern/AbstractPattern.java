package rave.code.tech.analysis.pattern;

public abstract class AbstractPattern implements Pattern{

    protected int minimumCandles;

    public AbstractPattern(int minimumCandles){
        this.minimumCandles = minimumCandles;
    }

}
