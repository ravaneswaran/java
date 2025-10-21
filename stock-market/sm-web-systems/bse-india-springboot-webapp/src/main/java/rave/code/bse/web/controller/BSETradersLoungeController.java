package rave.code.bse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.data.model.web.bse.page.PriceShockerWebPage;
import rave.code.data.model.web.bse.page.VolumeShockerWebPage;
import rave.code.data.model.web.bse.page.WebPage;
import rave.code.bse.web.service.*;

@Controller
public class BSETradersLoungeController {

    @GetMapping("/")
    public ModelAndView home() {
        return this.bseActive100();
    }

    @GetMapping("/active-100")
    public ModelAndView bseActive100() {
        Active100Service active100Service = new Active100Service();
        WebPage active100Page = active100Service.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", active100Page);
        modelAndView.setViewName("active_100");

        return modelAndView;
    }

    @GetMapping("/active-200")
    public ModelAndView bseActive200() {
        Active200Service active200Service = new Active200Service();
        WebPage active200Page = active200Service.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", active200Page);
        modelAndView.setViewName("active_200");

        return modelAndView;
    }

    @GetMapping("/active-500")
    public ModelAndView bseActive500() {
        Active500Service active500Service = new Active500Service();
        WebPage active500Page = active500Service.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", active500Page);
        modelAndView.setViewName("active_500");

        return modelAndView;
    }

    @GetMapping("/price-shockers")
    public ModelAndView bsePriceShockers() {
        PriceShockerService priceShockerService = new PriceShockerService();
        PriceShockerWebPage priceShockersWebPage = priceShockerService.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", priceShockersWebPage);
        modelAndView.setViewName("price_shockers");

        return modelAndView;
    }

    @GetMapping("/volume-shockers")
    public ModelAndView bseVolumeShockers() {
        VolumeShockerService volumeShockerService = new VolumeShockerService();
        VolumeShockerWebPage volumeShockerWebPage = volumeShockerService.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", volumeShockerWebPage);
        modelAndView.setViewName("volume_shockers");

        return modelAndView;
    }

    @GetMapping("/intraday-large-deals")
    public ModelAndView bseIntradayLargeDeals() {
        PriceShockerService priceShockerService = new PriceShockerService();
        PriceShockerWebPage priceShockersWebPage = priceShockerService.getPageModel();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", priceShockersWebPage);
        modelAndView.setViewName("intraday_large_deals");

        return modelAndView;
    }
}
