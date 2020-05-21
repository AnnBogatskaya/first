package org.bogatskaya.schedule.app.controller;

import org.bogatskaya.schedule.app.domain.schedule.Record;
import org.bogatskaya.schedule.app.domain.schedule.Schedule;
import org.bogatskaya.schedule.app.domain.user.User;
import org.bogatskaya.schedule.app.dto.RecordDTO;
import org.bogatskaya.schedule.app.service.RecordService;
import org.bogatskaya.schedule.app.service.ScheduleService;
import org.bogatskaya.schedule.app.service.UserService;
import org.bogatskaya.schedule.app.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class UserController extends BaseController{

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/user/{login}", method = RequestMethod.GET)
    public String userPage(HttpServletRequest request, Model model, @PathVariable String login) {
        HttpSession session = request.getSession();

        String fullName =  (String) session.getAttribute("fullname");
        String logIn =  (String) session.getAttribute("login");

        if(fullName != null && logIn != null) {
            model.addAttribute("fullname", session.getAttribute("fullname"));
            model.addAttribute("login", session.getAttribute("login"));

            if((Boolean) session.getAttribute("isAuthenticated")
                    && session.getAttribute("login") != null) {

                return "user/user_page";
            }
        }

        return "redirect:/deny";

    }

    @RequestMapping(value = "/user/appointment",method = RequestMethod.GET)
    public String appointment(Model model){
        //todo add "there is no any schedule"

        model.addAttribute("schedules",scheduleService.findAllAvailable());
        model.addAttribute("record",new RecordDTO());

        return "user/appointment";
    }

    @Transactional
    @RequestMapping(value = "/user/appointment",method = RequestMethod.POST)
    public String submitRecord(HttpServletRequest request){
        User user = userService.findCurrent(request);

        RecordDTO recordDTO = new RecordDTO();

        recordDTO.setComplaint(request.getParameter("complaint"));
        recordDTO.setFullname((String)request.getSession().getAttribute("fullname"));
        recordDTO.setTime(request.getParameter("timeFrom"));
        recordDTO.setDate(request.getParameter("date"));

        Record record = ConvertUtil.convertRecord(recordDTO);

        record.setUser(user);

        user.addRecord(record);

        recordService.addRecord(record);

        Schedule schedule = scheduleService.findByDateAndTime(LocalDate.parse(recordDTO.getDate()), LocalTime.parse(recordDTO.getTime()));

        schedule.setAvailable(false);

        scheduleService.update(schedule);

        return "user/record_success";
    }

    @RequestMapping(value = "/user/records",method = RequestMethod.GET)
    public String getUserRecords(Model model,HttpServletRequest request){
        User user = userService.findCurrent(request);

        List<Record> userRecords = recordService.findAllByUserId(user.getId());

        model.addAttribute("records", userRecords);
        return "/user/user_records";
    }
}
