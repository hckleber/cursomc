package com.kleberhc.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.kleberhc.cursomc.domain.Cliente;
import com.kleberhc.cursomc.dto.ClienteDTO;
import com.kleberhc.cursomc.repositories.ClienteRepository;
import com.kleberhc.cursomc.resources.exception.FieldMessage;

public class ClienteUpDateValidator implements ConstraintValidator<ClienteUpDate, ClienteDTO> {
	
	@Autowired
	private HttpServletRequest request;
	// pega parametros dentro da URI (URL do JSON)
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteUpDate ann) {

	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		// inclua os testes aqui, inserindo erros na lista
		// comparar o Id que chegou da busca pelo DTO com o Id que estamos atualizado
		
		Cliente aux =repo.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
