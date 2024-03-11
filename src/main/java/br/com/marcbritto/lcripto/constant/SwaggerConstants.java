
package br.com.marcbritto.lcripto.constant;

import lombok.NoArgsConstructor;

/**
 * Arquivo com as constantes da documentação da API
 * @author marcel.britto
 *
 */
@NoArgsConstructor
public class SwaggerConstants {
	
    public static final String OK = "200";
    public static final String OK_DESCRIPTION = "Operação realizada com sucesso.";
    
    public static final String BAD_REQUEST = "400";
    public static final String BAD_REQUEST_DESCRIPTION = "Os dados recebidos não são válidos.";
    
    public static final String INTERNAL_ERROR = "500";
    public static final String INTERNAL_ERROR_DESCRIPTION = "Erro inesperado na Aplicação.";
    
    public static final String NO_CONTENT = "204";
    public static final String NO_CONTENT_DESCRIPTION = "Item não encontrado.";
    
    public static final String CREATED = "201";
    public static final String CREATED_DESCRIPTION = "Item criado.";
    
    public static final String FIND_ALL = "Buscar todos os itens.";
    public static final String FIND_ALL_DESCRIPTION = "Buscar todos os itens. A busca poderá ser páginada ou não.";
    public static final String FIND_ONE = "Buscar um item";
    
    public static final String UPDATE = "Atualizar um item.";
    public static final String INSERT = "Inserir um item.";
    public static final String DELETE = "Excluir um item.";
    
    
}
