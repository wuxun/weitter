package me.wuxun.weitter.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.mapper.UserMapper;
import me.wuxun.weitter.service.UserManagerService;

@Service
public class UserManagerServiceImp implements UserManagerService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void register(User user) {
        userMapper.insert(user);
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
