package br.com.marcbritto.lcripto.service;

import java.util.List;
import java.util.UUID;

import br.com.marcbritto.lcripto.model.Cripto;

public interface ICriptoService {
	Cripto findByName (String name);
	
	Cripto findByCode (String code);
	
	List<Cripto> findAll();
	
	void deleteById (UUID id);
	
	Cripto save (Cripto cripto);
	
}
