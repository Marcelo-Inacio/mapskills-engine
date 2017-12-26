/*
 * @(#)UserController.java 1.0 03/01/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.mapskills.application.UserApplicationServices;
import br.gov.sp.fatec.mapskills.domain.user.User;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SingleWrapper;
import lombok.AllArgsConstructor;

/**
 * A classe <code>AuthenticationController</code> eh responsavel por conter a
 * rota (uri) de detalhes do usuario logado na aplicacao.
 * 
 * @author Marcelo
 *
 */
@RestController
@AllArgsConstructor
public class UserController {
	
	private final UserApplicationServices userService;
	
	/**
	 * Endpoint que retorna um usuario a partir de seu email.
	 */
	@GetMapping("/user")
	public SingleWrapper<User> getUser(@RequestParam("username") final String username) {
		final User user = userService.findUserByUsername(username);
		return new SingleWrapper<User>(user);
	}
	
	/**
	 * End-point que expoe servico para realizacao da troca de senha de usuario da aplicacao.
	 */
	@PutMapping("/user")
	public void changePassword(@RequestParam(name = "username", required = true) final String username,
			@RequestParam(name = "newPassword", required = true) final String newPassword) {		
		userService.updatePassword(username, newPassword);
	}
}