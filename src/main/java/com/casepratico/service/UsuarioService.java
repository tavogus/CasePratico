package com.casepratico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casepratico.model.Usuario;
import com.casepratico.model.UsuarioAutenticado;
import com.casepratico.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public UsuarioAutenticado autenticar(String login, String senha) {
		Usuario usuario = usuarioRepository.findByLoginAndSenha(login, senha);
		
		if (usuario == null) {
			System.out.println("usuario nao existe");
		}
		UsuarioAutenticado usuarioAutenticado = new UsuarioAutenticado();
		usuarioAutenticado.setUsuario(usuario);
		usuarioAutenticado.setAutenticado(true);
		return usuarioAutenticado;
		
	}

}
