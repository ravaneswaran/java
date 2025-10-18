package rave.code.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.admin.web.service.JobListingService;
import rave.code.admin.web.service.TriggerListingService;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public ModelAndView home() {
        return this.listNSETriggers();
    }

    @GetMapping("/admin/nse/triggers")
    public ModelAndView listNSETriggers(){
        TriggerListingService adminService = new TriggerListingService();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list_nse_triggers");
        modelAndView.addObject("webpage", adminService.listNSETriggers());

        return modelAndView;
    }

    @GetMapping("/admin/nse/jobs")
    public ModelAndView listNSEJobs(){
        JobListingService jobListingService = new JobListingService();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list_nse_jobs");
        modelAndView.addObject("webpage", jobListingService.listNSEJobs());

        return modelAndView;
    }
}
