package cn.edu.nju.teamwiki.api.vo;

import cn.edu.nju.teamwiki.jooq.tables.pojos.Category;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/2/17
 */
public class CategoryVO extends Category {

    public CategoryVO(Category category, List<KnowledgeVO> knowledges) {
        super(category);
        this.knowledges = knowledges;
    }

    private List<KnowledgeVO> knowledges = new LinkedList<>();

    public List<KnowledgeVO> getKnowledges() {
        return knowledges;
    }

    public void setKnowledges(List<KnowledgeVO> knowledges) {
        this.knowledges = knowledges;
    }
}
