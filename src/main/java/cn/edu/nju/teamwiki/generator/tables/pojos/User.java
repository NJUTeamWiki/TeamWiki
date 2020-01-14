/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.generator.tables.pojos;


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

    private static final long serialVersionUID = 1419158244;

    private Integer userId;
    private String  username;
    private String  password;
    private String  email;
    private Integer role;

    public User() {}

    public User(User value) {
        this.userId = value.userId;
        this.username = value.username;
        this.password = value.password;
        this.email = value.email;
        this.role = value.role;
    }

    public User(
        Integer userId,
        String  username,
        String  password,
        String  email,
        Integer role
    ) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return this.role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(userId);
        sb.append(", ").append(username);
        sb.append(", ").append(password);
        sb.append(", ").append(email);
        sb.append(", ").append(role);

        sb.append(")");
        return sb.toString();
    }
}
