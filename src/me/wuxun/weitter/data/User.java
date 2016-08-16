package me.wuxun.weitter.data;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Repository;

@Repository
public class User implements Serializable {

    private static final long serialVersionUID = -2750086841952109039L;

    private Integer id;

    @Size(min = 1, max = 20)
    private String name;

    @Size(min = 6, max = 20)
    private String password;

    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
    }

}
