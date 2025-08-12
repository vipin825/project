package com.careflow.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ClinicManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicManagementServiceApplication.class, args);
	}

}
