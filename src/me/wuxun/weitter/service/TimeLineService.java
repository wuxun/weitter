package me.wuxun.weitter.service;

import java.util.List;

import me.wuxun.weitter.data.Weitter;

public interface TimeLineService {

	public void addWeitter(Integer userId, Weitter weitter);

	public List<Weitter> getTimeLine(Integer userId);

	public void postToFollowersTimeLine(Integer userId, Weitter weitter);
}
