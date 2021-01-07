package com.casepratico.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casepratico.model.Usuario;
import com.casepratico.model.UsuarioAutenticado;
import com.casepratico.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/autenticar")
	public ResponseEntity<UsuarioAutenticado> autenticar(@RequestParam String login, @RequestParam String senha) {
		
	 UsuarioAutenticado usuario = usuarioService.autenticar(login, senha);
	 return ResponseEntity.status(HttpStatus.OK).body(usuario);
		
		
	}

}
