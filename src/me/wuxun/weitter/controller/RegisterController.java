package me.wuxun.weitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.service.UserManagerService;
import me.wuxun.weitter.util.PasswordHelper;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class RegisterController {

	@Autowired
	UserManagerService userManagerService;

	@RequestMapping(value="/register", method=GET)
	public String get() {
		return "register";
	}

	@RequestMapping(value="/register", method=POST)
	public String post(
			@RequestParam("username") String name,
			@RequestParam("password") String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(PasswordHelper.hash(password));
		userManagerService.register(user);
		return "redirect:/";
	}
}
