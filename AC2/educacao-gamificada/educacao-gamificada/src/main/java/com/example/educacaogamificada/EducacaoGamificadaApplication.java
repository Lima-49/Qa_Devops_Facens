package com.example.educacaogamificada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@SpringBootApplication
@EnableSwagger2
public class EducacaoGamificadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducacaoGamificadaApplication.class, args);
		System.out.println("espera");
	}
}

