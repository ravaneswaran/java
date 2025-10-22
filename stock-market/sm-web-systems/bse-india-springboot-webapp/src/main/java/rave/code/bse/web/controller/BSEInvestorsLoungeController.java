package rave.code.bse.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.bse.web.service.BSEMidCapGainerService;
import rave.code.bse.web.service.BSESmallCapGainerService;
import rave.code.bse.web.service.BSETopDividendService;
import rave.code.data.model.web.bse.page.MidCapGainerWebPage;
import rave.code.data.model.web.bse.page.SmallCapGainerWebPage;
import rave.code.data.model.web.bse.page.TopDividendWebPage;

@Controller
public class BSEInvestorsLoungeController {

    @Autowired
    private BSETopDividendService bseTopDividendService;
    @Autowired
    private BSESmallCapGainerService bseSmallCapGainerService;
    @Autowired
    private BSEMidCapGainerService bseMidCapGainerService;

    @GetMapping("/top-dividend")
    public ModelAndView bseTopDividend() {
        TopDividendWebPage topDividendWebPage = this.bseTopDividendService.getWebPage();
        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("webpage", topDividendWebPage);
        indexModelAndView.setViewName("top_dividend");

        return indexModelAndView;
    }

    @GetMapping("/small-cap-gainers")
    public ModelAndView bseSmallCapGainers() {
        SmallCapGainerWebPage smallCapGainerWebPage = this.bseSmallCapGainerService.getWebPage();
        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("webpage", smallCapGainerWebPage);
        indexModelAndView.setViewName("small_cap_gainers");

        return indexModelAndView;
    }

    @GetMapping("/mid-cap-gainers")
    public ModelAndView bseMidCapGainers() {
        MidCapGainerWebPage midCapGainerWebPage = this.bseMidCapGainerService.getWebPage();
        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("webpage", midCapGainerWebPage);
        indexModelAndView.setViewName("mid_cap_gainers");

        return indexModelAndView;
    }
}
