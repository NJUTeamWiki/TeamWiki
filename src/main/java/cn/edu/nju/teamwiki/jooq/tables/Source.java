/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables;


import cn.edu.nju.teamwiki.jooq.Indexes;
import cn.edu.nju.teamwiki.jooq.Keys;
import cn.edu.nju.teamwiki.jooq.TeamWiki;
import cn.edu.nju.teamwiki.jooq.tables.records.SourceRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Source extends TableImpl<SourceRecord> {

    private static final long serialVersionUID = -1366643473;

    /**
     * The reference instance of <code>team_wiki.source</code>
     */
    public static final Source SOURCE = new Source();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SourceRecord> getRecordType() {
        return SourceRecord.class;
    }

    /**
     * The column <code>team_wiki.source.source_type</code>.
     */
    public final TableField<SourceRecord, Integer> SOURCE_TYPE = createField(DSL.name("source_type"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>team_wiki.source.source_name</code>.
     */
    public final TableField<SourceRecord, String> SOURCE_NAME = createField(DSL.name("source_name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>team_wiki.source</code> table reference
     */
    public Source() {
        this(DSL.name("source"), null);
    }

    /**
     * Create an aliased <code>team_wiki.source</code> table reference
     */
    public Source(String alias) {
        this(DSL.name(alias), SOURCE);
    }

    /**
     * Create an aliased <code>team_wiki.source</code> table reference
     */
    public Source(Name alias) {
        this(alias, SOURCE);
    }

    private Source(Name alias, Table<SourceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Source(Name alias, Table<SourceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Source(Table<O> child, ForeignKey<O, SourceRecord> key) {
        super(child, key, SOURCE);
    }

    @Override
    public Schema getSchema() {
        return TeamWiki.TEAM_WIKI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SOURCE_PRIMARY, Indexes.SOURCE_SOURCE_NAME, Indexes.SOURCE_SOURCE_TYPE);
    }

    @Override
    public Identity<SourceRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SOURCE;
    }

    @Override
    public UniqueKey<SourceRecord> getPrimaryKey() {
        return Keys.KEY_SOURCE_PRIMARY;
    }

    @Override
    public List<UniqueKey<SourceRecord>> getKeys() {
        return Arrays.<UniqueKey<SourceRecord>>asList(Keys.KEY_SOURCE_PRIMARY, Keys.KEY_SOURCE_SOURCE_TYPE, Keys.KEY_SOURCE_SOURCE_NAME);
    }

    @Override
    public Source as(String alias) {
        return new Source(DSL.name(alias), this);
    }

    @Override
    public Source as(Name alias) {
        return new Source(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Source rename(String name) {
        return new Source(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Source rename(Name name) {
        return new Source(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}