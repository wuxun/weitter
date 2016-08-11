package me.wuxun.weitter.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import me.wuxun.weitter.data.User;
import me.wuxun.weitter.data.Weitter;
import me.wuxun.weitter.service.RelationService;
import me.wuxun.weitter.service.TimeLineService;
import me.wuxun.weitter.service.UserManagerService;

@Service
public class TimeLineServiceImpl implements TimeLineService {

    @Autowired
    private RelationService relationService;

    @Autowired
    private RedisTemplate<String, Weitter> redisTemplate;

    @Autowired
    JdkSerializationRedisSerializer jdkSerializer;

    @Autowired
    private UserManagerService userManagerService;

    private static final int TIMELINE_LEN = 100;

    @Override
    public void addWeitter(Integer userId, Weitter weitter) {

    }

    @Override
    public List<Weitter> getTimeLine(Integer userId) {
        List<Weitter> weitters = redisTemplate.opsForList().range(genKey(userId), 0, -1);
        for (Weitter weitter : weitters) {
            weitter.setUser(userManagerService.getUserById(weitter.getUserId()));
        }
        return weitters;
    }

    @Override
    public void postToFollowersTimeLine(Integer userId, Weitter weitter) {
        List<User> followers = relationService.getAllFollowers(userId);
        RedisCallback<Object> callback = new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection conn) throws DataAccessException {
                conn.openPipeline();
                for (User user : followers) {
                    byte[] key = jdkSerializer.serialize((genKey(user.getId())));
                    Long len = conn.lLen(key);
                    if (len != null && len > TIMELINE_LEN) {
                        conn.rPop(key);
                    }
                    conn.lPush(key, jdkSerializer.serialize(weitter));
                }
                conn.closePipeline();
                return null;
            }
        };
        redisTemplate.execute(callback, true);
    }

    private String genKey(Integer userId) {
        return "user." + userId;
    }

    public void setRelationService(RelationService relationService) {
        this.relationService = relationService;
    }

    public void setRedisTemplate(RedisTemplate<String, Weitter> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setJdkSerializer(JdkSerializationRedisSerializer jdkSerializer) {
        this.jdkSerializer = jdkSerializer;
    }

    public void setUserManagerService(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

}
