package rave.code.bse.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.bse.web.service.BSESensexService;
import rave.code.data.model.web.bse.page.SensexWebPage;

@Controller
public class BSESensexController {

    @Autowired
    private BSESensexService bseSensexService;

    @GetMapping("/sensex")
    public ModelAndView sensex() {
        SensexWebPage sensexWebPage = this.bseSensexService.getWebPage();
        ModelAndView sensexModelAndView = new ModelAndView();
        sensexModelAndView.addObject("webpage", sensexWebPage);
        sensexModelAndView.setViewName("sensex");

        return sensexModelAndView;
    }
}
