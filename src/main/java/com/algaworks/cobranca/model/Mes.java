package com.algaworks.cobranca.model;

public enum Mes {

	JANEIRO("Janeiro"),
	FEVEREIRO("Fevereiro"),
	MARCO("Marco"),
	ABRIL("Abril"),
	MAIO("Maio"),
	JUNHO("Junho"),
	JULHO("Julho"),
	AGOSTO("Agosto"),
	SETEMBRO("Setembro"),
	OUTUBRO("Outubro"),
	NOVEMBRO("Novembro"),
	DEZEMBRO("Dezembro");
	
	private String descricao;
	
	Mes(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
