package rave.code.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public ModelAndView home() {
        return this.listQuartzJobs();
    }

    @GetMapping("/jobs")
    public ModelAndView listQuartzJobs(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list_jobs");

        return modelAndView;
    }

    @GetMapping("/triggers")
    public ModelAndView listQuartzTriggers(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list_triggers");

        return modelAndView;
    }
}
