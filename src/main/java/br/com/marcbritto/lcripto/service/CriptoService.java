/**
 * MarcBritto 
 * --------------------------------------------------------------
 *	Projeto: lcripto
 * 	Data de Criação: 05-03-2024
 *			Arquivo: CriptoService.java
 *  		  Autor: Marcel Britto
 * --------------------------------------------------------------
 */
package br.com.marcbritto.lcripto.service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcbritto.lcripto.model.Cripto;
import br.com.marcbritto.lcripto.repository.CriptoRepository;

/**
 * 
 */
@Service
public class CriptoService implements ICriptoService {
	
	@Autowired
	private CriptoRepository repository;
	
	@Override
	public Cripto findByName(String name) throws Exception {
		
		return repository.findByName(name)
				.orElseThrow(() -> new Exception(CRIPTO_MOEDA_NAO_ENCONTRADA + ": " + name));
	}

	@Override
	public Cripto findByCode(String code) throws Exception {
		
		return repository.findByCode(code)
				.orElseThrow(() -> new Exception(CRIPTO_MOEDA_NAO_ENCONTRADA + ": " + code));
	}

	@Override
	public List<Cripto> findAll() {
		List<Cripto> criptoList = repository.findAll();
		if (criptoList == null) return Collections.emptyList();
		return criptoList;
	}

	@Override
	public void deleteById(UUID id) throws Exception {
		Cripto criptoToDelete = repository.findById(id)
				.orElseThrow(() -> new Exception(CRIPTO_MOEDA_NAO_ENCONTRADA));
		
		repository.delete(criptoToDelete);
	}

	@Override
	public Cripto create (Cripto cripto) {
		
		return repository.save(cripto);
	}
	
	@Override
	public Cripto update (Cripto cripto) throws Exception {
		
		Cripto criptoToDelete = repository.findById(cripto.getId())
				.orElseThrow(() -> new Exception("Cripto moeda não encontrada"));
		return repository.save(cripto);
	}

}
