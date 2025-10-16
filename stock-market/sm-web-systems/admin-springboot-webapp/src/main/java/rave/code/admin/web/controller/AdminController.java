package rave.code.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.admin.web.service.AdminService;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public ModelAndView home() {
        return this.listQuartzTriggers();
    }

    @GetMapping("/admin/triggers")
    public ModelAndView listQuartzTriggers(){
        AdminService adminService = new AdminService();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list_triggers");
        modelAndView.addObject("webpage", adminService.listTriggers());

        return modelAndView;
    }
}
