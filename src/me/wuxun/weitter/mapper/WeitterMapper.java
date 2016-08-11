package me.wuxun.weitter.mapper;

import me.wuxun.weitter.data.Weitter;

public interface WeitterMapper {

    public void addWeitterAndGetId(Weitter weitter);

	public Weitter getWeitterById(Integer id);
}
