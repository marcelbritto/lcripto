package br.com.marcbritto.lcripto.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "cripto")
public class Cripto extends BaseModel {

	@NotBlank(message = "Campo 'name' não pode ser vazio.")
	private String name;
	
	@NotBlank(message = "Campo 'code' não pode ser vazio.")
	private String code;
}
