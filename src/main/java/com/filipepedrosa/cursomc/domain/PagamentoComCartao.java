package com.filipepedrosa.cursomc.domain;

import com.filipepedrosa.cursomc.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento{
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao (){
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
