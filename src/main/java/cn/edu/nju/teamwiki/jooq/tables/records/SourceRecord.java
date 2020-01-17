/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables.records;


import cn.edu.nju.teamwiki.jooq.tables.Source;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class SourceRecord extends UpdatableRecordImpl<SourceRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1132228474;

    /**
     * Setter for <code>team_wiki.source.source_type</code>.
     */
    public void setSourceType(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>team_wiki.source.source_type</code>.
     */
    public Integer getSourceType() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>team_wiki.source.source_name</code>.
     */
    public void setSourceName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>team_wiki.source.source_name</code>.
     */
    public String getSourceName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Source.SOURCE.SOURCE_TYPE;
    }

    @Override
    public Field<String> field2() {
        return Source.SOURCE.SOURCE_NAME;
    }

    @Override
    public Integer component1() {
        return getSourceType();
    }

    @Override
    public String component2() {
        return getSourceName();
    }

    @Override
    public Integer value1() {
        return getSourceType();
    }

    @Override
    public String value2() {
        return getSourceName();
    }

    @Override
    public SourceRecord value1(Integer value) {
        setSourceType(value);
        return this;
    }

    @Override
    public SourceRecord value2(String value) {
        setSourceName(value);
        return this;
    }

    @Override
    public SourceRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SourceRecord
     */
    public SourceRecord() {
        super(Source.SOURCE);
    }

    /**
     * Create a detached, initialised SourceRecord
     */
    public SourceRecord(Integer sourceType, String sourceName) {
        super(Source.SOURCE);

        set(0, sourceType);
        set(1, sourceName);
    }
}
