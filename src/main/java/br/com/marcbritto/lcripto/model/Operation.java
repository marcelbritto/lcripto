package br.com.marcbritto.lcripto.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "operation")
public class Operation extends BaseModel {

	private String type;
	
	private Cripto cripto;
	
	private Double quantity;
	
	private Double value;
}
