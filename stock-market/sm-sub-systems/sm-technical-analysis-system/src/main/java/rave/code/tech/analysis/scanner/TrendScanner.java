package rave.code.tech.analysis.scanner;

import rave.code.tech.analysis.candle.trend.DownTrend;
import rave.code.tech.analysis.candle.trend.SideWayTrend;
import rave.code.tech.analysis.candle.trend.Trend;
import rave.code.tech.analysis.candle.trend.UpTrend;

public class TrendScanner {

    public static Trend identifyTrend(double currentHigh, double currentLow, double previousHigh, double previousLow) {

        if (currentHigh > previousHigh && currentLow > previousLow) {
            return new UpTrend(currentHigh, currentLow, previousHigh, previousLow);
        }

        if (currentHigh < previousHigh && currentLow < previousLow) {
            return new DownTrend(currentHigh, currentLow, previousHigh, previousLow);
        }

        return new SideWayTrend(currentHigh, currentLow, previousHigh, previousLow);
    }
}