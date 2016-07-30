package me.wuxun.weitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.service.UserManagerService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UserHomePageController {

	@Autowired
	UserManagerService userManagerService;

	@RequestMapping(value="/u/{userId}", method=GET)
	public String userHomePage(
			@PathVariable("userId") int userId, Model model) {
		User user = userManagerService.getUserById(userId);
		System.out.println(user);
		model.addAttribute("user", user);
		return "userHomepage";
	}
}
