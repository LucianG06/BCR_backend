package com.bcr.backend_bcr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
@EnableJpaRepositories
public class BackendBcrApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBcrApplication.class, args);
	}

}
