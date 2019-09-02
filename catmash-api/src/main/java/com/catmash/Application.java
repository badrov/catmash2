package com.catmash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories("com.catmash.*")
//@ComponentScan(basePackages = { "my.package.base.*" })
//@EntityScan("my.package.base.*")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
