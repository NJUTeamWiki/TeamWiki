/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables.daos;


import cn.edu.nju.teamwiki.jooq.tables.Knowledge;
import cn.edu.nju.teamwiki.jooq.tables.records.KnowledgeRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * A table to contain all knowledge
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
public class KnowledgeDao extends DAOImpl<KnowledgeRecord, cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge, Integer> {

    /**
     * Create a new KnowledgeDao without any configuration
     */
    public KnowledgeDao() {
        super(Knowledge.KNOWLEDGE, cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge.class);
    }

    /**
     * Create a new KnowledgeDao with an attached configuration
     */
    @Autowired
    public KnowledgeDao(Configuration configuration) {
        super(Knowledge.KNOWLEDGE, cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge.class, configuration);
    }

    @Override
    public Integer getId(cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge object) {
        return object.getKId();
    }

    /**
     * Fetch records that have <code>k_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge> fetchRangeOfKId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Knowledge.KNOWLEDGE.K_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>k_id IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge> fetchByKId(Integer... values) {
        return fetch(Knowledge.KNOWLEDGE.K_ID, values);
    }

    /**
     * Fetch a unique record that has <code>k_id = value</code>
     */
    public cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge fetchOneByKId(Integer value) {
        return fetchOne(Knowledge.KNOWLEDGE.K_ID, value);
    }

    /**
     * Fetch records that have <code>k_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge> fetchRangeOfKName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Knowledge.KNOWLEDGE.K_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>k_name IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge> fetchByKName(String... values) {
        return fetch(Knowledge.KNOWLEDGE.K_NAME, values);
    }

    /**
     * Fetch records that have <code>predefined BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge> fetchRangeOfPredefined(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(Knowledge.KNOWLEDGE.PREDEFINED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>predefined IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge> fetchByPredefined(Boolean... values) {
        return fetch(Knowledge.KNOWLEDGE.PREDEFINED, values);
    }

    /**
     * Fetch records that have <code>category BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge> fetchRangeOfCategory(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Knowledge.KNOWLEDGE.CATEGORY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>category IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge> fetchByCategory(Integer... values) {
        return fetch(Knowledge.KNOWLEDGE.CATEGORY, values);
    }

    /**
     * Fetch records that have <code>creator BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge> fetchRangeOfCreator(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Knowledge.KNOWLEDGE.CREATOR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>creator IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge> fetchByCreator(Integer... values) {
        return fetch(Knowledge.KNOWLEDGE.CREATOR, values);
    }
}
