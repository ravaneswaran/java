package rave.code.nse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.nse.web.model.page.PriceSpurtsPage;
import rave.code.nse.web.service.PriceSpurtService;

@Controller
@RequestMapping("/nse")
public class NationalStockExchangeController {

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @GetMapping("/price-spurts")
    public ModelAndView priceSpurts() {
        PriceSpurtService priceSpurtService = new PriceSpurtService();
        PriceSpurtsPage priceSpurtPage = priceSpurtService.getPriceSpurtsLWR20();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("price_spurts");
        modelAndView.addObject("webpage", priceSpurtPage);
        return modelAndView;
    }

    @GetMapping("/volume-spurts")
    public ModelAndView volumeSpurts() {
        return null;
    }

    @GetMapping("/sme")
    public ModelAndView sme() {
        return null;
    }

    @GetMapping("/nifty-fifty")
    public ModelAndView niftyFifty() {
        return null;
    }

    @GetMapping("/nifty-next-fifty")
    public ModelAndView niftyNextFifty() {
        return null;
    }

    @GetMapping("/fo-security")
    public ModelAndView foSecurity() {
        return null;
    }

    @GetMapping("/security-lwr-20")
    public ModelAndView securitiesLowerThan20() {
        return null;
    }

    @GetMapping("/security-gtr-20")
    public ModelAndView securitiesGreaterThan20() {
        return null;
    }

    @GetMapping("/bank-nifty")
    public ModelAndView bankNifty() {
        return null;
    }

}