package me.wuxun.weitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.service.RelationService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RelationController {

    @Autowired
    private RelationService relationService;

    @RequestMapping(value = "/follow", method = POST)
    public ResponseEntity<?> follow(
            @RequestParam("userId") Integer userId,
            @RequestParam("follow") boolean follow,
            HttpServletRequest request,
            HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            if (follow) {
                relationService.addFollower(userId, user.getId());
                System.out.println("add follower");
            } else {
                relationService.removeFollower(userId, user.getId());
                System.out.println("delete follower");
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void setRelationService(RelationService relationService) {
        this.relationService = relationService;
    }
}
