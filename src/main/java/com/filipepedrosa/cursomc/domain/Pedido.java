package com.filipepedrosa.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne; 

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	Date instante;
	
	@ManyToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	@OneToOne
	private Pagamento pagamento;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	public Pedido () {
		
	}

	public Pedido(Integer id, Date instante, Endereco endereco, Pagamento pagamento, Cliente cliente) {
		super();
		this.id = id;
		this.instante = instante;
		this.endereco = endereco;
		this.pagamento = pagamento;
		this.cliente = cliente;
	}
	
	
}
