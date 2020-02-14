/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables;


import cn.edu.nju.teamwiki.jooq.Indexes;
import cn.edu.nju.teamwiki.jooq.Keys;
import cn.edu.nju.teamwiki.jooq.TeamWiki;
import cn.edu.nju.teamwiki.jooq.tables.records.KnowledgeRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


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
public class Knowledge extends TableImpl<KnowledgeRecord> {

    private static final long serialVersionUID = 236807041;

    /**
     * The reference instance of <code>team_wiki.knowledge</code>
     */
    public static final Knowledge KNOWLEDGE = new Knowledge();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<KnowledgeRecord> getRecordType() {
        return KnowledgeRecord.class;
    }

    /**
     * The column <code>team_wiki.knowledge.k_id</code>.
     */
    public final TableField<KnowledgeRecord, Integer> K_ID = createField(DSL.name("k_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>team_wiki.knowledge.k_name</code>.
     */
    public final TableField<KnowledgeRecord, String> K_NAME = createField(DSL.name("k_name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>team_wiki.knowledge.predefined</code>.
     */
    public final TableField<KnowledgeRecord, Boolean> PREDEFINED = createField(DSL.name("predefined"), org.jooq.impl.SQLDataType.BIT.nullable(false), this, "");

    /**
     * The column <code>team_wiki.knowledge.category</code>.
     */
    public final TableField<KnowledgeRecord, Integer> CATEGORY = createField(DSL.name("category"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>team_wiki.knowledge.creator</code>.
     */
    public final TableField<KnowledgeRecord, Integer> CREATOR = createField(DSL.name("creator"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>team_wiki.knowledge</code> table reference
     */
    public Knowledge() {
        this(DSL.name("knowledge"), null);
    }

    /**
     * Create an aliased <code>team_wiki.knowledge</code> table reference
     */
    public Knowledge(String alias) {
        this(DSL.name(alias), KNOWLEDGE);
    }

    /**
     * Create an aliased <code>team_wiki.knowledge</code> table reference
     */
    public Knowledge(Name alias) {
        this(alias, KNOWLEDGE);
    }

    private Knowledge(Name alias, Table<KnowledgeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Knowledge(Name alias, Table<KnowledgeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("A table to contain all knowledge"));
    }

    public <O extends Record> Knowledge(Table<O> child, ForeignKey<O, KnowledgeRecord> key) {
        super(child, key, KNOWLEDGE);
    }

    @Override
    public Schema getSchema() {
        return TeamWiki.TEAM_WIKI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.KNOWLEDGE_KNOWLEDGE_CATEGORY_FK, Indexes.KNOWLEDGE_KNOWLEDGE_CREATOR_FK, Indexes.KNOWLEDGE_K_ID, Indexes.KNOWLEDGE_PRIMARY);
    }

    @Override
    public Identity<KnowledgeRecord, Integer> getIdentity() {
        return Keys.IDENTITY_KNOWLEDGE;
    }

    @Override
    public UniqueKey<KnowledgeRecord> getPrimaryKey() {
        return Keys.KEY_KNOWLEDGE_PRIMARY;
    }

    @Override
    public List<UniqueKey<KnowledgeRecord>> getKeys() {
        return Arrays.<UniqueKey<KnowledgeRecord>>asList(Keys.KEY_KNOWLEDGE_PRIMARY, Keys.KEY_KNOWLEDGE_K_ID);
    }

    @Override
    public List<ForeignKey<KnowledgeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<KnowledgeRecord, ?>>asList(Keys.KNOWLEDGE_CATEGORY_FK, Keys.KNOWLEDGE_CREATOR_FK);
    }

    public Category category() {
        return new Category(this, Keys.KNOWLEDGE_CATEGORY_FK);
    }

    public User user() {
        return new User(this, Keys.KNOWLEDGE_CREATOR_FK);
    }

    @Override
    public Knowledge as(String alias) {
        return new Knowledge(DSL.name(alias), this);
    }

    @Override
    public Knowledge as(Name alias) {
        return new Knowledge(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Knowledge rename(String name) {
        return new Knowledge(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Knowledge rename(Name name) {
        return new Knowledge(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, Boolean, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
