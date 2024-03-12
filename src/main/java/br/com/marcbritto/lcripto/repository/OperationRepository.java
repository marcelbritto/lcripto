package br.com.marcbritto.lcripto.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.marcbritto.lcripto.model.Cripto;
import br.com.marcbritto.lcripto.model.Operation;

@Repository
public interface OperationRepository extends CustomMongoRepository<Operation> {

	List<Operation> findByCripto_Name (String name);
}
