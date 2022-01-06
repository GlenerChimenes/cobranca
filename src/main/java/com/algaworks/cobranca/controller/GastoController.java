package com.algaworks.cobranca.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cobranca.model.Ano;
import com.algaworks.cobranca.model.AnoReplicar;
import com.algaworks.cobranca.model.Mes;
import com.algaworks.cobranca.model.MesReplicar;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.model.Year;
import com.algaworks.cobranca.service.CadastroTituloService;

@Controller
@RequestMapping("/gastos")
public class GastoController {

	BigDecimal rendaBruta = new BigDecimal("3562.00");
	
	@Autowired
	CadastroTituloService service;
	
	@Autowired
	private CadastroTituloService cadastroTituloService;

	@GetMapping
	public ModelAndView selecionaAnoEMes(Year year) {
		ModelAndView mv = new ModelAndView("gasto/filtroAnoMes");
		//mv.addObject("year", year);

		return mv;
	}

	@PostMapping
	public ModelAndView filtroGastos(Year year) {
		ModelAndView mv = new ModelAndView("gasto/gastosFiltrados");

		List<Titulo> gasto = service.buscaGastosMes(year);
		mv.addObject("titulos", gasto);
		mv.addObject("mes", !gasto.isEmpty()? gasto.get(0).getMes().getDescricao() + " - " + gasto.get(0).getAno().getDescricao():"Nenhum mês encontrado");

		BigDecimal valorTotal = service.valorTotalNew(year);
		mv.addObject("valorTotal",valorTotal != null? valorTotal :"0.00");
		mv.addObject("sobrando", valorTotal != null? rendaBruta.subtract(valorTotal):"0.00"  );

		return mv;
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public ModelAndView excluir(@PathVariable("codigo") Titulo titulo, RedirectAttributes attributes) {
		ModelAndView mv  = new ModelAndView("gasto/gastosFiltrados");
		
		Year year = new Year();
		year.setAno(titulo.getAno());
		year.setMes(titulo.getMes());
		
		cadastroTituloService.excluir(titulo);
		
		return filtroGastos(year);
	}
	
	@RequestMapping(value="/replicar", method = RequestMethod.GET)
	public ModelAndView replicar(Year year) {
		ModelAndView mv = new ModelAndView("gasto/replicarDados");
		//mv.addObject("year", year);

		return mv;
	}
	
	@RequestMapping(value="/replicarDados", method = RequestMethod.POST)
	public ModelAndView replicarDados(Year year) throws Exception {
		ModelAndView mv = new ModelAndView("gasto/replicarDados");
		try {
			if(validaPeriodo(year)) {
				mv.addObject("registrosErro", "Já existe registros para o período");
				return mv;
			}
			service.replicarDados(year);
			mv.addObject("registrosInseridos", "Registros inseridos com sucesso.");
		}catch (Exception e) {
			mv.addObject("registrosErro", "Erro ao inserir registros.");
			return mv;
			//throw new Exception("Erro  ao inserir registros.");
		}
		
		
		return mv;
	}

	private boolean validaPeriodo(Year year) {
		boolean ret = false;
		
		List<Titulo> gastos = service.buscaGastosMesReplicar(year);
		if(!gastos.isEmpty()) {
			ret = true;
		}
		return ret;
	}

	@ModelAttribute("mes")
	public List<Mes> mes() {
		return Arrays.asList(Mes.values());
	}

	@ModelAttribute("ano")
	public List<Ano> ano() {
		return Arrays.asList(Ano.values());
	}
	
	@ModelAttribute("mesReplicar")
	public List<MesReplicar> mesReplicar() {
		return Arrays.asList(MesReplicar.values());
	}

	@ModelAttribute("anoReplicar")
	public List<AnoReplicar> anoReplicar() {
		return Arrays.asList(AnoReplicar.values());
	}

}
