package rave.code.tech.analysis.pattern;

public abstract class AbstractPatternDetector implements PatternDetector{

    protected int minimumCandles;

    public AbstractPatternDetector(int minimumCandles){
        this.minimumCandles = minimumCandles;
    }

}
