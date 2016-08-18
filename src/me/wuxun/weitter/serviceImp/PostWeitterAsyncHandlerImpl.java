package me.wuxun.weitter.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.wuxun.weitter.data.Weitter;
import me.wuxun.weitter.service.PostWeitterAsyncHandler;
import me.wuxun.weitter.service.TimeLineService;

@Service
public class PostWeitterAsyncHandlerImpl implements PostWeitterAsyncHandler {

    @Autowired
    private TimeLineService timeLineService;

    public void setTimeLineService(TimeLineService timeLineService) {
        this.timeLineService = timeLineService;
    }

    @Override
    public void handleWeitter(Weitter weitter) {
        timeLineService.postToFollowersTimeLine(weitter.getUserId(), weitter);
    }

}
