package com.zy.entity;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/17 - 17 -15:09
 * @Description: com.zy.entity
 * @version: 1.0
 */
public class User {
    private Integer id;
    private String user;
    private String password;

    public User() {
    }

    public User(Integer id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
