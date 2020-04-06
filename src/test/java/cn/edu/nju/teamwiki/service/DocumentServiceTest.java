package cn.edu.nju.teamwiki.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhoushiqi
 * @date: 2020/4/5
 */
@SpringBootTest
public class DocumentServiceTest {
    @Autowired
    private DocumentService documentService;

    @Test
    public void getAllDocuments()throws Exception{
        assertEquals(documentService.getDocuments("1",2).size(), 1);
    }

    @Test
    public void renameDocument()throws Exception{
        assertEquals(documentService.renameDocument("8070470a86b547f881e6ee75a66970cd", "myshareupdate.txt", "2").getDName(), "myshareupdate.txt");
    }

    @Test
    public void deleteFile()throws Exception{
        assertEquals(documentService.deleteDocument("8070470a86b547f881e6ee75a66970cd", "2").getDName(), "myshareupdate.txt");
    }


}
