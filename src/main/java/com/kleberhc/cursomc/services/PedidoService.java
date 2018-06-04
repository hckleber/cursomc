package com.kleberhc.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleberhc.cursomc.domain.Pedido;
import com.kleberhc.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: "+ id + ", Tipo: " + Pedido.class.getName());
		}
		return obj;
	}
}
