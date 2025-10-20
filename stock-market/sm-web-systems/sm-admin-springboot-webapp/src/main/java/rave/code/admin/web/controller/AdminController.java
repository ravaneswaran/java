package rave.code.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.admin.web.service.JobListingService;
import rave.code.admin.web.service.TriggerListingService;

@Controller
public class AdminController {

    @Autowired
    private TriggerListingService triggerListingService;
    @Autowired
    private JobListingService jobListingService;

    @GetMapping("/")
    public ModelAndView home() {
        return this.listNSETriggers();
    }

    @GetMapping("/nse/triggers")
    public ModelAndView listNSETriggers(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list_nse_triggers");
        modelAndView.addObject("webpage", this.triggerListingService.listNSETriggers());

        return modelAndView;
    }

    @GetMapping("/nse/jobs")
    public ModelAndView listNSEJobs(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list_nse_jobs");
        modelAndView.addObject("webpage", this.jobListingService.listNSEJobs());

        return modelAndView;
    }
}
