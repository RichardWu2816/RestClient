package com.ln.rest.client.lnrestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan({
		"com.ln"
})

@IntegrationComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
public class LnRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LnRestClientApplication.class, args);
	}
}
