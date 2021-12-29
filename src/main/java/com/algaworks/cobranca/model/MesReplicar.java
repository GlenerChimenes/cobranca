package com.algaworks.cobranca.model;

public enum MesReplicar {

	JANEIRO  ("Janeiro"  ),
	FEVEREIRO("Fevereiro"),
	MARCO    ("Março"    ),
	ABRIL    ("Abril"    ),
	MAIO     ("Maio"     ),
	JUNHO    ("Junho"    ),
	JULHO    ("Julho"    ),
	AGOSTO   ("Agosto"   ),
	SETEMBRO ("Setembro" ),
	OUTUBRO  ("Outubro"  ),
	NOVEMBRO ("Novembro" ),
	DEZEMBRO ("Dezembro" );
	
	private String descricao;
	
	MesReplicar(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
