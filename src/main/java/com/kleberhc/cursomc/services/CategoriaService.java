package com.kleberhc.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kleberhc.cursomc.domain.Categoria;
import com.kleberhc.cursomc.repositories.CategoriaRepository;
import com.kleberhc.cursomc.services.exceptions.DataIntegrityExeption;
import com.kleberhc.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: "+ id + ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null); // Usar nulo para dizer ao banco que é uma inclusão
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId()); // Conferir se o ID existe
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityExeption("Não é possível excluir uma categoria que possui produtos");
					}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
}
