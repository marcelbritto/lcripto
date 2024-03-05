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
	public Cripto findByName(String name) {
		
		return repository.findByName(name)
				.orElseThrow(() -> new Exception("Cripto moeda não encontrada: " + name));
	}

	@Override
	public Cripto findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cripto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cripto save(Cripto cripto) {
		// TODO Auto-generated method stub
		return null;
	}

}
