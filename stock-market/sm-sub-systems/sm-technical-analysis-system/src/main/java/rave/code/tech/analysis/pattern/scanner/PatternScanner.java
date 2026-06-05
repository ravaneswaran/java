package rave.code.tech.analysis.pattern.scanner;

import rave.code.tech.analysis.pattern.Candle;
import rave.code.tech.analysis.pattern.Pattern;

import java.util.ArrayList;
import java.util.List;

public class PatternScanner {

    private List<Pattern> patterns = new ArrayList<>();

    public void registerPattern(Pattern pattern) {
        this.patterns.add(pattern);
    }

    public List<PatternResult> scan(String symbol, List<Candle> candles) {
        List<PatternResult> results = new ArrayList<>();

        for (Pattern pattern : patterns) {
            if (pattern.matches(candles)) {
                results.add(new PatternResult(symbol, pattern.getName()));
            }
        }

        return results;
    }
}
