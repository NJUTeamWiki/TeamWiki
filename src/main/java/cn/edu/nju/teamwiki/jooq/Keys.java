/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq;


import cn.edu.nju.teamwiki.jooq.tables.*;
import cn.edu.nju.teamwiki.jooq.tables.records.*;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import javax.annotation.Generated;


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
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CategoryRecord, Integer> IDENTITY_CATEGORY = Identities0.IDENTITY_CATEGORY;
    public static final Identity<KnowledgeRecord, Integer> IDENTITY_KNOWLEDGE = Identities0.IDENTITY_KNOWLEDGE;
    public static final Identity<PortalRecord, Integer> IDENTITY_PORTAL = Identities0.IDENTITY_PORTAL;
    public static final Identity<RoleRecord, Integer> IDENTITY_ROLE = Identities0.IDENTITY_ROLE;
    public static final Identity<ShareRecord, Integer> IDENTITY_SHARE = Identities0.IDENTITY_SHARE;
    public static final Identity<SourceRecord, Integer> IDENTITY_SOURCE = Identities0.IDENTITY_SOURCE;
    public static final Identity<UserRecord, Integer> IDENTITY_USER = Identities0.IDENTITY_USER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CategoryRecord> KEY_CATEGORY_PRIMARY = UniqueKeys0.KEY_CATEGORY_PRIMARY;
    public static final UniqueKey<CategoryRecord> KEY_CATEGORY_CATEGORY_ID = UniqueKeys0.KEY_CATEGORY_CATEGORY_ID;
    public static final UniqueKey<DocumentRecord> KEY_DOCUMENT_PRIMARY = UniqueKeys0.KEY_DOCUMENT_PRIMARY;
    public static final UniqueKey<DocumentRecord> KEY_DOCUMENT_D_ID = UniqueKeys0.KEY_DOCUMENT_D_ID;
    public static final UniqueKey<KnowledgeRecord> KEY_KNOWLEDGE_PRIMARY = UniqueKeys0.KEY_KNOWLEDGE_PRIMARY;
    public static final UniqueKey<KnowledgeRecord> KEY_KNOWLEDGE_K_ID = UniqueKeys0.KEY_KNOWLEDGE_K_ID;
    public static final UniqueKey<PortalRecord> KEY_PORTAL_PRIMARY = UniqueKeys0.KEY_PORTAL_PRIMARY;
    public static final UniqueKey<PortalRecord> KEY_PORTAL_PORTAL_ID = UniqueKeys0.KEY_PORTAL_PORTAL_ID;
    public static final UniqueKey<RoleRecord> KEY_ROLE_PRIMARY = UniqueKeys0.KEY_ROLE_PRIMARY;
    public static final UniqueKey<RoleRecord> KEY_ROLE_ROLE_ID = UniqueKeys0.KEY_ROLE_ROLE_ID;
    public static final UniqueKey<RoleRecord> KEY_ROLE_ROLE_NAME = UniqueKeys0.KEY_ROLE_ROLE_NAME;
    public static final UniqueKey<ShareRecord> KEY_SHARE_PRIMARY = UniqueKeys0.KEY_SHARE_PRIMARY;
    public static final UniqueKey<ShareRecord> KEY_SHARE_SHARE_ID = UniqueKeys0.KEY_SHARE_SHARE_ID;
    public static final UniqueKey<SourceRecord> KEY_SOURCE_PRIMARY = UniqueKeys0.KEY_SOURCE_PRIMARY;
    public static final UniqueKey<SourceRecord> KEY_SOURCE_SOURCE_TYPE = UniqueKeys0.KEY_SOURCE_SOURCE_TYPE;
    public static final UniqueKey<SourceRecord> KEY_SOURCE_SOURCE_NAME = UniqueKeys0.KEY_SOURCE_SOURCE_NAME;
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_EMAIL = UniqueKeys0.KEY_USER_EMAIL;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<DocumentRecord, SourceRecord> DOCUMENT_SOURCE_FK = ForeignKeys0.DOCUMENT_SOURCE_FK;
    public static final ForeignKey<KnowledgeRecord, CategoryRecord> KNOWLEDGE_CATEGORY_FK = ForeignKeys0.KNOWLEDGE_CATEGORY_FK;
    public static final ForeignKey<KnowledgeRecord, UserRecord> KNOWLEDGE_CREATOR_FK = ForeignKeys0.KNOWLEDGE_CREATOR_FK;
    public static final ForeignKey<ShareRecord, UserRecord> SHARE_USER_FK = ForeignKeys0.SHARE_USER_FK;
    public static final ForeignKey<UserRecord, RoleRecord> ROLE_FK = ForeignKeys0.ROLE_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<CategoryRecord, Integer> IDENTITY_CATEGORY = Internal.createIdentity(Category.CATEGORY, Category.CATEGORY.CATEGORY_ID);
        public static Identity<KnowledgeRecord, Integer> IDENTITY_KNOWLEDGE = Internal.createIdentity(Knowledge.KNOWLEDGE, Knowledge.KNOWLEDGE.K_ID);
        public static Identity<PortalRecord, Integer> IDENTITY_PORTAL = Internal.createIdentity(Portal.PORTAL, Portal.PORTAL.PORTAL_ID);
        public static Identity<RoleRecord, Integer> IDENTITY_ROLE = Internal.createIdentity(Role.ROLE, Role.ROLE.ROLE_ID);
        public static Identity<ShareRecord, Integer> IDENTITY_SHARE = Internal.createIdentity(Share.SHARE, Share.SHARE.SHARE_ID);
        public static Identity<SourceRecord, Integer> IDENTITY_SOURCE = Internal.createIdentity(Source.SOURCE, Source.SOURCE.SOURCE_TYPE);
        public static Identity<UserRecord, Integer> IDENTITY_USER = Internal.createIdentity(User.USER, User.USER.USER_ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<CategoryRecord> KEY_CATEGORY_PRIMARY = Internal.createUniqueKey(Category.CATEGORY, "KEY_category_PRIMARY", Category.CATEGORY.CATEGORY_ID);
        public static final UniqueKey<CategoryRecord> KEY_CATEGORY_CATEGORY_ID = Internal.createUniqueKey(Category.CATEGORY, "KEY_category_category_id", Category.CATEGORY.CATEGORY_ID);
        public static final UniqueKey<DocumentRecord> KEY_DOCUMENT_PRIMARY = Internal.createUniqueKey(Document.DOCUMENT, "KEY_document_PRIMARY", Document.DOCUMENT.D_ID);
        public static final UniqueKey<DocumentRecord> KEY_DOCUMENT_D_ID = Internal.createUniqueKey(Document.DOCUMENT, "KEY_document_d_id", Document.DOCUMENT.D_ID);
        public static final UniqueKey<KnowledgeRecord> KEY_KNOWLEDGE_PRIMARY = Internal.createUniqueKey(Knowledge.KNOWLEDGE, "KEY_knowledge_PRIMARY", Knowledge.KNOWLEDGE.K_ID);
        public static final UniqueKey<KnowledgeRecord> KEY_KNOWLEDGE_K_ID = Internal.createUniqueKey(Knowledge.KNOWLEDGE, "KEY_knowledge_k_id", Knowledge.KNOWLEDGE.K_ID);
        public static final UniqueKey<PortalRecord> KEY_PORTAL_PRIMARY = Internal.createUniqueKey(Portal.PORTAL, "KEY_portal_PRIMARY", Portal.PORTAL.PORTAL_ID);
        public static final UniqueKey<PortalRecord> KEY_PORTAL_PORTAL_ID = Internal.createUniqueKey(Portal.PORTAL, "KEY_portal_portal_id", Portal.PORTAL.PORTAL_ID);
        public static final UniqueKey<RoleRecord> KEY_ROLE_PRIMARY = Internal.createUniqueKey(Role.ROLE, "KEY_role_PRIMARY", Role.ROLE.ROLE_ID);
        public static final UniqueKey<RoleRecord> KEY_ROLE_ROLE_ID = Internal.createUniqueKey(Role.ROLE, "KEY_role_role_id", Role.ROLE.ROLE_ID);
        public static final UniqueKey<RoleRecord> KEY_ROLE_ROLE_NAME = Internal.createUniqueKey(Role.ROLE, "KEY_role_role_name", Role.ROLE.ROLE_NAME);
        public static final UniqueKey<ShareRecord> KEY_SHARE_PRIMARY = Internal.createUniqueKey(Share.SHARE, "KEY_share_PRIMARY", Share.SHARE.SHARE_ID);
        public static final UniqueKey<ShareRecord> KEY_SHARE_SHARE_ID = Internal.createUniqueKey(Share.SHARE, "KEY_share_share_id", Share.SHARE.SHARE_ID);
        public static final UniqueKey<SourceRecord> KEY_SOURCE_PRIMARY = Internal.createUniqueKey(Source.SOURCE, "KEY_source_PRIMARY", Source.SOURCE.SOURCE_TYPE);
        public static final UniqueKey<SourceRecord> KEY_SOURCE_SOURCE_TYPE = Internal.createUniqueKey(Source.SOURCE, "KEY_source_source_type", Source.SOURCE.SOURCE_TYPE);
        public static final UniqueKey<SourceRecord> KEY_SOURCE_SOURCE_NAME = Internal.createUniqueKey(Source.SOURCE, "KEY_source_source_name", Source.SOURCE.SOURCE_NAME);
        public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, "KEY_user_PRIMARY", User.USER.USER_ID);
        public static final UniqueKey<UserRecord> KEY_USER_EMAIL = Internal.createUniqueKey(User.USER, "KEY_user_email", User.USER.EMAIL);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<DocumentRecord, SourceRecord> DOCUMENT_SOURCE_FK = Internal.createForeignKey(cn.edu.nju.teamwiki.jooq.Keys.KEY_SOURCE_PRIMARY, Document.DOCUMENT, "document_source_fk", Document.DOCUMENT.SOURCE_TYPE);
        public static final ForeignKey<KnowledgeRecord, CategoryRecord> KNOWLEDGE_CATEGORY_FK = Internal.createForeignKey(cn.edu.nju.teamwiki.jooq.Keys.KEY_CATEGORY_PRIMARY, Knowledge.KNOWLEDGE, "knowledge_category_fk", Knowledge.KNOWLEDGE.CATEGORY);
        public static final ForeignKey<KnowledgeRecord, UserRecord> KNOWLEDGE_CREATOR_FK = Internal.createForeignKey(cn.edu.nju.teamwiki.jooq.Keys.KEY_USER_PRIMARY, Knowledge.KNOWLEDGE, "knowledge_creator_fk", Knowledge.KNOWLEDGE.CREATOR);
        public static final ForeignKey<ShareRecord, UserRecord> SHARE_USER_FK = Internal.createForeignKey(cn.edu.nju.teamwiki.jooq.Keys.KEY_USER_PRIMARY, Share.SHARE, "share_user_fk", Share.SHARE.SHARE_USER);
        public static final ForeignKey<UserRecord, RoleRecord> ROLE_FK = Internal.createForeignKey(cn.edu.nju.teamwiki.jooq.Keys.KEY_ROLE_PRIMARY, User.USER, "role_fk", User.USER.ROLE);
    }
}
