package com.casepratico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casepratico.model.Pais;
import com.casepratico.repository.PaisRepository;

@Service
public class PaisService {
	
	@Autowired
	private PaisRepository paisRepository;

	public List<Pais> listar() {
		return paisRepository.findAll();
	}

}
