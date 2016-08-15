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

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
