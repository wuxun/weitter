package me.wuxun.weitter.mapper;

import me.wuxun.weitter.data.Weitter;

public interface WeitterMapper {

	public void addWeitter(Weitter weitter);

	public Weitter getWeitterById(Integer id);
}
