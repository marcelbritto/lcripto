package br.com.marcbritto.lcripto.service;

import java.util.List;
import java.util.UUID;

import br.com.marcbritto.lcripto.model.Cripto;
import br.com.marcbritto.lcripto.model.Operation;

public interface IOperationService {
	
	List<Operation> findByCripto_Name (String name);
	
	List<Operation> findAll();
	
	void deleteById (UUID id);
	
	Operation save (Operation operation);
	
}
