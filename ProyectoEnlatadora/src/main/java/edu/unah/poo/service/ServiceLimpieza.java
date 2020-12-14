package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Limpieza;
import edu.unah.poo.repository.RepositoryLimpieza;

@Service
public class ServiceLimpieza {
	@Autowired 
	RepositoryLimpieza repositoryLimpieza;
	
	public void crear(Limpieza limpieza) {
		this.repositoryLimpieza.save(limpieza);
	}
	public Limpieza obtener(int id) {
		return this.repositoryLimpieza.getOne(id);
	} 
	
	public Limpieza buscar(int id) {
		return this.repositoryLimpieza.findById(id);
	} 
	
	public List<Limpieza> obtenerLista(){
		return this.repositoryLimpieza.findAll();
	}
}
