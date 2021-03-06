/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables.daos;


import cn.edu.nju.teamwiki.jooq.tables.Document;
import cn.edu.nju.teamwiki.jooq.tables.records.DocumentRecord;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
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
public class DocumentDao extends DAOImpl<DocumentRecord, cn.edu.nju.teamwiki.jooq.tables.pojos.Document, String> {

    /**
     * Create a new DocumentDao without any configuration
     */
    public DocumentDao() {
        super(Document.DOCUMENT, cn.edu.nju.teamwiki.jooq.tables.pojos.Document.class);
    }

    /**
     * Create a new DocumentDao with an attached configuration
     */
    @Autowired
    public DocumentDao(Configuration configuration) {
        super(Document.DOCUMENT, cn.edu.nju.teamwiki.jooq.tables.pojos.Document.class, configuration);
    }

    @Override
    public String getId(cn.edu.nju.teamwiki.jooq.tables.pojos.Document object) {
        return object.getDId();
    }

    /**
     * Fetch records that have <code>d_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchRangeOfDId(String lowerInclusive, String upperInclusive) {
        return fetchRange(Document.DOCUMENT.D_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>d_id IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchByDId(String... values) {
        return fetch(Document.DOCUMENT.D_ID, values);
    }

    /**
     * Fetch a unique record that has <code>d_id = value</code>
     */
    public cn.edu.nju.teamwiki.jooq.tables.pojos.Document fetchOneByDId(String value) {
        return fetchOne(Document.DOCUMENT.D_ID, value);
    }

    /**
     * Fetch records that have <code>d_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchRangeOfDName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Document.DOCUMENT.D_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>d_name IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchByDName(String... values) {
        return fetch(Document.DOCUMENT.D_NAME, values);
    }

    /**
     * Fetch records that have <code>uploader BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchRangeOfUploader(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Document.DOCUMENT.UPLOADER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>uploader IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchByUploader(Integer... values) {
        return fetch(Document.DOCUMENT.UPLOADER, values);
    }

    /**
     * Fetch records that have <code>uploaded_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchRangeOfUploadedTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Document.DOCUMENT.UPLOADED_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>uploaded_time IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchByUploadedTime(LocalDateTime... values) {
        return fetch(Document.DOCUMENT.UPLOADED_TIME, values);
    }

    /**
     * Fetch records that have <code>modified_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchRangeOfModifiedTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Document.DOCUMENT.MODIFIED_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modified_time IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchByModifiedTime(LocalDateTime... values) {
        return fetch(Document.DOCUMENT.MODIFIED_TIME, values);
    }

    /**
     * Fetch records that have <code>source_type BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchRangeOfSourceType(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Document.DOCUMENT.SOURCE_TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>source_type IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchBySourceType(Integer... values) {
        return fetch(Document.DOCUMENT.SOURCE_TYPE, values);
    }

    /**
     * Fetch records that have <code>source_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchRangeOfSourceId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Document.DOCUMENT.SOURCE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>source_id IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchBySourceId(Integer... values) {
        return fetch(Document.DOCUMENT.SOURCE_ID, values);
    }

    /**
     * Fetch records that have <code>url BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchRangeOfUrl(String lowerInclusive, String upperInclusive) {
        return fetchRange(Document.DOCUMENT.URL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>url IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchByUrl(String... values) {
        return fetch(Document.DOCUMENT.URL, values);
    }

    /**
     * Fetch records that have <code>is_archived BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchRangeOfIsArchived(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(Document.DOCUMENT.IS_ARCHIVED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>is_archived IN (values)</code>
     */
    public List<cn.edu.nju.teamwiki.jooq.tables.pojos.Document> fetchByIsArchived(Boolean... values) {
        return fetch(Document.DOCUMENT.IS_ARCHIVED, values);
    }
}
