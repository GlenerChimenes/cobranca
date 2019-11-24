package com.algaworks.cobranca.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.model.Ano;
import com.algaworks.cobranca.model.Mes;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.model.Year;
import com.algaworks.cobranca.service.CadastroTituloService;

@Controller
@RequestMapping("/gastos")
public class GastoController {

	@Autowired
	CadastroTituloService service;

	@GetMapping
	public ModelAndView selecionaAnoEMes(Year year) {
		ModelAndView mv = new ModelAndView("gasto/filtroAnoMes");
		mv.addObject("year", year);

		return mv;
	}

	@PostMapping
	public ModelAndView filtroGastos(Year year) {
		ModelAndView mv = new ModelAndView("gasto/gastosFiltrados");

		List<Titulo> gasto = service.filtroGasto(year);
		mv.addObject("titulos", gasto);

		BigDecimal valorTotal = service.valorTotal(year);
		mv.addObject("valorTotal", valorTotal);

		return mv;
	}

	@ModelAttribute("mes")
	public List<Mes> mes() {
		return Arrays.asList(Mes.values());
	}

	@ModelAttribute("ano")
	public List<Ano> ano() {
		return Arrays.asList(Ano.values());
	}

}
