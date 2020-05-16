package org.bogatskaya.schedule.app.controller.rest;

import org.bogatskaya.schedule.app.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAdminController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(value = "/admin/delete")
    public void deleteSchedule(@RequestParam(name = "id") Long id) {
        scheduleService.removeSchedule(id);
    }
}
