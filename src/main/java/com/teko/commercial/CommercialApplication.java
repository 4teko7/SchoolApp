package com.teko.commercial;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;



@SpringBootApplication
public class CommercialApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommercialApplication.class, args);
		createDirs();
	}

	public static void createDirs() {
		String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads/lectures";
		(new File(uploadDir)).mkdirs();
		uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads/videos";
		(new File(uploadDir)).mkdirs();
	}
}
