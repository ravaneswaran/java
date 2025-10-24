package rave.code.nse.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.nse.web.service.preopen.*;

@Controller
public class NationStockExchangePreOpenMarketController {

    @Autowired
    private NSEPreOpenMarketNifty50Service nsePreOpenMarketNifty50Service;
    @Autowired
    private NSEPreOpenMarketFOService nsePreOpenMarketFOService;
    @Autowired
    private NSEPreOpenMarketOthersService nsePreOpenMarketOthersService;
    @Autowired
    private NSEPreOpenMarketSMEService nsePreOpenMarketSMEService;
    @Autowired
    private NSEPreOpenMarketBankNiftyService nsePreOpenMarketBankNiftyService;

    @GetMapping("/pre-open-market/nifty-50")
    public ModelAndView preOpenMarketNifty50() {
        NSEWebPage preOpenMarketNifty50WebPage = this.nsePreOpenMarketNifty50Service.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pre_open_market");
        modelAndView.addObject("webpage", preOpenMarketNifty50WebPage);
        return modelAndView;
    }

    @GetMapping("/pre-open-market/bank-nifty")
    public ModelAndView preOpenMarketBankNifty() {
        NSEWebPage preOpenMarketBankNiftyWebPage = this.nsePreOpenMarketBankNiftyService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pre_open_market");
        modelAndView.addObject("webpage", preOpenMarketBankNiftyWebPage);
        return modelAndView;
    }

    @GetMapping("/pre-open-market/sme")
    public ModelAndView preOpenMarketSME() {
        NSEWebPage preOpenMarketSMEWebPage = this.nsePreOpenMarketSMEService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pre_open_market");
        modelAndView.addObject("webpage", preOpenMarketSMEWebPage);
        return modelAndView;
    }

    @GetMapping("/pre-open-market/fo")
    public ModelAndView preOpenMarketFO() {
        NSEWebPage preOpenMarketFOWebPage = this.nsePreOpenMarketFOService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pre_open_market");
        modelAndView.addObject("webpage", preOpenMarketFOWebPage);
        return modelAndView;
    }

    @GetMapping("/pre-open-market/others")
    public ModelAndView preOpenMarketOthers() {
        NSEWebPage preOpenMarketOthersWebPage = this.nsePreOpenMarketOthersService.getWebPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pre_open_market");
        modelAndView.addObject("webpage", preOpenMarketOthersWebPage);
        return modelAndView;
    }
}
