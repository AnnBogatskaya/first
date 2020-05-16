package org.bogatskaya.schedule.app.controller;

import org.bogatskaya.schedule.app.domain.Confirmation;
import org.bogatskaya.schedule.app.domain.Role;
import org.bogatskaya.schedule.app.domain.user.User;
import org.bogatskaya.schedule.app.dto.UserDTO;
import org.bogatskaya.schedule.app.exception.NotFoundException;
import org.bogatskaya.schedule.app.service.ConfirmationService;
import org.bogatskaya.schedule.app.service.EmailService;
import org.bogatskaya.schedule.app.service.RoleService;
import org.bogatskaya.schedule.app.service.UserService;
import org.bogatskaya.schedule.app.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;

@Controller
public class RegistrationController extends BaseController{

    private static final String SUBJECT = "Email Confirmation";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ConfirmationService confirmationService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("user",new UserDTO());

        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(value = "user") UserDTO userDTO,
                               Model model, BindingResult bindingResult) throws NoSuchAlgorithmException, MessagingException{

        String token = EncodeUtil.generateToken(userDTO.getLogin());
        String encodedPass = EncodeUtil.encodePassword(userDTO.getPassword());

        Confirmation confirmation = new Confirmation(userDTO.getLogin(), token);

        userDTO.setPassword(encodedPass);
        userDTO.setIsConfirmed(false);

        model.addAttribute(userDTO);

        User user = convert(userDTO, User.class);

        Role role = roleService.findOne(1L).orElseThrow(() -> new NotFoundException("No such role with id: ", 1L));

        role.addUser(user);
        user.addRole(role);

        userService.saveUser(user);

        confirmationService.save(confirmation);

        emailService.sendConfirmationMessage(userDTO.getEmail(), SUBJECT, token);

        return "redirect:/confirmationPage";
    }
}
