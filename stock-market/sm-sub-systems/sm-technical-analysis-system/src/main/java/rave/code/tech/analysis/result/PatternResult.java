package rave.code.tech.analysis.result;

import rave.code.tech.analysis.pattern.Pattern;

public class PatternResult {

    private String patternName;
    private Pattern pattern;

    public PatternResult(String patternName, Pattern pattern) {
        this.patternName = patternName;
        this.pattern = pattern;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
