package br.com.marcbritto.lcripto.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcbritto.lcripto.constant.SwaggerConstants;
import br.com.marcbritto.lcripto.model.Cripto;
import br.com.marcbritto.lcripto.service.ICriptoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/cripto")
public class CriptoController {
	
	@Autowired
	private ICriptoService service;
	
	@Operation(summary = SwaggerConstants.INSERT)
	@ApiResponses(value = {
			@ApiResponse(responseCode  = SwaggerConstants.CREATED, 
	      			 	 description = SwaggerConstants.CREATED_DESCRIPTION,
	      			 	 content = @Content(schema = @Schema(implementation = Cripto.class))),
	        @ApiResponse(responseCode  = SwaggerConstants.BAD_REQUEST, 
			 			 description = SwaggerConstants.BAD_REQUEST_DESCRIPTION),
	        @ApiResponse(responseCode  = SwaggerConstants.INTERNAL_ERROR, 
			 			 description = SwaggerConstants.INTERNAL_ERROR_DESCRIPTION)
	    })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> createCripto (@RequestBody @Validated(Cripto.class) Cripto cripto) {
		
		try {
			return new ResponseEntity<>(service.create(cripto), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = SwaggerConstants.UPDATE)
    @ApiResponses(value = {
    	@ApiResponse(responseCode = SwaggerConstants.OK, 
           			 description = SwaggerConstants.OK_DESCRIPTION,
           			 content = @Content(schema = @Schema(implementation = Cripto.class))),
        @ApiResponse(responseCode  = SwaggerConstants.BAD_REQUEST, 
           			 description = SwaggerConstants.BAD_REQUEST_DESCRIPTION),
        @ApiResponse(responseCode  = SwaggerConstants.INTERNAL_ERROR, 
          			 description = SwaggerConstants.INTERNAL_ERROR_DESCRIPTION)
    })
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody @Validated(Cripto.class) Cripto cripto){
        
		try {
			return new ResponseEntity<>(service.update(cripto), HttpStatus.CREATED);
		} catch (Exception e) {
			if (e.getMessage().contains(service.CRIPTO_MOEDA_NAO_ENCONTRADA)) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@Operation(summary = SwaggerConstants.DELETE)
    @ApiResponses(value = {
		@ApiResponse(responseCode  = SwaggerConstants.NO_CONTENT, 
	 			 	 description = SwaggerConstants.NO_CONTENT_DESCRIPTION),
		@ApiResponse(responseCode  = SwaggerConstants.INTERNAL_ERROR, 
		 			 description = SwaggerConstants.INTERNAL_ERROR_DESCRIPTION)
    })
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> delete(@PathVariable UUID id){
		
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			if (e.getMessage().contains(service.CRIPTO_MOEDA_NAO_ENCONTRADA)) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = SwaggerConstants.FIND_ALL)
    @ApiResponses(value = {
		@ApiResponse(responseCode  = SwaggerConstants.OK, 
	 			 	 description = SwaggerConstants.OK_DESCRIPTION,
	 			 	 content = @Content(schema = @Schema(implementation = Cripto.class))),
		@ApiResponse(responseCode  = SwaggerConstants.NO_CONTENT, 
					description = SwaggerConstants.NO_CONTENT_DESCRIPTION),
		@ApiResponse(responseCode  = SwaggerConstants.INTERNAL_ERROR, 
		 			 description = SwaggerConstants.INTERNAL_ERROR_DESCRIPTION)
    })
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findAll(){
		List<Cripto> criptoList = service.findAll();
		if (criptoList.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(criptoList);
    }
	
	@Operation(summary = SwaggerConstants.FIND_ONE)
    @ApiResponses(value = {
		@ApiResponse(responseCode  = SwaggerConstants.OK, 
	 			 	 description = SwaggerConstants.OK_DESCRIPTION,
	 			 	 content = @Content(schema = @Schema(implementation = Cripto.class))),
		@ApiResponse(responseCode  = SwaggerConstants.NOT_FOUND, 
					description = SwaggerConstants.NOT_FOUND_DESCRIPTION),
		@ApiResponse(responseCode  = SwaggerConstants.INTERNAL_ERROR, 
		 			 description = SwaggerConstants.INTERNAL_ERROR_DESCRIPTION)
    })
    @GetMapping("/{nameOrCode}")
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findByNameOrCode(@PathVariable String nameOrCode){
		try {
			Cripto cripto = service.findByName(nameOrCode);
			return new ResponseEntity<>(cripto, HttpStatus.OK);
		} catch (Exception e) {
			if (e.getMessage().contains(service.CRIPTO_MOEDA_NAO_ENCONTRADA)) {
				try {
					Cripto cripto = service.findByCode(nameOrCode);
					return new ResponseEntity<>(cripto, HttpStatus.OK);
				} catch (Exception ex) {
					if (ex.getMessage().contains(service.CRIPTO_MOEDA_NAO_ENCONTRADA)) {
						return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
					}
					return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
