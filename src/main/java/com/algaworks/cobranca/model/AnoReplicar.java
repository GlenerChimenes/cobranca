package com.algaworks.cobranca.model;

public enum AnoReplicar {

	ANO2018("2018"),
	ANO2019("2019"),
	ANO2020("2020"),
	ANO2021("2021"),
	ANO2022("2022"),
	ANO2023("2023");

	private String descricao;

	AnoReplicar(String descricao) {
		this.descricao = descricao;

	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
