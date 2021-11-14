package com.daelim.paguda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PagudaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagudaApplication.class, args);
	}

}
