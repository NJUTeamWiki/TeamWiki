package cn.edu.nju.teamwiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TeamWikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamWikiApplication.class, args);
	}

}
