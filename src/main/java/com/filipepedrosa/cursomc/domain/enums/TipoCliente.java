package com.filipepedrosa.cursomc.domain.enums;

public enum TipoCliente {
	PESSOAFISICA (1, "Pessoa física"),
	PESSOAJURIDICA (2, "Pessoa jurídica");
	
	private Integer cod;
	private String descricao;
	
	private TipoCliente (Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Integer getCod() {
		return cod;
	}
	
	
	public static TipoCliente toEnum (Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente i : TipoCliente.values()) {
			if (cod.equals(i.getCod())) {
				return i;
			}
		}
		
		throw new IllegalArgumentException("Id" + cod + " não encontrado");
	}
}
