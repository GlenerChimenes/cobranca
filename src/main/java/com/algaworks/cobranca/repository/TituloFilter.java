package com.algaworks.cobranca.repository;

import com.algaworks.cobranca.model.Mes;

public class TituloFilter {

	private  String descricao;
	private Mes mes;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Mes getMes() {
		return mes;
	}
	
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	
	
}
