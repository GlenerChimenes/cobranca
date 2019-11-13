package com.algaworks.cobranca.controller;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.service.CadastroTituloService;

@Controller
@RequestMapping("/gastos")
public class GastoController {

	@Autowired
	CadastroTituloService service;
	
//	public ModelAndView totalDeGasto(Model model) {
//		ModelAndView mv = new ModelAndView("pesquisaTitulos");
//		TypedQuery valorTotal = service.valorTotal();
//		model.addAttribute("valorTotal", valorTotal);
//		return mv;
//	}
	
	
}
