package com.filipepedrosa.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne; 

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter @Setter @NoArgsConstructor
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	Date instante;
	
	@ManyToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Pedido(Integer id, Date instante, Endereco endereco, Pagamento pagamento, Cliente cliente) {
		super();
		this.id = id;
		this.instante = instante;
		this.endereco = endereco;
		this.pagamento = pagamento;
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
