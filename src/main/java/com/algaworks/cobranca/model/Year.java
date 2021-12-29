package com.algaworks.cobranca.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Year {

	private Long codigo;
	
	@Enumerated(EnumType.STRING)
	private Ano ano;
	
	@Enumerated(EnumType.STRING)
	private Mes mes;
	
	@Enumerated(EnumType.STRING)
	private AnoReplicar anoReplicar;
	
	@Enumerated(EnumType.STRING)
	private MesReplicar mesReplicar;
	

	public AnoReplicar getAnoReplicar() {
		return anoReplicar;
	}

	public void setAnoReplicar(AnoReplicar anoReplicar) {
		this.anoReplicar = anoReplicar;
	}

	public MesReplicar getMesReplicar() {
		return mesReplicar;
	}

	public void setMesReplicar(MesReplicar mesReplicar) {
		this.mesReplicar = mesReplicar;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Ano getAno() {
		return ano;
	}

	public void setAno(Ano ano) {
		this.ano = ano;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}
	
}
