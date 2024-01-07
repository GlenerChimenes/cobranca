package com.algaworks.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.cobranca.model.Ano;
import com.algaworks.cobranca.model.AnoReplicar;
import com.algaworks.cobranca.model.Mes;
import com.algaworks.cobranca.model.MesReplicar;
import com.algaworks.cobranca.model.Titulo;

public interface TituloRepository extends JpaRepository<Titulo, Long>{

	public List<Titulo> findByDescricaoContaining(String descricao);

	Titulo findByCodigo(Long codigo);

	@Query("select SUM(t.valor) from Titulo t ")
	List<Titulo> somoGastos( String valorTotal);

	@Modifying
	@Query(value =
			"insert into titulo                   " +
					"(ano,                        " +
					" data_vencimento,            " +
					" descricao,                  " +
					" mes,                        " +
					" status,                     " +
					" valor)                      " +
					"select :anoReplicar,         " +
//					"       t.data_vencimento,    " +
					"       DATE_ADD(t.data_vencimento, INTERVAL 1 MONTH ),    " +
					"       t.descricao,          " +
					"       :mesReplicar,         " +
					"       'PENDENTE',           " +
					"       t.valor               " +
					"from titulo t                " +
					" where t.ano =:ano           " +
					" and   t.mes =:mes           " ,  
			nativeQuery = true)
	@Transactional
	public void replicarDados(@Param("ano") String ano, @Param("mes") String mes, @Param("anoReplicar") String anoReplicar, @Param("mesReplicar") String mesReplicar);
	
	
}
