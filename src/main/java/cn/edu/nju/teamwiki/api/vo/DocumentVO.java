package cn.edu.nju.teamwiki.api.vo;

import cn.edu.nju.teamwiki.jooq.tables.pojos.Document;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
public class DocumentVO extends Document {

    private String uploaderName;

    public DocumentVO(Document document) {
        super(document);
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }
}
