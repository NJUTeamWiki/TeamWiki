/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.generator;


import cn.edu.nju.teamwiki.generator.tables.Knowledge;
import cn.edu.nju.teamwiki.generator.tables.Role;
import cn.edu.nju.teamwiki.generator.tables.User;
import cn.edu.nju.teamwiki.generator.tables.records.KnowledgeRecord;
import cn.edu.nju.teamwiki.generator.tables.records.RoleRecord;
import cn.edu.nju.teamwiki.generator.tables.records.UserRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>team_wiki</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<KnowledgeRecord, Integer> IDENTITY_KNOWLEDGE = Identities0.IDENTITY_KNOWLEDGE;
    public static final Identity<RoleRecord, Integer> IDENTITY_ROLE = Identities0.IDENTITY_ROLE;
    public static final Identity<UserRecord, Integer> IDENTITY_USER = Identities0.IDENTITY_USER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<KnowledgeRecord> KEY_KNOWLEDGE_PRIMARY = UniqueKeys0.KEY_KNOWLEDGE_PRIMARY;
    public static final UniqueKey<KnowledgeRecord> KEY_KNOWLEDGE_K_ID = UniqueKeys0.KEY_KNOWLEDGE_K_ID;
    public static final UniqueKey<RoleRecord> KEY_ROLE_PRIMARY = UniqueKeys0.KEY_ROLE_PRIMARY;
    public static final UniqueKey<RoleRecord> KEY_ROLE_ROLE_ID = UniqueKeys0.KEY_ROLE_ROLE_ID;
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<KnowledgeRecord, UserRecord> USER_FK = ForeignKeys0.USER_FK;
    public static final ForeignKey<UserRecord, RoleRecord> ROLE_FK = ForeignKeys0.ROLE_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<KnowledgeRecord, Integer> IDENTITY_KNOWLEDGE = Internal.createIdentity(Knowledge.KNOWLEDGE, Knowledge.KNOWLEDGE.K_ID);
        public static Identity<RoleRecord, Integer> IDENTITY_ROLE = Internal.createIdentity(Role.ROLE, Role.ROLE.ROLE_ID);
        public static Identity<UserRecord, Integer> IDENTITY_USER = Internal.createIdentity(User.USER, User.USER.USER_ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<KnowledgeRecord> KEY_KNOWLEDGE_PRIMARY = Internal.createUniqueKey(Knowledge.KNOWLEDGE, "KEY_knowledge_PRIMARY", Knowledge.KNOWLEDGE.K_ID);
        public static final UniqueKey<KnowledgeRecord> KEY_KNOWLEDGE_K_ID = Internal.createUniqueKey(Knowledge.KNOWLEDGE, "KEY_knowledge_k_id", Knowledge.KNOWLEDGE.K_ID);
        public static final UniqueKey<RoleRecord> KEY_ROLE_PRIMARY = Internal.createUniqueKey(Role.ROLE, "KEY_role_PRIMARY", Role.ROLE.ROLE_ID);
        public static final UniqueKey<RoleRecord> KEY_ROLE_ROLE_ID = Internal.createUniqueKey(Role.ROLE, "KEY_role_role_id", Role.ROLE.ROLE_ID);
        public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, "KEY_user_PRIMARY", User.USER.USER_ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<KnowledgeRecord, UserRecord> USER_FK = Internal.createForeignKey(cn.edu.nju.teamwiki.generator.Keys.KEY_USER_PRIMARY, Knowledge.KNOWLEDGE, "user_fk", Knowledge.KNOWLEDGE.UPLOADER);
        public static final ForeignKey<UserRecord, RoleRecord> ROLE_FK = Internal.createForeignKey(cn.edu.nju.teamwiki.generator.Keys.KEY_ROLE_PRIMARY, User.USER, "role_fk", User.USER.ROLE);
    }
}
