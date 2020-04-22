package com.kleberhc.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmailDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento obrigatório!")
	@Email(message="E-mail inválido")
	private String email;
	
	private EmailDTO() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
