package me.wuxun.weitter.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.service.UserManagerService;
import me.wuxun.weitter.util.PasswordHelper;

@Controller
public class LoginController {

    @Autowired
    UserManagerService userManagerService;

    @RequestMapping(value = "/login", method = POST)
    public String processLogin(
            @RequestParam("username") String name,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response) {
        User user = userManagerService.getUserByName(name);
        if (user != null && PasswordHelper.verify(password, user.getPassword())) {
            request.getSession().setAttribute("user", user);
            return "redirect:/u/" + user.getId();
        } else {
            return "redirect:/?error";
        }
    }
}
