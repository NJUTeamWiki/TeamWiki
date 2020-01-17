package cn.edu.nju.teamwiki.api.vo;

import cn.edu.nju.teamwiki.jooq.tables.pojos.Document;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
public class DocumentVO extends Document {

    private String url;

    public DocumentVO(Document document) {
        super(document);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
