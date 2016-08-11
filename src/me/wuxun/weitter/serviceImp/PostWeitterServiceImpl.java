package me.wuxun.weitter.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.wuxun.weitter.data.Weitter;
import me.wuxun.weitter.mapper.WeitterMapper;
import me.wuxun.weitter.service.PostWeitterService;
import me.wuxun.weitter.service.TimeLineService;

@Service
public class PostWeitterServiceImpl implements PostWeitterService {

	@Autowired
	private WeitterMapper weitterMapper;

	@Autowired
	TimeLineService timeLineService;

	@Override
	public void postWeitter(Weitter weitter) {
        weitterMapper.addWeitterAndGetId(weitter);

		timeLineService.postToFollowersTimeLine(weitter.getUserId(), weitter);
	}

	@Override
	public Weitter getWeitterById(Integer id) {
		return weitterMapper.getWeitterById(id);
	}

	public void setWeitterMapper(WeitterMapper weitterMapper) {
		this.weitterMapper = weitterMapper;
	}

	public void setTimeLineService(TimeLineService timeLineService) {
		this.timeLineService = timeLineService;
	}
}
