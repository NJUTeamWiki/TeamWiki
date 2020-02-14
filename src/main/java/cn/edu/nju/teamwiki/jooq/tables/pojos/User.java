/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * A table to contain all the users
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User implements Serializable {

    private static final long serialVersionUID = -1204278399;

    private Integer userId;
    private String  email;
    private String  username;
    private String  password;
    private Integer role;
    private String  avatar;
    private String  phone;
    private String  introduction;

    public User() {}

    public User(User value) {
        this.userId = value.userId;
        this.email = value.email;
        this.username = value.username;
        this.password = value.password;
        this.role = value.role;
        this.avatar = value.avatar;
        this.phone = value.phone;
        this.introduction = value.introduction;
    }

    public User(
        Integer userId,
        String  email,
        String  username,
        String  password,
        Integer role,
        String  avatar,
        String  phone,
        String  introduction
    ) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
        this.phone = phone;
        this.introduction = introduction;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return this.role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(userId);
        sb.append(", ").append(email);
        sb.append(", ").append(username);
        sb.append(", ").append(password);
        sb.append(", ").append(role);
        sb.append(", ").append(avatar);
        sb.append(", ").append(phone);
        sb.append(", ").append(introduction);

        sb.append(")");
        return sb.toString();
    }
}
