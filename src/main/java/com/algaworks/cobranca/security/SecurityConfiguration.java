package com.algaworks.cobranca.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	//Configuração de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Configuraçao de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/fonts/**").permitAll()
			.antMatchers("/imagem/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/loginUsuario").defaultSuccessUrl("/titulos/novo").permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/loginUsuario?logout")
				.permitAll()
				.and()
				.rememberMe()
					.userDetailsService(autenticacaoService)
		.and().csrf().disable()			
			;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "webjars/**", "/configuration/**", "/swagger-resourses/**");
	
	}
	
}
