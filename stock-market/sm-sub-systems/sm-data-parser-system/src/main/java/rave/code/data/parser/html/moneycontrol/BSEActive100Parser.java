package rave.code.data.parser.html.moneycontrol;

import rave.code.data.model.web.external.moneycontrol.BSEGenericActiveModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEActive100Parser extends BSEActiveParser {

    private static final Logger LOGGER = Logger.getLogger(BSEActive100Parser.class.getName());

    public BSEActive100Parser() {
        super("https://www.moneycontrol.com/stocks/marketstats/bse-mostactive-stocks/bse-100-1/");
    }

    @Override
    public List<BSEGenericActiveModel> parse() {
        LOGGER.log(Level.INFO, String.format("BSEActive100Parser : Looking for BSE active 100 stocks at(%s)...", this.getSourceUrl()));
        return super.parse();
    }

    public static void main(String[] args) {
        BSEActive100Parser bseActive100Parser = new BSEActive100Parser();
        bseActive100Parser.parse();
    }
}