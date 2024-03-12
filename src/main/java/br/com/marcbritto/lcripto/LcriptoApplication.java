package br.com.marcbritto.lcripto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.marcbritto.lcripto.repository.CustomMongoRepositoryImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "br.com.marcbritto.lcripto.repository", repositoryBaseClass = CustomMongoRepositoryImpl.class)
@OpenAPIDefinition(info = @Info(
		title = "${spring.application.name}", 
		version = "${info.application.version}", 
		description = "${info.application.description}"))
public class LcriptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LcriptoApplication.class, args);
	}

}
