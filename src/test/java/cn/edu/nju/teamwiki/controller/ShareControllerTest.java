package cn.edu.nju.teamwiki.controller;

import cn.edu.nju.teamwiki.api.vo.ShareVO;
import cn.edu.nju.teamwiki.interceptor.SignInInterceptor;
import cn.edu.nju.teamwiki.jooq.tables.daos.DocumentDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.ShareDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Share;
import cn.edu.nju.teamwiki.service.ShareService;
import cn.edu.nju.teamwiki.util.SessionUtils;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileInputStream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: xuyangchen
 * @date: 2020/4/6
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ShareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShareService shareService;

    @MockBean
    private SignInInterceptor signInInterceptor;

    @Test
    public void testCreateShare() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        SessionUtils.setUser(mockHttpSession, "1");
        File testFile1 = new File("src/test/resources/test1.txt");
        File testFile2 = new File("src/test/resources/test1.txt");
        MockMultipartFile mockMultipartFile1 = new MockMultipartFile(testFile1.getName(), new FileInputStream(testFile1));
        MockMultipartFile mockMultipartFile2 = new MockMultipartFile(testFile2.getName(), new FileInputStream(testFile2));
        String testTitle = "TestShare";
        String testContent = "This is a test share.";
        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/share")
                .file(mockMultipartFile1)
                .file(mockMultipartFile2)
                .param("title", testTitle)
                .param("content", testContent)
                .session(mockHttpSession))
                .andExpect(status().isOk());
    }


}
