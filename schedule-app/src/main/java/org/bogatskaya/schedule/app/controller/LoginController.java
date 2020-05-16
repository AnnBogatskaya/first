package org.bogatskaya.schedule.app.controller;

import org.bogatskaya.schedule.app.domain.user.User;
import org.bogatskaya.schedule.app.dto.LoginDTO;
import org.bogatskaya.schedule.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController{

    private static final String USER = "user";

    private static final String ADMIN = "admin";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(Model model){

        model.addAttribute("login",new LoginDTO());
        return "signin";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("login") LoginDTO loginDTO, Model model,
                               HttpServletRequest request){

        User user = userService.findByLogin(loginDTO.getUserName());

        if(user != null && user.hasRole(USER) && user.getIsConfirmed()){
            HttpSession session = request.getSession();

            session.setAttribute("fullname",user.getFullname());
            session.setAttribute("isAuthenticated", true);
            session.setAttribute("login", user.getLogin());

            model.addAttribute("fullname",session.getAttribute("fullname"));

            return "redirect:/user/".concat(user.getLogin());

        }else if(user != null && user.hasRole(ADMIN)){
            return "redirect:/admin";
        }

        return "redirect:/deny";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logOut(HttpServletRequest request){
        request.getSession().invalidate();

        return "redirect:/login";
    }
}
