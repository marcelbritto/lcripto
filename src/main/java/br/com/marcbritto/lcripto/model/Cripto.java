package br.com.marcbritto.lcripto.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "cripto")
public class Cripto extends BaseModel {

	private String name;
	
	private String code;
}
