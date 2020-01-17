package cn.edu.nju.teamwiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableRedisHttpSession
public class TeamWikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamWikiApplication.class, args);
	}

}
