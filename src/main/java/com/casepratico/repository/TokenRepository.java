package com.casepratico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casepratico.model.Token;

public interface TokenRepository extends JpaRepository<Token, Long>{

}
