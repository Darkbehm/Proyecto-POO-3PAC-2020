package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Pescado;
import edu.unah.poo.repository.RepositoryPescado;


@Service
public class ServicePescado {
	@Autowired 
	RepositoryPescado repositoryPescado;
	
	public void crear(Pescado pescado) {
		this.repositoryPescado.save(pescado);
	}
	
	public Pescado buscar(int id) {
		return this.repositoryPescado.findById(id);
	} 
	
	public List<Pescado> obtenerLista(){
		return this.repositoryPescado.findAll();
	}
	
}
