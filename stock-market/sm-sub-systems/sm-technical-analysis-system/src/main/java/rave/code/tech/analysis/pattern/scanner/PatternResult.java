package rave.code.tech.analysis.pattern.scanner;

public class PatternResult {

    private String symbol;
    private String pattern;

    public PatternResult(String symbol, String pattern) {
        this.symbol = symbol;
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return symbol + " -> " + pattern;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
