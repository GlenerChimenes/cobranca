package com.algaworks.cobranca.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.cobranca.model.Ano;
import com.algaworks.cobranca.model.Mes;
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
	
	@Deprecated
	public BigDecimal valorTotal(Year year){
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Janeiro" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'JANEIRO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Fevereiro" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'FEVEREIRO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "MARCO" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'MARCO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Abril" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'ABRIL'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Maio" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'MAIO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Junho" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'JUNHO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Julho" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'JULHO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Agosto" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'AGOSTO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Setembro" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'SETEMBRO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Outubro" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'OUTUBRO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Novembro" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'NOVEMBRO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Dezembro" ) {
			BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano='ANO2019' and t.mes = 'DEZEMBRO'")
					.getSingleResult();
			
			return (BigDecimal) titulos;
		}
//		BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t")
//				.getSingleResult();
//		
		return null;
	}
	
	
	@Deprecated
	public List<Titulo> filtroGasto(Year year) {
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Janeiro") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'JANEIRO'  ")
					.getResultList();
			
			return filtro;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Fevereiro") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'FEVEREIRO'  ")
					.getResultList();
			
			return filtro;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Marco") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'MARCO'  ")
					.getResultList();
			
			return filtro;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Abril") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'ABRIL'  ")
					.getResultList();
			
			return filtro;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Maio") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'MAIO'  ")
					.getResultList();
			
			return filtro;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Junho") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'JUNHO'  ")
					.getResultList();
			
			return filtro;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Julho") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'JULHO'  ")
					.getResultList();
			
			return filtro;
		}
		
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
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Outubro") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'OUTUBRO'  ")
					.getResultList();
			
			return filtro;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Novembro") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'NOVEMBRO'  ")
					.getResultList();
			
			return filtro;
		}
		
		if(year.getAno().getDescricao() == "2019" && year.getMes().getDescricao() == "Dezembro") {
			List<Titulo> filtro =  (List<Titulo>) manager.createQuery("select t from Titulo t where t.ano = 'ANO2019' and t.mes = 'DEZEMBRO'  ")
					.getResultList();
			
			return filtro;
		}
		
		
		
		return null;
		
		
	}

	
	
	public List<Titulo> buscaGastosMes(Year year){
		List<Titulo> titulos = manager.createQuery("select t from Titulo t where t.ano = '" + year.getAno() + "' and t.mes = '" + year.getMes() + "'").getResultList();
		
		return titulos;
	}
	
	public BigDecimal valorTotalNew(Year year) {
		BigDecimal soma = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t where t.ano = '" + year.getAno() + "' and t.mes = '" + year.getMes() + "'").getSingleResult();
		return (BigDecimal) soma;
	}
	
	
	public BigDecimal valorTotalGeral() {
		BigDecimal titulos = (BigDecimal) manager.createQuery("select sum(t.valor) from Titulo t")
				.getSingleResult();
		
		return titulos;
	}
	
	
	
}
