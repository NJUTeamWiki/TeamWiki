/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class Category implements Serializable {

    private static final long serialVersionUID = 396726896;

    private Integer categoryId;
    private String  categoryName;
    private Boolean predefined;

    public Category() {}

    public Category(Category value) {
        this.categoryId = value.categoryId;
        this.categoryName = value.categoryName;
        this.predefined = value.predefined;
    }

    public Category(
        Integer categoryId,
        String  categoryName,
        Boolean predefined
    ) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.predefined = predefined;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getPredefined() {
        return this.predefined;
    }

    public void setPredefined(Boolean predefined) {
        this.predefined = predefined;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Category (");

        sb.append(categoryId);
        sb.append(", ").append(categoryName);
        sb.append(", ").append(predefined);

        sb.append(")");
        return sb.toString();
    }
}
