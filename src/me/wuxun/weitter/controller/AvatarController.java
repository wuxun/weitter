package me.wuxun.weitter.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import me.wuxun.weitter.conf.ProjectConfig;
import me.wuxun.weitter.data.User;
import me.wuxun.weitter.service.UserManagerService;
import me.wuxun.weitter.util.FileNameGenerator;

@Controller
public class AvatarController {

    @Autowired
    private UserManagerService userManagerService;

    @RequestMapping(value = "/avatar", method = GET)
    public String avatar() {
        return "avatar";
    }

    @RequestMapping(value = "/avatar", method = POST)
    public ResponseEntity<?> postAvatar(
            @RequestPart("avatar") MultipartFile avatar,
            HttpServletRequest request,
            HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null && avatar.getSize() > 0) {
            String fileName = FileNameGenerator.getAvatarName("" + user.getId(), avatar.getContentType());
            String fullFileDir = ProjectConfig.getAvatarSavePath() + fileName;
            File file = new File(fullFileDir);
            try {
                if (file.exists()) {
                    file.delete();
                }
                avatar.transferTo(file);
                user.setAvatar(fileName);
                userManagerService.updateUser(user);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public void setUserManagerService(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }
}
