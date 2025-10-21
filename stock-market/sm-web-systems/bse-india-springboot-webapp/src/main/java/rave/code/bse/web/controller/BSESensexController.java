package rave.code.bse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.data.model.web.bse.page.BSEWebPage;
import rave.code.bse.web.service.BSESensexService;

@Controller
public class BSESensexController {

    @GetMapping("/sensex")
    public ModelAndView sensex() {
        BSESensexService sensexService = new BSESensexService();
        BSEWebPage webPage = sensexService.getPageModel();

        ModelAndView sensexModelAndView = new ModelAndView();
        sensexModelAndView.addObject("page", webPage);
        sensexModelAndView.setViewName("sensex");

        return sensexModelAndView;
    }
}
