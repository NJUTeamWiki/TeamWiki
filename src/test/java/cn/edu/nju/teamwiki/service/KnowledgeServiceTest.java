package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.KnowledgeVO;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: xuyangchen
 * @date: 2020/1/17
 */
@SpringBootTest
public class KnowledgeServiceTest extends BaseServiceTest {

    @Autowired
    private KnowledgeService knowledgeService;

    @Test
    void test() throws Exception {
        super.before();

        List<KnowledgeVO> res;

        // 验证默认知识
        res = knowledgeService.getAllKnowledge();
        assertEquals(res.size(), 13);

        // 创建测试知识
        Knowledge k1 = knowledgeService.createKnowledge("1", "Test Knowledge", "1");

        // 再次创建同名知识
        assertThrows(ServiceException.class,
                () -> knowledgeService.createKnowledge("1", "Test Knowledge", "1"));

        // 获取测试知识
        assertEquals(knowledgeService.getKnowledge(k1.getKId().toString()).getKName(), "Test Knowledge");

        // 重命名知识
        Knowledge k2 = knowledgeService.renameKnowledge(k1.getKId().toString(), "Rename Knowledge", "1");
        assertEquals(k2.getKId(), k1.getKId());
        assertEquals(knowledgeService.getKnowledge(k1.getKId().toString()).getKName(), "Rename Knowledge");

        // 重命名预定义知识
        assertThrows(ServiceException.class,
                () -> knowledgeService.renameKnowledge("1", "New name", "1"));


        // 删除知识
        Knowledge k3 = knowledgeService.removeKnowledge(k1.getKId().toString(), "1");
        assertFalse(knowledgeService.getAllKnowledge().contains(k3));

        // 删除预定义知识
        assertThrows(ServiceException.class,
                () -> knowledgeService.removeKnowledge("1", "1"));

        super.after();
    }

}
