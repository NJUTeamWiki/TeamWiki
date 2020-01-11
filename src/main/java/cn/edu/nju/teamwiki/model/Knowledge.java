package cn.edu.nju.teamwiki.model;

/**
 * @author: xuyangchen
 * @date: 2020/1/7
 */
public class Knowledge {

    private String id;

    private String name;

    private String storagePath;

    private User uploader;

    private Long uploadTimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public Long getUploadTimestamp() {
        return uploadTimestamp;
    }

    public void setUploadTimestamp(Long uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }
}
