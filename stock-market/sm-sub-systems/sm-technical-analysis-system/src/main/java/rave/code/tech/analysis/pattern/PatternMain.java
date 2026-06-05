package rave.code.tech.analysis.pattern;

import rave.code.tech.analysis.pattern.bullish.BullishEngulfingPattern;
import rave.code.tech.analysis.pattern.scanner.PatternResult;
import rave.code.tech.analysis.pattern.scanner.PatternScanner;

import java.util.List;

public class PatternMain {

    public static void main(String[] args) {

        List<Candle> candles = List.of(new Candle(100,95,102, 94), new Candle(93,105,106,92));

        PatternScanner scanner = new PatternScanner();
        scanner.registerPattern(new BullishEngulfingPattern());

        List<PatternResult> results = scanner.scan("Bullish Engulfing", candles);

        results.forEach(System.out::println);
    }
}