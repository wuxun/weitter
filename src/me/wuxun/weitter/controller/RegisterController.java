package me.wuxun.weitter.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.service.UserManagerService;
import me.wuxun.weitter.util.PasswordHelper;

@Controller
public class RegisterController {

    @Autowired
    UserManagerService userManagerService;

    private static final String CHECK_NAME_KEY = "repeat";

    @RequestMapping(value = "/register", method = GET)
    public String get() {
        return "register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String post(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/register";
        }

        user.setPassword(PasswordHelper.hash(user.getPassword()));
        userManagerService.register(user);
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/register/checkName", method = POST)
    public ModelAndView checkName(@RequestParam("name") String name) {
        ModelMap model = new ModelMap();
        if (userManagerService.getUserByName(name) != null) {
            model.put(CHECK_NAME_KEY, true);
        } else {
            model.put(CHECK_NAME_KEY, false);
        }
        System.out.println("check:" + model);
        return new ModelAndView(new MappingJackson2JsonView(), model);
    }
}
