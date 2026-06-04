package rave.code.tech.analysis.pattern;

import java.util.List;

public interface PatternDetector {

    public boolean detect(List<Candle> candles);

}
