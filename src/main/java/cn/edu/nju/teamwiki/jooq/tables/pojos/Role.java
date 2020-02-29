/*
 * This file is generated by jOOQ.
 */
package cn.edu.nju.teamwiki.jooq.tables.pojos;


import javax.annotation.Generated;
import java.io.Serializable;


/**
 * A table to contain all roles
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.3"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Role implements Serializable {

    private static final long serialVersionUID = -1810914889;

    private Integer roleId;
    private String roleName;

    public Role() {
    }

    public Role(Role value) {
        this.roleId = value.roleId;
        this.roleName = value.roleName;
    }

    public Role(
            Integer roleId,
            String roleName
    ) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Role (");

        sb.append(roleId);
        sb.append(", ").append(roleName);

        sb.append(")");
        return sb.toString();
    }
}
