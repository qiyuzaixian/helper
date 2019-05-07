package com.github.hps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/***
 * spring boot start
 */

@SpringBootApplication
public class MainApplication{
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
