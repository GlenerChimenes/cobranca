package com.algaworks.cobranca.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.model.Year;
import com.algaworks.cobranca.repository.TituloFilter;
import com.algaworks.cobranca.repository.TituloRepository;

@Service
public class CadastroTituloService  {

	@Autowired
	private TituloRepository tituloRepository;
	
	@Autowired
	private EntityManager manager;
	
	public void salvar(Titulo titulo) {
		try{
		tituloRepository.save(titulo);
		
		}catch(DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
		}

	public void excluir(Titulo titulo) {
		tituloRepository.delete(titulo);
	}

	public String receber(Long codigo) {
		Titulo titulo = tituloRepository.findByCodigo(codigo);
		titulo.setStatus(StatusTitulo.PAGO);
		tituloRepository.save(titulo);
		
		return StatusTitulo.PAGO.getDescricao();
	}
	
	public List<Titulo> filtrar(TituloFilter filtro){
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return  tituloRepository.findByDescricaoContaining(descricao);
	}
	
	public List<Titulo> listaTitulos() {
		
//		List<Titulo> titulos = manager.createQuery("select t from Titulo t where t.descricao like ':%t.descricao%' ", Titulo.class)
//				.getResultList();
		List<Titulo> titulos = tituloRepository.findAll();
		return titulos;
	}
	
	public BigDecimal valorTotal(){
		
		BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t")
				.getSingleResult();
		
		return (BigDecimal) titulos;
	}

	public List<Titulo> filtroGasto(Year year) {
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Agosto") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'AGOSTO'  ")
					.getResultList();
			
			return filtro;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Setembro") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'SETEMBRO'  ")
					.getResultList();
			
			return filtro;
		}
		
		return null;
		
		
	}
	
	
	
}
