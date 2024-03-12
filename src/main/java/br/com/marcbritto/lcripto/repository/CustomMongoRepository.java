package br.com.marcbritto.lcripto.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.marcbritto.lcripto.model.BaseModel;


@NoRepositoryBean
public interface CustomMongoRepository<T extends BaseModel> extends MongoRepository<T, UUID> {

}
