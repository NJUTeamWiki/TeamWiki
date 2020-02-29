/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq;


import cn.edu.nju.teamwiki.jooq.tables.*;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in team_wiki
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.3"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Tables {

    /**
     * The table <code>team_wiki.category</code>.
     */
    public static final Category CATEGORY = Category.CATEGORY;

    /**
     * The table <code>team_wiki.document</code>.
     */
    public static final Document DOCUMENT = Document.DOCUMENT;

    /**
     * A table to contain all knowledge
     */
    public static final Knowledge KNOWLEDGE = Knowledge.KNOWLEDGE;

    /**
     * The table <code>team_wiki.portal</code>.
     */
    public static final Portal PORTAL = Portal.PORTAL;

    /**
     * A table to contain all roles
     */
    public static final Role ROLE = Role.ROLE;

    /**
     * The table <code>team_wiki.share</code>.
     */
    public static final Share SHARE = Share.SHARE;

    /**
     * The table <code>team_wiki.source</code>.
     */
    public static final Source SOURCE = Source.SOURCE;

    /**
     * A table to contain all the users
     */
    public static final User USER = User.USER;
}
