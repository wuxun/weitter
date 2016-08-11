package me.wuxun.weitter.data;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

@Repository
public class Weitter implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer userId;
    private Timestamp timestamp;
    private String content;
    private Integer refMessageId;
    private String image;
    private String video;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRefMessageId() {
        return refMessageId;
    }

    public void setRefMessageId(Integer refMessageId) {
        this.refMessageId = refMessageId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Weitter [id=" + id + ", userId=" + userId + ", timestamp=" + timestamp + ", content=" + content
                + ", refMessageId=" + refMessageId + ", image=" + image + ", video=" + video + "]";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
