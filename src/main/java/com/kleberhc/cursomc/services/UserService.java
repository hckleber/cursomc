package com.kleberhc.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.kleberhc.cursomc.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		// Pode haver uma excessao para o caso, por exemplo qnd nao há usuário logado
		try {	
		return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			}
		catch (Exception e) {
			return null;
		}
	}		
}
