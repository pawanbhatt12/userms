package com.edureka.userms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@RestController
public class UsermsApplication {

	@Value("${my-property}")
	private String myProperty;
	@Value("${your-property}")
	private String yourProperty;

	@GetMapping("/property")
	public void getProperty() {
		System.out.println("************************");
		System.out.println("myProperty: " + myProperty);
		System.out.println("yourProperty: " + yourProperty);
		System.out.println("************************");
	}

	public static void main(String[] args) {
		SpringApplication.run(UsermsApplication.class, args);
	}

}
