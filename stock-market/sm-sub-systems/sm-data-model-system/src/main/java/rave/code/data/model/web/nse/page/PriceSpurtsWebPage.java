package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;
import rave.code.data.model.web.nse.page.links.Link;

import java.util.ArrayList;
import java.util.List;

public class PriceSpurtsWebPage extends NSEWebPage {

    private List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels;

    private List<NSEPriceSpurtDetailModel> history;

    public PriceSpurtsWebPage(){
        this.setPriceSpurt(true);

        Link link1 = new Link("/nse-india/open-price/price-spurts?openPriceLwrLimit=0&openPriceUprLimit=10", "\u20B9 : 0 - 10", "");
        Link link2 = new Link("/nse-india/open-price/price-spurts?openPriceLwrLimit=10&openPriceUprLimit=25", "\u20B9 : 10 - 25", "");
        Link link3 = new Link("/nse-india/open-price/price-spurts?openPriceLwrLimit=25&openPriceUprLimit=50", "\u20B9 : 25 - 50", "");
        Link link4 = new Link("/nse-india/open-price/price-spurts?openPriceLwrLimit=50&openPriceUprLimit=100", "\u20B9 : 50 - 100", "");
        Link link5 = new Link("/nse-india/open-price/price-spurts?openPriceLwrLimit=100&openPriceUprLimit=200", "\u20B9 : 100 - 200", "");
        Link link6 = new Link("/nse-india/open-price/price-spurts?openPriceLwrLimit=200&openPriceUprLimit=300", "\u20B9 : 200 - 300", "");
        Link link7 = new Link("/nse-india/open-price/price-spurts?openPriceLwrLimit=300&openPriceUprLimit=400", "\u20B9 : 300 - 400", "");
        Link link8 = new Link("/nse-india/open-price/price-spurts?openPriceLwrLimit=400&openPriceUprLimit=500", "\u20B9 : 400 - 500", "");
        Link link9 = new Link("/nse-india/open-price/price-spurts?openPriceLwrLimit=500&openPriceUprLimit=750", "\u20B9 : 500 - 750", "");
        Link link10 = new Link("/nse-india/open-price/price-spurts?openPriceLwrLimit=750&openPriceUprLimit=1000", "\u20B9 : 750 - 1000", "");

        Link link11 = new Link("/nse-india/percentage-change/price-spurts?percentageLowerLimit=5&percentageUpperLimit=15", "5% - 15%", "");
        Link link12 = new Link("/nse-india/price-difference/price-spurts?priceDiff=2", "\u20B9 : 2", "");

        this.links = new ArrayList<>();
        this.links.add(link1);
        this.links.add(link2);
        this.links.add(link3);
        this.links.add(link4);
        this.links.add(link5);
        this.links.add(link6);
        this.links.add(link7);
        this.links.add(link8);
        this.links.add(link9);
        this.links.add(link10);
        this.links.add(link11);
        this.links.add(link12);

    }

    public List<NSEPriceSpurtDetailModel> getNsePriceSpurtDetailModels() {
        return nsePriceSpurtDetailModels;
    }

    public void setNsePriceSpurtDetailModels(List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels) {
        this.nsePriceSpurtDetailModels = nsePriceSpurtDetailModels;
    }

    public List<NSEPriceSpurtDetailModel> getHistory() {
        return this.history;
    }

    public void setHistory(List<NSEPriceSpurtDetailModel> history) {
        this.history = history;
    }
}
