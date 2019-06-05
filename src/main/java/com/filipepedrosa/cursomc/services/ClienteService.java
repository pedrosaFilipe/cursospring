package com.filipepedrosa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipepedrosa.cursomc.domain.Cliente;
import com.filipepedrosa.cursomc.repositories.ClienteRepository;

import com.filipepedrosa.cursomc.exceptions.ObjetctNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente buscarProdutos(Integer id) {
		Optional<Cliente> cat = repository.findById(id);
		
		return cat.orElseThrow((() -> new ObjetctNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())));
	}
}
