/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.generator.tables.records;


import cn.edu.nju.teamwiki.generator.tables.Knowledge;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class KnowledgeRecord extends UpdatableRecordImpl<KnowledgeRecord> implements Record5<Integer, String, String, Integer, LocalDateTime> {

    private static final long serialVersionUID = 131207100;

    /**
     * Setter for <code>team_wiki.knowledge.k_id</code>.
     */
    public void setKId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>team_wiki.knowledge.k_id</code>.
     */
    public Integer getKId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>team_wiki.knowledge.k_name</code>.
     */
    public void setKName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>team_wiki.knowledge.k_name</code>.
     */
    public String getKName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>team_wiki.knowledge.storage_path</code>.
     */
    public void setStoragePath(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>team_wiki.knowledge.storage_path</code>.
     */
    public String getStoragePath() {
        return (String) get(2);
    }

    /**
     * Setter for <code>team_wiki.knowledge.uploader</code>.
     */
    public void setUploader(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>team_wiki.knowledge.uploader</code>.
     */
    public Integer getUploader() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>team_wiki.knowledge.upload_time</code>.
     */
    public void setUploadTime(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>team_wiki.knowledge.upload_time</code>.
     */
    public LocalDateTime getUploadTime() {
        return (LocalDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, Integer, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, String, Integer, LocalDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Knowledge.KNOWLEDGE.K_ID;
    }

    @Override
    public Field<String> field2() {
        return Knowledge.KNOWLEDGE.K_NAME;
    }

    @Override
    public Field<String> field3() {
        return Knowledge.KNOWLEDGE.STORAGE_PATH;
    }

    @Override
    public Field<Integer> field4() {
        return Knowledge.KNOWLEDGE.UPLOADER;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Knowledge.KNOWLEDGE.UPLOAD_TIME;
    }

    @Override
    public Integer component1() {
        return getKId();
    }

    @Override
    public String component2() {
        return getKName();
    }

    @Override
    public String component3() {
        return getStoragePath();
    }

    @Override
    public Integer component4() {
        return getUploader();
    }

    @Override
    public LocalDateTime component5() {
        return getUploadTime();
    }

    @Override
    public Integer value1() {
        return getKId();
    }

    @Override
    public String value2() {
        return getKName();
    }

    @Override
    public String value3() {
        return getStoragePath();
    }

    @Override
    public Integer value4() {
        return getUploader();
    }

    @Override
    public LocalDateTime value5() {
        return getUploadTime();
    }

    @Override
    public KnowledgeRecord value1(Integer value) {
        setKId(value);
        return this;
    }

    @Override
    public KnowledgeRecord value2(String value) {
        setKName(value);
        return this;
    }

    @Override
    public KnowledgeRecord value3(String value) {
        setStoragePath(value);
        return this;
    }

    @Override
    public KnowledgeRecord value4(Integer value) {
        setUploader(value);
        return this;
    }

    @Override
    public KnowledgeRecord value5(LocalDateTime value) {
        setUploadTime(value);
        return this;
    }

    @Override
    public KnowledgeRecord values(Integer value1, String value2, String value3, Integer value4, LocalDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached KnowledgeRecord
     */
    public KnowledgeRecord() {
        super(Knowledge.KNOWLEDGE);
    }

    /**
     * Create a detached, initialised KnowledgeRecord
     */
    public KnowledgeRecord(Integer kId, String kName, String storagePath, Integer uploader, LocalDateTime uploadTime) {
        super(Knowledge.KNOWLEDGE);

        set(0, kId);
        set(1, kName);
        set(2, storagePath);
        set(3, uploader);
        set(4, uploadTime);
    }
}
