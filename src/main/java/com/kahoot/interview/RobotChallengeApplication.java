package com.kahoot.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication
@ComponentScan("com.kahoot.interview")
@EnableJpaRepositories("com.kahoot.interview.repositories")
@EntityScan("com.kahoot.interview.domain")
public class RobotChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotChallengeApplication.class, args);
	}
}
