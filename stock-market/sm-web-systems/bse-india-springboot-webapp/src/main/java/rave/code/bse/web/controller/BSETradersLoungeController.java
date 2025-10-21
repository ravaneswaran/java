package rave.code.bse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.data.model.web.bse.page.PriceShockerWebPage;
import rave.code.data.model.web.bse.page.VolumeShockerWebPage;
import rave.code.data.model.web.bse.page.BSEWebPage;
import rave.code.bse.web.service.*;

@Controller
public class BSETradersLoungeController {

    @GetMapping("/")
    public ModelAndView home() {
        return this.bseActive100();
    }

    @GetMapping("/active-100")
    public ModelAndView bseActive100() {
        BSEActive100Service active100Service = new BSEActive100Service();
        BSEWebPage active100Page = active100Service.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", active100Page);
        modelAndView.setViewName("active_100");

        return modelAndView;
    }

    @GetMapping("/active-200")
    public ModelAndView bseActive200() {
        BSEActive200Service active200Service = new BSEActive200Service();
        BSEWebPage active200Page = active200Service.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", active200Page);
        modelAndView.setViewName("active_200");

        return modelAndView;
    }

    @GetMapping("/active-500")
    public ModelAndView bseActive500() {
        BSEActive500Service active500Service = new BSEActive500Service();
        BSEWebPage active500Page = active500Service.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", active500Page);
        modelAndView.setViewName("active_500");

        return modelAndView;
    }

    @GetMapping("/price-shockers")
    public ModelAndView bsePriceShockers() {
        BSEPriceShockerService priceShockerService = new BSEPriceShockerService();
        PriceShockerWebPage priceShockersWebPage = priceShockerService.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", priceShockersWebPage);
        modelAndView.setViewName("price_shockers");

        return modelAndView;
    }

    @GetMapping("/volume-shockers")
    public ModelAndView bseVolumeShockers() {
        BSEVolumeShockerService volumeShockerService = new BSEVolumeShockerService();
        VolumeShockerWebPage volumeShockerWebPage = volumeShockerService.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", volumeShockerWebPage);
        modelAndView.setViewName("volume_shockers");

        return modelAndView;
    }

    @GetMapping("/intraday-large-deals")
    public ModelAndView bseIntradayLargeDeals() {
        BSEPriceShockerService priceShockerService = new BSEPriceShockerService();
        PriceShockerWebPage priceShockersWebPage = priceShockerService.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", priceShockersWebPage);
        modelAndView.setViewName("intraday_large_deals");

        return modelAndView;
    }
}
