package cn.edu.nju.teamwiki.api.vo;

import cn.edu.nju.teamwiki.jooq.tables.pojos.Document;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xuyangchen
 * @date: 2020/1/7
 */
public class KnowledgeVO extends Knowledge {

    public KnowledgeVO(Knowledge knowledge) {
        super(knowledge);
    }

    public KnowledgeVO(Knowledge knowledge, List<Document> documents) {
        super(knowledge);
        this.documents.addAll(
                documents.stream()
                        .filter(document -> !document.getIsArchived())
                        .collect(Collectors.toList()));
    }

    private List<Document> documents = new LinkedList<>();

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
