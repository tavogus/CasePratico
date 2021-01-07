package com.casepratico.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*login, nome, token, administrador (boolean), autenticado (boolean)*/
@Data
public class UsuarioAutenticado {
	
	private Usuario usuario;
	private boolean autenticado; 

}
