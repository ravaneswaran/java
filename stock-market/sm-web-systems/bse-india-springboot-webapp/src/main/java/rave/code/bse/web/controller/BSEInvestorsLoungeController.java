package rave.code.bse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.data.model.web.bse.page.BSEWebPage;
import rave.code.bse.web.service.BSEMidCapGainerService;
import rave.code.bse.web.service.BSESmallCapGainerService;
import rave.code.bse.web.service.BSETopDividendService;

@Controller
public class BSEInvestorsLoungeController {

    @GetMapping("/top-dividend")
    public ModelAndView bseTopDividend() {
        BSETopDividendService topDividendService = new BSETopDividendService();
        BSEWebPage webPage = topDividendService.getPageModel();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", webPage);
        indexModelAndView.setViewName("top_dividend");

        return indexModelAndView;
    }

    @GetMapping("/small-cap-gainers")
    public ModelAndView bseSmallCapGainers() {
        BSESmallCapGainerService smallCapGainerService = new BSESmallCapGainerService();
        BSEWebPage webPage = smallCapGainerService.getPageModel();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", webPage);
        indexModelAndView.setViewName("small_cap_gainers");

        return indexModelAndView;
    }

    @GetMapping("/mid-cap-gainers")
    public ModelAndView bseMidCapGainers() {
        BSEMidCapGainerService midCapGainerService = new BSEMidCapGainerService();
        BSEWebPage webPage = midCapGainerService.getPageModel();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", webPage);
        indexModelAndView.setViewName("mid_cap_gainers");

        return indexModelAndView;
    }
}
