package me.wuxun.weitter.mapper;

import java.util.List;

import me.wuxun.weitter.data.User;

public interface RelationMapper {

	public void addFollower(Integer userId, Integer followerId);

	public void removeFollower(Integer userId, Integer followerId);

	public List<User> getAllFollowers(Integer userId);

	public List<User> getUnfollowers(Integer userId, int num);
}
