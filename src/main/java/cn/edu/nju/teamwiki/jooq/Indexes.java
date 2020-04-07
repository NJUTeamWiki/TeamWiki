/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq;


import cn.edu.nju.teamwiki.jooq.tables.Category;
import cn.edu.nju.teamwiki.jooq.tables.Document;
import cn.edu.nju.teamwiki.jooq.tables.DocumentActivities;
import cn.edu.nju.teamwiki.jooq.tables.Knowledge;
import cn.edu.nju.teamwiki.jooq.tables.Portal;
import cn.edu.nju.teamwiki.jooq.tables.Role;
import cn.edu.nju.teamwiki.jooq.tables.Share;
import cn.edu.nju.teamwiki.jooq.tables.Source;
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

    public static final Index CATEGORY_CATEGORY_ID = Indexes0.CATEGORY_CATEGORY_ID;
    public static final Index CATEGORY_PRIMARY = Indexes0.CATEGORY_PRIMARY;
    public static final Index DOCUMENT_DOCUMENT_SOURCE_FK = Indexes0.DOCUMENT_DOCUMENT_SOURCE_FK;
    public static final Index DOCUMENT_D_ID = Indexes0.DOCUMENT_D_ID;
    public static final Index DOCUMENT_PRIMARY = Indexes0.DOCUMENT_PRIMARY;
    public static final Index DOCUMENT_ACTIVITIES_PRIMARY = Indexes0.DOCUMENT_ACTIVITIES_PRIMARY;
    public static final Index KNOWLEDGE_KNOWLEDGE_CATEGORY_FK = Indexes0.KNOWLEDGE_KNOWLEDGE_CATEGORY_FK;
    public static final Index KNOWLEDGE_KNOWLEDGE_CREATOR_FK = Indexes0.KNOWLEDGE_KNOWLEDGE_CREATOR_FK;
    public static final Index KNOWLEDGE_K_ID = Indexes0.KNOWLEDGE_K_ID;
    public static final Index KNOWLEDGE_PRIMARY = Indexes0.KNOWLEDGE_PRIMARY;
    public static final Index PORTAL_PORTAL_ID = Indexes0.PORTAL_PORTAL_ID;
    public static final Index PORTAL_PRIMARY = Indexes0.PORTAL_PRIMARY;
    public static final Index ROLE_PRIMARY = Indexes0.ROLE_PRIMARY;
    public static final Index ROLE_ROLE_ID = Indexes0.ROLE_ROLE_ID;
    public static final Index ROLE_ROLE_NAME = Indexes0.ROLE_ROLE_NAME;
    public static final Index SHARE_PRIMARY = Indexes0.SHARE_PRIMARY;
    public static final Index SHARE_SHARE_ID = Indexes0.SHARE_SHARE_ID;
    public static final Index SHARE_SHARE_USER_FK = Indexes0.SHARE_SHARE_USER_FK;
    public static final Index SOURCE_PRIMARY = Indexes0.SOURCE_PRIMARY;
    public static final Index SOURCE_SOURCE_NAME = Indexes0.SOURCE_SOURCE_NAME;
    public static final Index SOURCE_SOURCE_TYPE = Indexes0.SOURCE_SOURCE_TYPE;
    public static final Index USER_EMAIL = Indexes0.USER_EMAIL;
    public static final Index USER_PRIMARY = Indexes0.USER_PRIMARY;
    public static final Index USER_ROLE_FK = Indexes0.USER_ROLE_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index CATEGORY_CATEGORY_ID = Internal.createIndex("category_id", Category.CATEGORY, new OrderField[] { Category.CATEGORY.CATEGORY_ID }, true);
        public static Index CATEGORY_PRIMARY = Internal.createIndex("PRIMARY", Category.CATEGORY, new OrderField[] { Category.CATEGORY.CATEGORY_ID }, true);
        public static Index DOCUMENT_DOCUMENT_SOURCE_FK = Internal.createIndex("document_source_fk", Document.DOCUMENT, new OrderField[] { Document.DOCUMENT.SOURCE_TYPE }, false);
        public static Index DOCUMENT_D_ID = Internal.createIndex("d_id", Document.DOCUMENT, new OrderField[] { Document.DOCUMENT.D_ID }, true);
        public static Index DOCUMENT_PRIMARY = Internal.createIndex("PRIMARY", Document.DOCUMENT, new OrderField[] { Document.DOCUMENT.D_ID }, true);
        public static Index DOCUMENT_ACTIVITIES_PRIMARY = Internal.createIndex("PRIMARY", DocumentActivities.DOCUMENT_ACTIVITIES, new OrderField[] { DocumentActivities.DOCUMENT_ACTIVITIES.DOCUMENT_ID, DocumentActivities.DOCUMENT_ACTIVITIES.USER_ID, DocumentActivities.DOCUMENT_ACTIVITIES.ACTION, DocumentActivities.DOCUMENT_ACTIVITIES.TIME }, true);
        public static Index KNOWLEDGE_KNOWLEDGE_CATEGORY_FK = Internal.createIndex("knowledge_category_fk", Knowledge.KNOWLEDGE, new OrderField[] { Knowledge.KNOWLEDGE.CATEGORY }, false);
        public static Index KNOWLEDGE_KNOWLEDGE_CREATOR_FK = Internal.createIndex("knowledge_creator_fk", Knowledge.KNOWLEDGE, new OrderField[] { Knowledge.KNOWLEDGE.CREATOR }, false);
        public static Index KNOWLEDGE_K_ID = Internal.createIndex("k_id", Knowledge.KNOWLEDGE, new OrderField[] { Knowledge.KNOWLEDGE.K_ID }, true);
        public static Index KNOWLEDGE_PRIMARY = Internal.createIndex("PRIMARY", Knowledge.KNOWLEDGE, new OrderField[] { Knowledge.KNOWLEDGE.K_ID }, true);
        public static Index PORTAL_PORTAL_ID = Internal.createIndex("portal_id", Portal.PORTAL, new OrderField[] { Portal.PORTAL.PORTAL_ID }, true);
        public static Index PORTAL_PRIMARY = Internal.createIndex("PRIMARY", Portal.PORTAL, new OrderField[] { Portal.PORTAL.PORTAL_ID }, true);
        public static Index ROLE_PRIMARY = Internal.createIndex("PRIMARY", Role.ROLE, new OrderField[] { Role.ROLE.ROLE_ID }, true);
        public static Index ROLE_ROLE_ID = Internal.createIndex("role_id", Role.ROLE, new OrderField[] { Role.ROLE.ROLE_ID }, true);
        public static Index ROLE_ROLE_NAME = Internal.createIndex("role_name", Role.ROLE, new OrderField[] { Role.ROLE.ROLE_NAME }, true);
        public static Index SHARE_PRIMARY = Internal.createIndex("PRIMARY", Share.SHARE, new OrderField[] { Share.SHARE.SHARE_ID }, true);
        public static Index SHARE_SHARE_ID = Internal.createIndex("share_id", Share.SHARE, new OrderField[] { Share.SHARE.SHARE_ID }, true);
        public static Index SHARE_SHARE_USER_FK = Internal.createIndex("share_user_fk", Share.SHARE, new OrderField[] { Share.SHARE.SHARE_USER }, false);
        public static Index SOURCE_PRIMARY = Internal.createIndex("PRIMARY", Source.SOURCE, new OrderField[] { Source.SOURCE.SOURCE_TYPE }, true);
        public static Index SOURCE_SOURCE_NAME = Internal.createIndex("source_name", Source.SOURCE, new OrderField[] { Source.SOURCE.SOURCE_NAME }, true);
        public static Index SOURCE_SOURCE_TYPE = Internal.createIndex("source_type", Source.SOURCE, new OrderField[] { Source.SOURCE.SOURCE_TYPE }, true);
        public static Index USER_EMAIL = Internal.createIndex("email", User.USER, new OrderField[] { User.USER.EMAIL }, true);
        public static Index USER_PRIMARY = Internal.createIndex("PRIMARY", User.USER, new OrderField[] { User.USER.USER_ID }, true);
        public static Index USER_ROLE_FK = Internal.createIndex("role_fk", User.USER, new OrderField[] { User.USER.ROLE }, false);
    }
}
