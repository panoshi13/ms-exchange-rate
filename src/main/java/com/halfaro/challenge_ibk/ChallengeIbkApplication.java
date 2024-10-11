package com.halfaro.challenge_ibk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.halfaro.challenge_ibk.application.client") // Asegúrate de usar el paquete correcto
public class ChallengeIbkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeIbkApplication.class, args);
	}

}
