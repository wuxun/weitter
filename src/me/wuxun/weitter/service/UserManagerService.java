package me.wuxun.weitter.service;

import me.wuxun.weitter.data.User;

public interface UserManagerService {

	public void register(User user);

	public User getUserById(int id);

	public User getUserByName(String name);
}
