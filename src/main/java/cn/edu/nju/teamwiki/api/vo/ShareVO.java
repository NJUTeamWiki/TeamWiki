package cn.edu.nju.teamwiki.api.vo;

import cn.edu.nju.teamwiki.jooq.tables.pojos.Document;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Share;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/5
 */
public class ShareVO extends Share {
    public ShareVO(Share share) {
        super(share);
    }

    public ShareVO(Share share, List<Document> documents) {
        super(share);
        this.documents.addAll(documents);
    }

    private List<Document> documents = new LinkedList<>();

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
