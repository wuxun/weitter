package me.wuxun.weitter.service;

import me.wuxun.weitter.data.Weitter;

public interface PostWeitterService {

    public void postWeitter(Weitter weitter);

    public Weitter getWeitterById(Integer id);
}
