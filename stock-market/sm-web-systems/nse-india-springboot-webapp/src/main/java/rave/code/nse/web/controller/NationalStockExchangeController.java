package rave.code.nse.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.nse.web.service.*;
import rave.code.nse.web.service.NSEPriceSpurtService;
import rave.code.nse.web.service.top20.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class NationalStockExchangeController {

    private static final Logger LOGGER = Logger.getLogger(NationalStockExchangeController.class.getName());

    @Autowired
    private NSEPriceSpurtService nsePriceSpurtService;
    @Autowired
    private NSEPriceSpurtLWR20Service nsePriceSpurtLWR20Service;
    @Autowired
    private NSEVolumeSpurtsService nseVolumeSpurtsService;
    @Autowired
    private NSESMEService nseSMEService;
    @Autowired
    private NSETop20NiftyFiftyService nseTop20NiftyFiftyService;
    @Autowired
    private NSETop20NiftyNextFiftyService nseTop20NiftyNextFiftyService;
    @Autowired
    private NSETop20FOSecurityService nseTop20FOSecurityService;
    @Autowired
    private NSETop20SecuritiesLwr20Service nseTop20SecuritiesLwr20Service;
    @Autowired
    private NSETop20SecuritiesGtr20Service nseTop20SecuritiesGtr20Service;
    @Autowired
    private NSETop20BankNiftyService nseTop20BankNiftyService;

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView home() {
        return this.openPricePriceSpurts("0", "10");
    }


    @GetMapping("/volume-spurts")
    public ModelAndView volumeSpurts() {
        NSEWebPage volumeSpurtsPage = this.nseVolumeSpurtsService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("volume_spurts");
        modelAndView.addObject("webpage", volumeSpurtsPage);
        return modelAndView;
    }

    @GetMapping("/sme")
    public ModelAndView sme() {
        NSEWebPage smePage = this.nseSMEService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sme");
        modelAndView.addObject("webpage", smePage);
        return modelAndView;
    }

    @GetMapping("/top-20/nifty-fifty")
    public ModelAndView top20NiftyFifty() {
        NSEWebPage top20NiftyFiftyPage = this.nseTop20NiftyFiftyService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_nifty_fifty");
        modelAndView.addObject("webpage", top20NiftyFiftyPage);
        return modelAndView;
    }

    @GetMapping("/top-20/nifty-next-fifty")
    public ModelAndView top20NiftyNextFifty() {
        NSEWebPage top20NiftyNextFiftyPage = this.nseTop20NiftyNextFiftyService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_nifty_next_fifty");
        modelAndView.addObject("webpage", top20NiftyNextFiftyPage);
        return modelAndView;
    }

    @GetMapping("/top-20/fo-security")
    public ModelAndView foSecurity() {
        NSEWebPage top20FOSecurityPage = this.nseTop20FOSecurityService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_fo_securities");
        modelAndView.addObject("webpage", top20FOSecurityPage);
        return modelAndView;
    }

    @GetMapping("/top-20/security-lwr-20")
    public ModelAndView securitiesLowerThan20() {
        NSEWebPage top20SecuritiesLWR20Page = this.nseTop20SecuritiesLwr20Service.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_security_lwr_20");
        modelAndView.addObject("webpage", top20SecuritiesLWR20Page);
        return modelAndView;
    }

    @GetMapping("/top-20/security-gtr-20")
    public ModelAndView securitiesGreaterThan20() {
        NSEWebPage top20SecuritiesGTR20Page = this.nseTop20SecuritiesGtr20Service.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_security_gtr_20");
        modelAndView.addObject("webpage", top20SecuritiesGTR20Page);
        return modelAndView;
    }

    @GetMapping("/top-20/bank-nifty")
    public ModelAndView bankNifty() {
        NSEWebPage top20BankNiftyPage = this.nseTop20BankNiftyService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_bank_nifty");
        modelAndView.addObject("webpage", top20BankNiftyPage);
        return modelAndView;
    }

    @GetMapping("/open-price/price-spurts")
    public ModelAndView openPricePriceSpurts(@RequestParam(required = false) String openPriceLwrLimit, @RequestParam(required = false) String openPriceUprLimit) {
        int lowerLimit = 0;
        int upperLimit = 10;
        try {
            lowerLimit = Integer.parseInt(openPriceLwrLimit);
            upperLimit = Integer.parseInt(openPriceUprLimit);
        } catch (NumberFormatException numberFormatException) {
            LOGGER.log(Level.SEVERE, numberFormatException.getMessage());
        }

        NSEWebPage nseWebPage = this.nsePriceSpurtService.getOpenPriceWebPage(lowerLimit, upperLimit);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("price_spurts");
        modelAndView.addObject("webpage", nseWebPage);
        return modelAndView;
    }

    @GetMapping("/percentage-change/price-spurts")
    public ModelAndView percentageChangePriceSpurts(@RequestParam(required = false) String percentageLowerLimit, @RequestParam(required = false) String percentageUpperLimit) {
        int lowerLimit = 0;
        int upperLimit = 10;
        try {
            lowerLimit = Integer.parseInt(percentageLowerLimit);
            upperLimit = Integer.parseInt(percentageUpperLimit);
        } catch (NumberFormatException numberFormatException) {
            LOGGER.log(Level.SEVERE, numberFormatException.getMessage());
        }
        NSEWebPage nseWebPage = this.nsePriceSpurtService.getPercentageChangeWebPage(lowerLimit, upperLimit);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("price_spurts");
        modelAndView.addObject("webpage", nseWebPage);
        return modelAndView;
    }

    @GetMapping("/price-difference/price-spurts")
    public ModelAndView priceDifferencePriceSpurts(@RequestParam(required = false) String priceDiff) {
        int priceDifference = 2;
        try {
            priceDifference = Integer.parseInt(priceDiff);
        } catch (NumberFormatException numberFormatException) {
            LOGGER.log(Level.SEVERE, numberFormatException.getMessage());
        }
        NSEWebPage nseWebPage = this.nsePriceSpurtService.getPriceDifferenceWebPage(priceDifference);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("price_spurts");
        modelAndView.addObject("webpage", nseWebPage);
        return modelAndView;
    }

}