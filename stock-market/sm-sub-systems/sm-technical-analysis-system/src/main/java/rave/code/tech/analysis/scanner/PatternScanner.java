package rave.code.tech.analysis.scanner;

import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.Pattern;
import rave.code.tech.analysis.candle.pattern.bearish.*;
import rave.code.tech.analysis.candle.pattern.bullish.*;
import rave.code.tech.analysis.result.PatternResult;

import java.util.ArrayList;
import java.util.List;

public class PatternScanner {

    private List<Pattern> patterns = new ArrayList<>();

    public PatternScanner(){

        /* Registering Bullish Patterns */
        this.registerPattern(new BullishEngulfingPattern());
        this.registerPattern(new BullishAbandonedBabyPattern());
        this.registerPattern(new BullishBeltHoldPattern());
        this.registerPattern(new BullishConcealingBabySwallowPattern());
        this.registerPattern(new BullishDragonflyDojiPattern());
        this.registerPattern(new BullishHammerPattern());
        this.registerPattern(new BullishHaramiPattern());
        this.registerPattern(new BullishInvertedHammerPattern());
        this.registerPattern(new BullishKickerPattern());
        this.registerPattern(new BullishLadderBottomPattern());
        this.registerPattern(new BullishMattHoldPattern());
        this.registerPattern(new BullishMeetingLinesPattern());
        this.registerPattern(new BullishMorningStarPattern());
        this.registerPattern(new BullishPiercingLinePattern());
        this.registerPattern(new BullishRisingThreeMethodsPattern());
        this.registerPattern(new BullishSeparatingLinesPattern());
        this.registerPattern(new BullishThreeInsideUpPattern());
        this.registerPattern(new BullishThreeLineStrikePattern());
        this.registerPattern(new BullishThreeOutsideUpPattern());
        this.registerPattern(new BullishThreeWhiteSoldiersPattern());
        this.registerPattern(new BullishTweezerBottomPattern());

        /* Registering Bearish Pattern */
        this.registerPattern(new BearishAbandonedBabyPattern());
        this.registerPattern(new BearishBeltHoldPattern());
        this.registerPattern(new BearishDarkCloudCoverPattern());
        this.registerPattern(new BearishDojiStarPattern());
        this.registerPattern(new BearishEngulfingPattern());
        this.registerPattern(new BearishEveningStarPattern());
        this.registerPattern(new BearishHangingManPattern());
        this.registerPattern(new BearishHaramiPattern());
        this.registerPattern(new BearishKickerPattern());
        this.registerPattern(new BearishMatHoldPattern());
        this.registerPattern(new BearishShootingStarPattern());
        this.registerPattern(new BearishThreeBlackCrowsPattern());
        this.registerPattern(new BearishThreeInsideDownPattern());
        this.registerPattern(new BearishThreeLineStrikePattern());
        this.registerPattern(new BearishThreeOutsideDownPattern());
        this.registerPattern(new BearishTweezerTopPattern());
        this.registerPattern(new BearishUpsideGapTwoCrowsPattern());
    }

    public void registerPattern(Pattern pattern) {
        this.patterns.add(pattern);
    }

    public List<PatternResult> scan(List<Candle> candles) {
        List<PatternResult> results = new ArrayList<>();

        for (Pattern pattern : this.patterns) {
            if (pattern.matches(candles)) {
                results.add(new PatternResult(pattern.getName(), pattern));
            }
        }

        return results;
    }
}
