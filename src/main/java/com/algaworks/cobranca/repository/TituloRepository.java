package com.algaworks.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algaworks.cobranca.model.Titulo;

public interface TituloRepository extends JpaRepository<Titulo, Long>{

	public List<Titulo> findByDescricaoContaining(String descricao);

	Titulo findByCodigo(Long codigo);

	@Query("select SUM(t.valor) from Titulo t ")
	List<Titulo> somoGastos( String valorTotal);
	
	
}
