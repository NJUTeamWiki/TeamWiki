/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables.records;


import cn.edu.nju.teamwiki.jooq.tables.Announcement;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class AnnouncementRecord extends UpdatableRecordImpl<AnnouncementRecord> implements Record3<Integer, String, LocalDateTime> {

    private static final long serialVersionUID = 2038791015;

    /**
     * Setter for <code>team_wiki.announcement.announcement_id</code>.
     */
    public void setAnnouncementId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>team_wiki.announcement.announcement_id</code>.
     */
    public Integer getAnnouncementId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>team_wiki.announcement.content</code>.
     */
    public void setContent(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>team_wiki.announcement.content</code>.
     */
    public String getContent() {
        return (String) get(1);
    }

    /**
     * Setter for <code>team_wiki.announcement.publish_time</code>.
     */
    public void setPublishTime(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>team_wiki.announcement.publish_time</code>.
     */
    public LocalDateTime getPublishTime() {
        return (LocalDateTime) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, LocalDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, LocalDateTime> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Announcement.ANNOUNCEMENT.ANNOUNCEMENT_ID;
    }

    @Override
    public Field<String> field2() {
        return Announcement.ANNOUNCEMENT.CONTENT;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Announcement.ANNOUNCEMENT.PUBLISH_TIME;
    }

    @Override
    public Integer component1() {
        return getAnnouncementId();
    }

    @Override
    public String component2() {
        return getContent();
    }

    @Override
    public LocalDateTime component3() {
        return getPublishTime();
    }

    @Override
    public Integer value1() {
        return getAnnouncementId();
    }

    @Override
    public String value2() {
        return getContent();
    }

    @Override
    public LocalDateTime value3() {
        return getPublishTime();
    }

    @Override
    public AnnouncementRecord value1(Integer value) {
        setAnnouncementId(value);
        return this;
    }

    @Override
    public AnnouncementRecord value2(String value) {
        setContent(value);
        return this;
    }

    @Override
    public AnnouncementRecord value3(LocalDateTime value) {
        setPublishTime(value);
        return this;
    }

    @Override
    public AnnouncementRecord values(Integer value1, String value2, LocalDateTime value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AnnouncementRecord
     */
    public AnnouncementRecord() {
        super(Announcement.ANNOUNCEMENT);
    }

    /**
     * Create a detached, initialised AnnouncementRecord
     */
    public AnnouncementRecord(Integer announcementId, String content, LocalDateTime publishTime) {
        super(Announcement.ANNOUNCEMENT);

        set(0, announcementId);
        set(1, content);
        set(2, publishTime);
    }
}
