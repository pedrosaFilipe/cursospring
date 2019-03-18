package com.filipepedrosa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipepedrosa.cursomc.domain.Categoria;
import com.filipepedrosa.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscarProdutos(Integer id) {
		Optional<Categoria> cat = repository.findById(id);
		
		return cat.orElse(new Categoria(-1, "Nao encontrada"));
	}
}
