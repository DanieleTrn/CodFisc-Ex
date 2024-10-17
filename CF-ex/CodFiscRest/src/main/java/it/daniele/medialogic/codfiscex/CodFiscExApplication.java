package it.daniele.medialogic.codfiscex;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "CodFiscEx",
				version = "1.0",
				description = "Calcolo eta e data nascità da Codice Fiscale"
		)
)
public class CodFiscExApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodFiscExApplication.class, args);
	}

}
