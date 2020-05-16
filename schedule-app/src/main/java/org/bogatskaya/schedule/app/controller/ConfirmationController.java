package org.bogatskaya.schedule.app.controller;

import org.bogatskaya.schedule.app.domain.Confirmation;
import org.bogatskaya.schedule.app.domain.user.User;
import org.bogatskaya.schedule.app.service.ConfirmationService;
import org.bogatskaya.schedule.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConfirmationController extends BaseController{

    @Autowired
    private ConfirmationService confirmationService;

    @Autowired
    private UserService userService;


    @RequestMapping (value = "/confirmation", method = RequestMethod.GET)
    public String validateToken(@RequestParam(name = "token") String token) {
        Confirmation confirmation = confirmationService.findOne(token);

        if(confirmation != null) {
            User user = userService.findByLogin(confirmation.getUser_name());

            user.setIsConfirmed(true);

            userService.update(user);

            confirmationService.delete(confirmation.getId());

            return "redirect:/success";
        }

        return "redirect:/deny";
    }





}
