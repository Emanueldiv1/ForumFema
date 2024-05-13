package br.edu.fema.forum2024.ForumFema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class ForumFemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumFemaApplication.class, args);
		
		
	}

}
