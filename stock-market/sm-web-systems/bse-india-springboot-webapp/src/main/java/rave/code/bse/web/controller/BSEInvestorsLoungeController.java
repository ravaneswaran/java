package rave.code.bse.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.bse.web.service.BSEMidCapGainerService;
import rave.code.bse.web.service.BSESmallCapGainerService;
import rave.code.bse.web.service.BSETopDividendService;
import rave.code.data.model.web.bse.page.BSEWebPage;

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
        BSEWebPage webPage = this.bseTopDividendService.getWebPage();
        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", webPage);
        indexModelAndView.setViewName("top_dividend");

        return indexModelAndView;
    }

    @GetMapping("/small-cap-gainers")
    public ModelAndView bseSmallCapGainers() {
        BSEWebPage webPage = this.bseSmallCapGainerService.getWebPage();
        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", webPage);
        indexModelAndView.setViewName("small_cap_gainers");

        return indexModelAndView;
    }

    @GetMapping("/mid-cap-gainers")
    public ModelAndView bseMidCapGainers() {
        BSEWebPage webPage = this.bseMidCapGainerService.getWebPage();
        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", webPage);
        indexModelAndView.setViewName("mid_cap_gainers");

        return indexModelAndView;
    }
}
