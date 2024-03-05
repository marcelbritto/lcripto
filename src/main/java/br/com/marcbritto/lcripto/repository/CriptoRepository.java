package br.com.marcbritto.lcripto.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.marcbritto.lcripto.model.Cripto;

@Repository
public interface CriptoRepository extends MongoRepository<Cripto, UUID>{

	Optional<Cripto> findByName (String name);
	
	Optional<Cripto> findByCode (String code);
}
