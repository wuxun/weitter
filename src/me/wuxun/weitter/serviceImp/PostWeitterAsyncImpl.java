package me.wuxun.weitter.serviceImp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.wuxun.weitter.data.Weitter;
import me.wuxun.weitter.mapper.WeitterMapper;
import me.wuxun.weitter.service.PostWeitterAsync;

@Service
public class PostWeitterAsyncImpl implements PostWeitterAsync {

    @Autowired
    private RabbitTemplate rabbit;

    @Autowired
    private WeitterMapper weitterMapper;

    public void setWeitterMapper(WeitterMapper weitterMapper) {
        this.weitterMapper = weitterMapper;
    }

    @Override
    public void postWeitter(Weitter weitter) {
        weitterMapper.addWeitterAndGetId(weitter);

        rabbit.convertAndSend("me.wuxun.weitter.post", weitter);
    }

    public void setRabbit(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

}
