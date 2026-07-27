package rave.code.tech.analysis.indicators;

public interface Indicator<I, O> {

    public O calculate(I input, int period);

}