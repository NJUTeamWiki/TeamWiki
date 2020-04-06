package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.ShareVO;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Share;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhoushiqi
 * @date: 2020/4/4
 */
@SpringBootTest
public class ShareServiceTest {
    @Autowired
    private ShareService shareService;

    @Test
    public void getAllShares()throws Exception{
        List<ShareVO> shareVOS;
        shareVOS = shareService.getAllShares();
        assertEquals(shareVOS.size(), 3);
    }

    @Test
    public void getSomeOne()throws Exception{
        List<ShareVO> shareVOS;
        shareVOS = shareService.getSharesByUserId("3");
        assertEquals(shareVOS.size(),2);
    }

    @Test
    public void getShareByTitle()throws Exception{
        assertEquals(shareService.getSharesByTitle("test_share_1").get(0).getShareContent(), "this is test 1");
    }

    //更新share内容
    @Test
    public void y_updateShare() throws Exception{
        Share s2 = shareService.updateShare("4","test_share_1","this is test update 1","3");
        assertEquals(s2.getShareId(), 4);
    }

    @Test
    public void z_deleteShare() throws Exception{
        assertEquals(shareService.deleteShare("4","3").getShareId(), 4);
        assertEquals(shareService.deleteShare("5","3").getShareId(), 5);
    }


}
