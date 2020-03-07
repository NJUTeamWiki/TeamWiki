package cn.edu.nju.teamwiki;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamWikiApplicationTests {

	// FIXME 测试时jenkins环境下的office和docker环境下的office路径不同。
	// 		 此配置仅在172.19.241.57上有效。
	static {
		System.setProperty("jodconverter.local.officeHome", "/opt/libreoffice6.4");
	}

	@Test
	void contextLoads() {
	}


}
