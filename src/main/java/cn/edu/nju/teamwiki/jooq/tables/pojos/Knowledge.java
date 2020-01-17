/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class Knowledge implements Serializable {

    private static final long serialVersionUID = -1998133862;

    private Integer kId;
    private String  kName;
    private Boolean predefined;
    private Integer category;
    private Integer creator;

    public Knowledge() {}

    public Knowledge(Knowledge value) {
        this.kId = value.kId;
        this.kName = value.kName;
        this.predefined = value.predefined;
        this.category = value.category;
        this.creator = value.creator;
    }

    public Knowledge(
        Integer kId,
        String  kName,
        Boolean predefined,
        Integer category,
        Integer creator
    ) {
        this.kId = kId;
        this.kName = kName;
        this.predefined = predefined;
        this.category = category;
        this.creator = creator;
    }

    public Integer getKId() {
        return this.kId;
    }

    public void setKId(Integer kId) {
        this.kId = kId;
    }

    public String getKName() {
        return this.kName;
    }

    public void setKName(String kName) {
        this.kName = kName;
    }

    public Boolean getPredefined() {
        return this.predefined;
    }

    public void setPredefined(Boolean predefined) {
        this.predefined = predefined;
    }

    public Integer getCategory() {
        return this.category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getCreator() {
        return this.creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Knowledge (");

        sb.append(kId);
        sb.append(", ").append(kName);
        sb.append(", ").append(predefined);
        sb.append(", ").append(category);
        sb.append(", ").append(creator);

        sb.append(")");
        return sb.toString();
    }
}