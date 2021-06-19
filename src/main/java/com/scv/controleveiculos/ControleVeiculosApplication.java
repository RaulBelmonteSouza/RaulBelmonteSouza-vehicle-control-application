package com.scv.controleveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ControleVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleVeiculosApplication.class, args);
	}

}
