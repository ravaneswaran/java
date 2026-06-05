package rave.code.tech.analysis.pattern;

import java.util.List;

public interface Pattern {

    public String getName();

    public boolean matches(List<Candle> candles);

    public boolean detect(List<Candle> candles);
}
