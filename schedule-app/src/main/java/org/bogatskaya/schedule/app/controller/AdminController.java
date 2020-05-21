package org.bogatskaya.schedule.app.controller;

import org.bogatskaya.schedule.app.dto.ScheduleDTO;
import org.bogatskaya.schedule.app.service.RecordService;
import org.bogatskaya.schedule.app.service.ScheduleService;
import org.bogatskaya.schedule.app.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController extends BaseController{

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private RecordService recordService;


    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String getSchedule(Model model){

        model.addAttribute("admin_schedule",scheduleService.findAll());
        return "admin/admin_page";
    }

    @RequestMapping(value = "/admin/create",method = RequestMethod.GET)
    public String createSchedule(Model model){
        model.addAttribute("schedule",new ScheduleDTO());

        return "admin/create_schedule";
    }

    @RequestMapping(value = "/admin/create",method = RequestMethod.POST)
    public String submitSchedule(@ModelAttribute(value = "schedule") ScheduleDTO scheduleDTO,Model model){
        model.addAttribute(scheduleDTO);

        scheduleService.save(ConvertUtil.convertSchedule(scheduleDTO));

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/records",method = RequestMethod.GET)
    public String showRecords(Model model){
        model.addAttribute("records", recordService.findAll());

        return "admin/records";
    }

}
