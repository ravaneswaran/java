package rave.code.nse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.nse.web.model.WebPage;
import rave.code.nse.web.model.page.PriceSpurtsPage;
import rave.code.nse.web.model.page.SMEPage;
import rave.code.nse.web.model.page.VolumeSpurtsPage;
import rave.code.nse.web.service.NSEPriceSpurtService;
import rave.code.nse.web.service.NSESMEService;
import rave.code.nse.web.service.NSEVolumeSpurtsService;
import rave.code.nse.web.service.top20.*;

@Controller
public class NationalStockExchangeController {

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView home() {
       return this.priceSpurts();
    }

    @GetMapping("/price-spurts")
    public ModelAndView priceSpurts() {
        NSEPriceSpurtService priceSpurtService = new NSEPriceSpurtService();
        PriceSpurtsPage priceSpurtPage = priceSpurtService.getPriceSpurtsLWR20();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("price_spurts");
        modelAndView.addObject("webpage", priceSpurtPage);
        return modelAndView;
    }

    @GetMapping("/volume-spurts")
    public ModelAndView volumeSpurts() {
        NSEVolumeSpurtsService nseVolumeSpurtsService = new NSEVolumeSpurtsService();
        VolumeSpurtsPage volumeSpurtsPage = nseVolumeSpurtsService.getWebPageModel();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("volume_spurts");
        modelAndView.addObject("webpage", volumeSpurtsPage);
        return modelAndView;
    }

    @GetMapping("/sme")
    public ModelAndView sme() {
        NSESMEService nseSMEService = new NSESMEService();
        SMEPage smePage = nseSMEService.getWebPageModel();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sme");
        modelAndView.addObject("webpage", smePage);
        return modelAndView;
    }

    @GetMapping("/top-20/nifty-fifty")
    public ModelAndView top20NiftyFifty() {
        NSETop20NiftyFiftyService nseTop20NiftyFiftyService = new NSETop20NiftyFiftyService();
        WebPage top20NiftyFiftyPage = nseTop20NiftyFiftyService.getWebPageModel();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_nifty_fifty");
        modelAndView.addObject("webpage", top20NiftyFiftyPage);
        return modelAndView;
    }

    @GetMapping("/top-20/nifty-next-fifty")
    public ModelAndView top20NiftyNextFifty() {
        NSETop20NiftyNextFiftyService nseTop20NiftyNextFiftyService = new NSETop20NiftyNextFiftyService();
        WebPage top20NiftyNextFiftyPage = nseTop20NiftyNextFiftyService.getWebPageModel();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_nifty_next_fifty");
        modelAndView.addObject("webpage", top20NiftyNextFiftyPage);
        return modelAndView;
    }

    @GetMapping("/top-20/fo-security")
    public ModelAndView foSecurity() {
        NSETop20FOSecurityService nseTop20FOSecurityService = new NSETop20FOSecurityService();
        WebPage top20FOSecurityPage = nseTop20FOSecurityService.getWebPageModel();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_fo_securities");
        modelAndView.addObject("webpage", top20FOSecurityPage);
        return modelAndView;
    }

    @GetMapping("/top-20/security-lwr-20")
    public ModelAndView securitiesLowerThan20() {
        NSETop20SecuritiesLwr20Service nseTop20FOSecurityService = new NSETop20SecuritiesLwr20Service();
        WebPage top20SecuritiesLWR20Page = nseTop20FOSecurityService.getWebPageModel();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_security_lwr_20");
        modelAndView.addObject("webpage", top20SecuritiesLWR20Page);
        return modelAndView;
    }

    @GetMapping("/top-20/security-gtr-20")
    public ModelAndView securitiesGreaterThan20() {
        NSETop20SecuritiesGtr20Service nseTop20SecuritiesGtr20Service = new NSETop20SecuritiesGtr20Service();
        WebPage top20SecuritiesGTR20Page = nseTop20SecuritiesGtr20Service.getWebPageModel();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_security_gtr_20");
        modelAndView.addObject("webpage", top20SecuritiesGTR20Page);
        return modelAndView;
    }

    @GetMapping("/top-20/bank-nifty")
    public ModelAndView bankNifty() {
        NSETop20BankNiftyService nseTop20BankNiftyService = new NSETop20BankNiftyService();
        WebPage top20BankNiftyPage = nseTop20BankNiftyService.getWebPageModel();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top_20_bank_nifty");
        modelAndView.addObject("webpage", top20BankNiftyPage);
        return modelAndView;
    }

}