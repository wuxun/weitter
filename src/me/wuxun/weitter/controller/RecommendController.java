package me.wuxun.weitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.service.RelationService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RecommendController {

    @Autowired
    private RelationService relationService;

    @RequestMapping(value = "/recommend", method = GET)
    public String getRecommendation(HttpServletRequest request, HttpServletResponse response, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        List<User> userList = Collections.emptyList();
        if (user != null) {
            userList = relationService.getUnfollowers(user.getId(), 10);
        }
        model.addAttribute("userList", userList);
        return "recommend";
    }

    public void setRelationService(RelationService relationService) {
        this.relationService = relationService;
    }
}
