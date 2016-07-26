package me.wuxun.weitter.mapper;

import me.wuxun.weitter.data.User;

public interface UserMapper {

	public void insert(User user);
	
	public User getUserById(int id);
	
	public User getUserByName(String name);
}
