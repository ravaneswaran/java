package rave.code.nse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.nse.web.model.page.*;
import rave.code.nse.web.service.*;

@Controller
public class NationalStockExchangeController {

    @GetMapping("/nse/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @GetMapping("/nse/price-spurts")
    public ModelAndView priceSpurts() {
        NSEPriceSpurtService priceSpurtService = new NSEPriceSpurtService();
        PriceSpurtsPage priceSpurtPage = priceSpurtService.getPriceSpurtsLWR20();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("price_spurts");
        modelAndView.addObject("webpage", priceSpurtPage);
        return modelAndView;
    }

    @GetMapping("/nse/volume-spurts")
    public ModelAndView volumeSpurts() {
        NSEVolumeSpurtsService nseVolumeSpurtsService = new NSEVolumeSpurtsService();
        VolumeSpurtsPage volumeSpurtsPage = nseVolumeSpurtsService.getVolumeSpurts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("volume_spurts");
        modelAndView.addObject("webpage", volumeSpurtsPage);
        return modelAndView;
    }

    @GetMapping("/nse/sme")
    public ModelAndView sme() {
        NSESMEService nseSMEService = new NSESMEService();
        SMEPage smePage = nseSMEService.getSMEs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sme");
        modelAndView.addObject("webpage", smePage);
        return modelAndView;
    }

    @GetMapping("/nse/top-20/nifty-fifty")
    public ModelAndView top20NiftyFifty() {
        NSETop20NiftyFiftyService nseTop20NiftyFiftyService = new NSETop20NiftyFiftyService();
        Top20NiftyFiftyPage top20NiftyFiftyPage = nseTop20NiftyFiftyService.getTop20NiftyFifty();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_nifty_fifty");
        modelAndView.addObject("webpage", top20NiftyFiftyPage);
        return modelAndView;
    }

    @GetMapping("/nse/top-20/nifty-next-fifty")
    public ModelAndView top20NiftyNextFifty() {
        NSETop20NiftyNextFiftyService nseTop20NiftyNextFiftyService = new NSETop20NiftyNextFiftyService();
        Top20NiftyNextFiftyPage top20NiftyNextFiftyPage = nseTop20NiftyNextFiftyService.getTop20NiftyNextFifty();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_nifty_next_fifty");
        modelAndView.addObject("webpage", top20NiftyNextFiftyPage);
        return modelAndView;
    }

    @GetMapping("/nse/top-20/fo-security")
    public ModelAndView foSecurity() {
        NSETop20FOSecurityService nseTop20FOSecurityService = new NSETop20FOSecurityService();
        Top20FOSecurityPage top20FOSecurityPage = nseTop20FOSecurityService.getTop20FOSecurities();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_fo_securities");
        modelAndView.addObject("webpage", top20FOSecurityPage);
        return modelAndView;
    }

    @GetMapping("/nse/top-20/security-lwr-20")
    public ModelAndView securitiesLowerThan20() {
        return null;
    }

    @GetMapping("/nse/top-20/security-gtr-20")
    public ModelAndView securitiesGreaterThan20() {
        return null;
    }

    @GetMapping("/nse/top-20/bank-nifty")
    public ModelAndView bankNifty() {
        return null;
    }

}