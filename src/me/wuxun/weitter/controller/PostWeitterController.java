package me.wuxun.weitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ErrorCoded;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.data.Weitter;
import me.wuxun.weitter.service.PostWeitterService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PostWeitterController {

	@Autowired
	private PostWeitterService postWeitterService;

	@RequestMapping(value="/postWeitter", method=POST)
	public void postWeitter(
			@RequestParam("content") String content,
			HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("/postWeitter " + content);
		User user = (User)request.getSession().getAttribute("user");
		if (user != null) {
			Weitter weitter = new Weitter();
			weitter.setUserId(user.getId());
			weitter.setContent(content);
			weitter.setTimestamp(new Timestamp(System.currentTimeMillis()));
			postWeitterService.postWeitter(weitter);
		}
	}

	public void setPostWeitterService(PostWeitterService postWeitterService) {
		this.postWeitterService = postWeitterService;
	}
}
