package rave.code.data.parser.html.moneycontrol;

import rave.code.data.parser.html.HTMLSourceParser;
import rave.code.website.data.model.moneycontrol.IntradayLargeDealModel;

import java.util.List;
import java.util.logging.Logger;

public class IntradayLargeDealsParser extends HTMLSourceParser<IntradayLargeDealModel> {

    private static final Logger LOGGER = Logger.getLogger(IntradayLargeDealsParser.class.getName());

    public IntradayLargeDealsParser() {
        super("https://www.moneycontrol.com/markets/stock-deals/large-deals/");
    }

    @Override
    public List<IntradayLargeDealModel> parse() {
        return null;
    }

    public static void main(String[] args) {
        IntradayLargeDealsParser intradayLargeDealsParser = new IntradayLargeDealsParser();
        intradayLargeDealsParser.parse();
    }
}