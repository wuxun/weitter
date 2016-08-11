package me.wuxun.weitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.data.Weitter;
import me.wuxun.weitter.service.TimeLineService;
import me.wuxun.weitter.service.UserManagerService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UserHomePageController {

    @Autowired
    UserManagerService userManagerService;

    @Autowired
    private TimeLineService timelineService;

    @RequestMapping(value = "/u/{userId}", method = GET)
    public String userHomePage(
            @PathVariable("userId") int userId,
            Model model,
            HttpServletRequest request,
            HttpServletResponse response) {
        User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser != null && loginUser.getId() == userId) {
            User user = userManagerService.getUserById(userId);
            model.addAttribute("user", user);
            List<Weitter> weitters = timelineService.getTimeLine(userId);
            model.addAttribute("weitters", weitters);
            return "userHomepage";
        } else {
            return "redirect:/u/" + loginUser.getId();
        }
    }

    public void setTimelineService(TimeLineService timelineService) {
        this.timelineService = timelineService;
    }
}
