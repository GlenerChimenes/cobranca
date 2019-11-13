package com.algaworks.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.model.Usuario;
import com.algaworks.cobranca.repository.UsuarioRepository;

@Controller
//@RequestMapping("/login")
public class LoginController {

//	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/loginUsuario", method= RequestMethod.GET)
	public String login(Usuario usuario, ModelAndView model) {
		model.addObject("usuario", usuario);
		return "/login";
	}
	
}
