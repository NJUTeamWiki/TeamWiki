/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables;


import cn.edu.nju.teamwiki.jooq.Indexes;
import cn.edu.nju.teamwiki.jooq.Keys;
import cn.edu.nju.teamwiki.jooq.TeamWiki;
import cn.edu.nju.teamwiki.jooq.tables.records.CategoryRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
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
public class Category extends TableImpl<CategoryRecord> {

    private static final long serialVersionUID = 2122918422;

    /**
     * The reference instance of <code>team_wiki.category</code>
     */
    public static final Category CATEGORY = new Category();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CategoryRecord> getRecordType() {
        return CategoryRecord.class;
    }

    /**
     * The column <code>team_wiki.category.category_id</code>.
     */
    public final TableField<CategoryRecord, Integer> CATEGORY_ID = createField(DSL.name("category_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>team_wiki.category.category_name</code>.
     */
    public final TableField<CategoryRecord, String> CATEGORY_NAME = createField(DSL.name("category_name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>team_wiki.category.predefined</code>.
     */
    public final TableField<CategoryRecord, Boolean> PREDEFINED = createField(DSL.name("predefined"), org.jooq.impl.SQLDataType.BIT.nullable(false), this, "");

    /**
     * Create a <code>team_wiki.category</code> table reference
     */
    public Category() {
        this(DSL.name("category"), null);
    }

    /**
     * Create an aliased <code>team_wiki.category</code> table reference
     */
    public Category(String alias) {
        this(DSL.name(alias), CATEGORY);
    }

    /**
     * Create an aliased <code>team_wiki.category</code> table reference
     */
    public Category(Name alias) {
        this(alias, CATEGORY);
    }

    private Category(Name alias, Table<CategoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Category(Name alias, Table<CategoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Category(Table<O> child, ForeignKey<O, CategoryRecord> key) {
        super(child, key, CATEGORY);
    }

    @Override
    public Schema getSchema() {
        return TeamWiki.TEAM_WIKI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CATEGORY_CATEGORY_ID, Indexes.CATEGORY_PRIMARY);
    }

    @Override
    public Identity<CategoryRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CATEGORY;
    }

    @Override
    public UniqueKey<CategoryRecord> getPrimaryKey() {
        return Keys.KEY_CATEGORY_PRIMARY;
    }

    @Override
    public List<UniqueKey<CategoryRecord>> getKeys() {
        return Arrays.<UniqueKey<CategoryRecord>>asList(Keys.KEY_CATEGORY_PRIMARY, Keys.KEY_CATEGORY_CATEGORY_ID);
    }

    @Override
    public Category as(String alias) {
        return new Category(DSL.name(alias), this);
    }

    @Override
    public Category as(Name alias) {
        return new Category(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Category rename(String name) {
        return new Category(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Category rename(Name name) {
        return new Category(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Boolean> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
