package com.casepratico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casepratico.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByLoginAndSenha(String login, String senha);

}
