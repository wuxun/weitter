package me.wuxun.weitter.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.mapper.RelationMapper;
import me.wuxun.weitter.service.RelationService;

@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationMapper relationMapper;

    @Override
    public void addFollower(Integer userId, Integer followerId) {
        relationMapper.addFollower(userId, followerId);
    }

    @Override
    public void removeFollower(Integer userId, Integer followerId) {
        relationMapper.removeFollower(userId, followerId);
    }

    @Override
    public List<User> getAllFollowers(Integer userId) {
        return relationMapper.getAllFollowers(userId);
    }

    @Override
    public List<User> getUnfollowers(Integer userId, int num) {
        return relationMapper.getUnfollowers(userId, num);
    }

    public void setRelationMapper(RelationMapper relationMapper) {
        this.relationMapper = relationMapper;
    }
}
