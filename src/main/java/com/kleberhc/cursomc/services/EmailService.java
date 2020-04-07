package com.kleberhc.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.kleberhc.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj) ;
	
	void sendEmail(SimpleMailMessage msg) ;
	
	
}
