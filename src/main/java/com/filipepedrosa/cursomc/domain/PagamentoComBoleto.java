package com.filipepedrosa.cursomc.domain;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.filipepedrosa.cursomc.domain.enums.EstadoPagamento;

@Getter @Setter @NoArgsConstructor
public class PagamentoComBoleto extends Pagamento{
	
	private Date dataVencimento;
	private Date dataPagamento;

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
}
