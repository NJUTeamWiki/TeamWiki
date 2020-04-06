package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.PortalVO;
import cn.edu.nju.teamwiki.jooq.tables.Portal;
import liquibase.license.LicenseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhoushiqi
 * @date: 2020/4/5
 */
@SpringBootTest
public class PortalServiceTest {
    @Autowired
    private PortalService portalService;

    @Test
    public void a_getAllPortals() throws Exception{
        List<PortalVO> list;
        list = portalService.getAllPortal();
        assertEquals(list.size(), 7);
    }

    @Test
    public void b_getOnePortal() throws Exception{
        PortalVO portalVO = portalService.getPortalById("5");
        assertEquals(portalVO.getPortalName(), "Teambition");
    }

    @Test
    public void c_addPortal()throws Exception{
        PortalVO portalVO = portalService.createPortal("myTestPortal", "just a link");
        assertEquals(portalVO.getPortalName(), "myTestPortal");
        assertEquals(portalVO.getPortalLink(), "just a link");
    }

    @Test
    public void d_updatePortal()throws Exception{
        PortalVO portalVO = portalService.updatePortal("10", "myTestPortal", "just a update link");
        assertEquals(portalVO.getPortalLink(), "just a update link");
    }

    @Test
    public void e_deletePortal()throws Exception{
        PortalVO portalVO = portalService.deletePortal("10");
        assertEquals(portalVO.getPortalLink(), "just a update link");
    }


}
