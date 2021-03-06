/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables.daos;


import cn.edu.nju.teamwiki.jooq.tables.User;
import cn.edu.nju.teamwiki.jooq.tables.records.UserRecord;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
@Repository
public class UserDao extends DAOImpl<UserRecord, cn.edu.nju.teamwiki.jooq.tables.pojos.User, Integer> {

    /**
     * Create a new UserDao without any configuration
     */
    public UserDao() {
        super(User.USER, cn.edu.nju.teamwiki.jooq.tables.pojos.User.class);
    }

    /**
     * Create a new UserDao with an attached configuration
     */
    @Autowired
    public UserDao(Configuration configuration) {
        super(User.USER, cn.edu.nju.teamwiki.jooq.tables.pojos.User.class, configuration);
    }

    @Override
    public Integer getId(cn.edu.nju.teamwiki.jooq.tables.pojos.User object) {
        return object.getUserId();
    }

    /**
     * Fetch records that have <code>user_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchRangeOfUserId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(User.USER.USER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchByUserId(Integer... values) {
        return fetch(User.USER.USER_ID, values);
    }

    /**
     * Fetch a unique record that has <code>user_id = value</code>
     */
    public cn.edu.nju.teamwiki.jooq.tables.pojos.User fetchOneByUserId(Integer value) {
        return fetchOne(User.USER.USER_ID, value);
    }

    /**
     * Fetch records that have <code>email BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchRangeOfEmail(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.EMAIL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchByEmail(String... values) {
        return fetch(User.USER.EMAIL, values);
    }

    /**
     * Fetch a unique record that has <code>email = value</code>
     */
    public cn.edu.nju.teamwiki.jooq.tables.pojos.User fetchOneByEmail(String value) {
        return fetchOne(User.USER.EMAIL, value);
    }

    /**
     * Fetch records that have <code>username BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchRangeOfUsername(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.USERNAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchByUsername(String... values) {
        return fetch(User.USER.USERNAME, values);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchRangeOfPassword(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.PASSWORD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchByPassword(String... values) {
        return fetch(User.USER.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>role BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchRangeOfRole(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(User.USER.ROLE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>role IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchByRole(Integer... values) {
        return fetch(User.USER.ROLE, values);
    }

    /**
     * Fetch records that have <code>avatar BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchRangeOfAvatar(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.AVATAR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>avatar IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchByAvatar(String... values) {
        return fetch(User.USER.AVATAR, values);
    }

    /**
     * Fetch records that have <code>phone BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchRangeOfPhone(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.PHONE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>phone IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchByPhone(String... values) {
        return fetch(User.USER.PHONE, values);
    }

    /**
     * Fetch records that have <code>introduction BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchRangeOfIntroduction(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.INTRODUCTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>introduction IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchByIntroduction(String... values) {
        return fetch(User.USER.INTRODUCTION, values);
    }

    /**
     * Fetch records that have <code>create_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchRangeOfCreateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(User.USER.CREATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.User> fetchByCreateTime(LocalDateTime... values) {
        return fetch(User.USER.CREATE_TIME, values);
    }
}
