package com.filipepedrosa.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.filipepedrosa.cursomc.domain.Categoria;
import com.filipepedrosa.cursomc.domain.Cidade;
import com.filipepedrosa.cursomc.domain.Cliente;
import com.filipepedrosa.cursomc.domain.Endereco;
import com.filipepedrosa.cursomc.domain.Estado;
import com.filipepedrosa.cursomc.domain.Produto;
import com.filipepedrosa.cursomc.domain.enums.TipoCliente;
import com.filipepedrosa.cursomc.repositories.CategoriaRepository;
import com.filipepedrosa.cursomc.repositories.CidadeRepository;
import com.filipepedrosa.cursomc.repositories.ClienteRepository;
import com.filipepedrosa.cursomc.repositories.EnderecoRepository;
import com.filipepedrosa.cursomc.repositories.EstadoRepository;
import com.filipepedrosa.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	public void run(String... args) throws Exception{	
		addCategoriasProdutos ();
		addEstadosCidades ();		
	}
	
	public void addEstadosCidades () {
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", e1);
		Cidade c2 = new Cidade(null, "São Paulo", e2);
		Cidade c3 = new Cidade(null, "Campinas", e2);
		
		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2, c3));	
		
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente (null, "Maria Silva", "maria@gmail.com", "99999999999", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("33589858", "985693325"));
		Endereco end1 = new Endereco(null, "Rua Flores", "144", "casa", "Santa Efigencia"
				, "30640970", c1 , cli1);
		Endereco end2 = new Endereco(null, "Av Brasil", "888", "sala 1400", "Funcionarios"
				, "30640970", c2 , cli1);
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
	}
	
	public void addCategoriasProdutos () {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 50.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
