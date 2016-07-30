package me.wuxun.weitter.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.wuxun.weitter.data.Weitter;
import me.wuxun.weitter.mapper.WeitterMapper;
import me.wuxun.weitter.service.PostWeitterService;

@Service
public class PostWeitterServiceImpl implements PostWeitterService {

	@Autowired
	private WeitterMapper weitterMapper;

	@Override
	public void postWeitter(Weitter weitter) {
		weitterMapper.addWeitter(weitter);
	}

	@Override
	public Weitter getWeitterById(Integer id) {
		return weitterMapper.getWeitterById(id);
	}

	public void setWeitterMapper(WeitterMapper weitterMapper) {
		this.weitterMapper = weitterMapper;
	}
}
