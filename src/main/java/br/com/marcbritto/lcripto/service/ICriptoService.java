package br.com.marcbritto.lcripto.service;

import java.util.List;
import java.util.UUID;

import br.com.marcbritto.lcripto.model.Cripto;

public interface ICriptoService {
	Cripto findByName (String name) throws Exception;
	
	Cripto findByCode (String code) throws Exception;
	
	List<Cripto> findAll();
	
	void deleteById (UUID id) throws Exception;
	
	Cripto create (Cripto cripto) throws Exception;
	
	Cripto update (Cripto cripto) throws Exception;
	
}
