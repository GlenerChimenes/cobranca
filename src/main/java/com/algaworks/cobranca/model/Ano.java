package com.algaworks.cobranca.model;

public enum Ano {

	ANO2019("2019"),
	ANO2020("2020");

	private String descricao;

	Ano(String descricao) {
		this.descricao = descricao;

	}
	
	public String getDescricao() {
		return descricao;
	}
}
