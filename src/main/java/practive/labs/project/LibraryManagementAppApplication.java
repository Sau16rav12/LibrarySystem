package practive.labs.project;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition
public class LibraryManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementAppApplication.class, args);
	}

}
