package cn.edu.nju.teamwiki.api.vo;

/**
 * @author: xuyangchen
 * @date: 2020/4/7
 */
public class DocumentActivityVO {

    private String uid;

    private String user;

    private String avatar;

    private String action;

    private String did;

    private String dname;

    private String timestamp;

    public DocumentActivityVO(String uid, String user, String avatar, String action, String did, String dname, String timestamp) {
        this.uid = uid;
        this.user = user;
        this.avatar = avatar;
        this.action = action;
        this.did = did;
        this.dname = dname;
        this.timestamp = timestamp;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
