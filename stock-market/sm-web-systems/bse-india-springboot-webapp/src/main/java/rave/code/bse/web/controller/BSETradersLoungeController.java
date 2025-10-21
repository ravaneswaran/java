package rave.code.bse.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.bse.web.service.*;
import rave.code.data.model.web.bse.page.BSEWebPage;
import rave.code.data.model.web.bse.page.PriceShockerWebPage;
import rave.code.data.model.web.bse.page.VolumeShockerWebPage;

@Controller
public class BSETradersLoungeController {

    @Autowired
    private BSEActive100Service bseActive100Service;
    @Autowired
    private BSEActive200Service bseActive200Service;
    @Autowired
    private BSEActive500Service bseActive500Service;
    @Autowired
    private BSEPriceShockerService bsePriceShockerService;
    @Autowired
    private BSEVolumeShockerService bseVolumeShockerService;


    @GetMapping("/")
    public ModelAndView home() {
        return this.bseActive100();
    }

    @GetMapping("/active-100")
    public ModelAndView bseActive100() {
        BSEWebPage active100Page = this.bseActive100Service.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", active100Page);
        modelAndView.setViewName("active_100");

        return modelAndView;
    }

    @GetMapping("/active-200")
    public ModelAndView bseActive200() {
        BSEWebPage active200Page = this.bseActive200Service.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", active200Page);
        modelAndView.setViewName("active_200");

        return modelAndView;
    }

    @GetMapping("/active-500")
    public ModelAndView bseActive500() {
        BSEWebPage active500Page = this.bseActive500Service.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", active500Page);
        modelAndView.setViewName("active_500");

        return modelAndView;
    }

    @GetMapping("/price-shockers")
    public ModelAndView bsePriceShockers() {
        PriceShockerWebPage priceShockersWebPage = this.bsePriceShockerService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", priceShockersWebPage);
        modelAndView.setViewName("price_shockers");

        return modelAndView;
    }

    @GetMapping("/volume-shockers")
    public ModelAndView bseVolumeShockers() {
        VolumeShockerWebPage volumeShockerWebPage = this.bseVolumeShockerService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", volumeShockerWebPage);
        modelAndView.setViewName("volume_shockers");

        return modelAndView;
    }

    @GetMapping("/intraday-large-deals")
    public ModelAndView bseIntradayLargeDeals() {
        BSEPriceShockerService priceShockerService = new BSEPriceShockerService();
        PriceShockerWebPage priceShockersWebPage = priceShockerService.getWebPage();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", priceShockersWebPage);
        modelAndView.setViewName("intraday_large_deals");

        return modelAndView;
    }
}
