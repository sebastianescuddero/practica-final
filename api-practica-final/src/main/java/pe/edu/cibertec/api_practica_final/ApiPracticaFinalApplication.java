package pe.edu.cibertec.api_practica_final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiPracticaFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPracticaFinalApplication.class, args);
	}
}
