package com.kaish.uber.userReview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserReviewApplication.class, args);
	}

}
