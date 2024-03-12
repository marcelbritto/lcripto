package br.com.marcbritto.lcripto.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


public abstract class BaseModel {

	@Id   
    protected UUID id;    

	public UUID getId() {
        return id;
    }
	
    public void setId(UUID id) {

        if (this.id != null) {
            throw new UnsupportedOperationException("ID is already defined");
        }

        this.id = id;
    }
}
