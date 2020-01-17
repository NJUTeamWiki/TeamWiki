/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables.records;


import cn.edu.nju.teamwiki.jooq.tables.Share;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ShareRecord extends UpdatableRecordImpl<ShareRecord> implements Record5<Integer, String, String, Integer, LocalDateTime> {

    private static final long serialVersionUID = 2055957456;

    /**
     * Setter for <code>team_wiki.share.share_id</code>.
     */
    public void setShareId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>team_wiki.share.share_id</code>.
     */
    public Integer getShareId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>team_wiki.share.share_title</code>.
     */
    public void setShareTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>team_wiki.share.share_title</code>.
     */
    public String getShareTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>team_wiki.share.share_content</code>.
     */
    public void setShareContent(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>team_wiki.share.share_content</code>.
     */
    public String getShareContent() {
        return (String) get(2);
    }

    /**
     * Setter for <code>team_wiki.share.share_user</code>.
     */
    public void setShareUser(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>team_wiki.share.share_user</code>.
     */
    public Integer getShareUser() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>team_wiki.share.share_time</code>.
     */
    public void setShareTime(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>team_wiki.share.share_time</code>.
     */
    public LocalDateTime getShareTime() {
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
        return Share.SHARE.SHARE_ID;
    }

    @Override
    public Field<String> field2() {
        return Share.SHARE.SHARE_TITLE;
    }

    @Override
    public Field<String> field3() {
        return Share.SHARE.SHARE_CONTENT;
    }

    @Override
    public Field<Integer> field4() {
        return Share.SHARE.SHARE_USER;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Share.SHARE.SHARE_TIME;
    }

    @Override
    public Integer component1() {
        return getShareId();
    }

    @Override
    public String component2() {
        return getShareTitle();
    }

    @Override
    public String component3() {
        return getShareContent();
    }

    @Override
    public Integer component4() {
        return getShareUser();
    }

    @Override
    public LocalDateTime component5() {
        return getShareTime();
    }

    @Override
    public Integer value1() {
        return getShareId();
    }

    @Override
    public String value2() {
        return getShareTitle();
    }

    @Override
    public String value3() {
        return getShareContent();
    }

    @Override
    public Integer value4() {
        return getShareUser();
    }

    @Override
    public LocalDateTime value5() {
        return getShareTime();
    }

    @Override
    public ShareRecord value1(Integer value) {
        setShareId(value);
        return this;
    }

    @Override
    public ShareRecord value2(String value) {
        setShareTitle(value);
        return this;
    }

    @Override
    public ShareRecord value3(String value) {
        setShareContent(value);
        return this;
    }

    @Override
    public ShareRecord value4(Integer value) {
        setShareUser(value);
        return this;
    }

    @Override
    public ShareRecord value5(LocalDateTime value) {
        setShareTime(value);
        return this;
    }

    @Override
    public ShareRecord values(Integer value1, String value2, String value3, Integer value4, LocalDateTime value5) {
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
     * Create a detached ShareRecord
     */
    public ShareRecord() {
        super(Share.SHARE);
    }

    /**
     * Create a detached, initialised ShareRecord
     */
    public ShareRecord(Integer shareId, String shareTitle, String shareContent, Integer shareUser, LocalDateTime shareTime) {
        super(Share.SHARE);

        set(0, shareId);
        set(1, shareTitle);
        set(2, shareContent);
        set(3, shareUser);
        set(4, shareTime);
    }
}
