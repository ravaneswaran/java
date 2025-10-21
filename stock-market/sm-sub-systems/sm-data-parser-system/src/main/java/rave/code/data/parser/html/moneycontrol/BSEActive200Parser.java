package rave.code.data.parser.html.moneycontrol;

import rave.code.data.model.web.external.moneycontrol.BSEGenericActiveModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEActive200Parser extends BSEActiveParser {

    private static final Logger LOGGER = Logger.getLogger(BSEActive200Parser.class.getName());

    public BSEActive200Parser() {
        super("https://www.moneycontrol.com/stocks/marketstats/bse-mostactive-stocks/bse-200-2/");
    }

    @Override
    public List<BSEGenericActiveModel> parse() {
        LOGGER.log(Level.INFO, String.format("BSEActive200Parser : Looking for BSE active 200 stocks at(%s)...", this.getSourceUrl()));
        return super.parse();
    }

    public static void main(String[] args) {
        BSEActive200Parser bseActive200Parser = new BSEActive200Parser();
        List<BSEGenericActiveModel> bseGenericActiveModels = bseActive200Parser.parse();
        System.out.println("--------------------------------->>>>>>>> "+bseGenericActiveModels.size());
    }
}
