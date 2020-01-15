/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq;


import cn.edu.nju.teamwiki.jooq.tables.Knowledge;
import cn.edu.nju.teamwiki.jooq.tables.Role;
import cn.edu.nju.teamwiki.jooq.tables.User;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>team_wiki</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index KNOWLEDGE_K_ID = Indexes0.KNOWLEDGE_K_ID;
    public static final Index KNOWLEDGE_PRIMARY = Indexes0.KNOWLEDGE_PRIMARY;
    public static final Index KNOWLEDGE_USER_FK = Indexes0.KNOWLEDGE_USER_FK;
    public static final Index ROLE_PRIMARY = Indexes0.ROLE_PRIMARY;
    public static final Index ROLE_ROLE_ID = Indexes0.ROLE_ROLE_ID;
    public static final Index USER_PRIMARY = Indexes0.USER_PRIMARY;
    public static final Index USER_ROLE_FK = Indexes0.USER_ROLE_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index KNOWLEDGE_K_ID = Internal.createIndex("k_id", Knowledge.KNOWLEDGE, new OrderField[] { Knowledge.KNOWLEDGE.K_ID }, true);
        public static Index KNOWLEDGE_PRIMARY = Internal.createIndex("PRIMARY", Knowledge.KNOWLEDGE, new OrderField[] { Knowledge.KNOWLEDGE.K_ID }, true);
        public static Index KNOWLEDGE_USER_FK = Internal.createIndex("user_fk", Knowledge.KNOWLEDGE, new OrderField[] { Knowledge.KNOWLEDGE.UPLOADER }, false);
        public static Index ROLE_PRIMARY = Internal.createIndex("PRIMARY", Role.ROLE, new OrderField[] { Role.ROLE.ROLE_ID }, true);
        public static Index ROLE_ROLE_ID = Internal.createIndex("role_id", Role.ROLE, new OrderField[] { Role.ROLE.ROLE_ID }, true);
        public static Index USER_PRIMARY = Internal.createIndex("PRIMARY", User.USER, new OrderField[] { User.USER.USER_ID }, true);
        public static Index USER_ROLE_FK = Internal.createIndex("role_fk", User.USER, new OrderField[] { User.USER.ROLE }, false);
    }
}
