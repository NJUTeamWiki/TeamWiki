package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.jooq.tables.daos.CategoryDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.UserDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author: xuyangchen
 * @date: 2020/1/17
 */
@SpringBootTest
public class KnowledgeServiceTest {

    @MockBean
    private UserDao userDao;

    @Autowired
    private KnowledgeService knowledgeService;

    @Test
    void testRecommend() {
        User testUser1 = new User();
        testUser1.setUserId(1);
        testUser1.setCreateTime(LocalDateTime.now());
        User testUser2 = new User();
        testUser2.setUserId(2);
        testUser2.setCreateTime(LocalDateTime.now().minusDays(5));
        User testUser3 = new User();
        testUser3.setUserId(3);
        testUser3.setCreateTime(LocalDateTime.now().minusDays(15));
        Mockito.when(userDao.fetchOneByUserId(testUser1.getUserId())).thenReturn(testUser1);
        Mockito.when(userDao.fetchOneByUserId(testUser2.getUserId())).thenReturn(testUser2);
        Mockito.when(userDao.fetchOneByUserId(testUser3.getUserId())).thenReturn(testUser3);

        Assertions.assertTrue(knowledgeService.recommendKnowledge(String.valueOf(testUser1.getUserId()))
                .stream()
                .anyMatch(knowledgeVO -> knowledgeVO.getCategory() == 1));

        Assertions.assertTrue(knowledgeService.recommendKnowledge(String.valueOf(testUser2.getUserId()))
                .stream()
                .anyMatch(knowledgeVO -> knowledgeVO.getCategory() == 2));

        Assertions.assertTrue(knowledgeService.recommendKnowledge(String.valueOf(testUser3.getUserId()))
                .stream()
                .anyMatch(knowledgeVO -> knowledgeVO.getCategory() == 3 || knowledgeVO.getCategory() == 4));
    }

    @Test
    void test() throws Exception {
//        List<KnowledgeVO> res;
//
//        // 验证默认知识
//        res = knowledgeService.getAllKnowledge();
//        assertEquals(res.size(), 13);

//        // 创建测试知识
//        Knowledge k1 = knowledgeService.createKnowledge("1", "Test Knowledge", "1");
//
//        // 再次创建同名知识
//        assertThrows(ServiceException.class,
//                () -> knowledgeService.createKnowledge("1", "Test Knowledge", "1"));
//
//        // 获取测试知识
//        assertEquals(knowledgeService.getKnowledge(k1.getKId().toString()).getKName(), "Test Knowledge");
//
//        // 重命名知识
//        Knowledge k2 = knowledgeService.renameKnowledge(k1.getKId().toString(), "Rename Knowledge", "1");
//        assertEquals(k2.getKId(), k1.getKId());
//        assertEquals(knowledgeService.getKnowledge(k1.getKId().toString()).getKName(), "Rename Knowledge");
//
//        // 重命名预定义知识
//        assertThrows(ServiceException.class,
//                () -> knowledgeService.renameKnowledge("1", "New name", "1"));
//
//
//        // 删除知识
//        Knowledge k3 = knowledgeService.removeKnowledge(k1.getKId().toString(), "1");
//        assertFalse(knowledgeService.getAllKnowledge().contains(k3));
//
//        // 删除预定义知识
//        assertThrows(ServiceException.class,
//                () -> knowledgeService.removeKnowledge("1", "1"));
    }


}
