package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.LoteMateriaPrima;
import edu.unah.poo.repository.RepositoryLoteMateriaPrima;

@Service
public class ServiceLoteMateriaPrima {
	@Autowired 
	RepositoryLoteMateriaPrima repositoryLoteMateriaPrima;
	
	public void crear(LoteMateriaPrima loteMateriaPrima) {
		this.repositoryLoteMateriaPrima.save(loteMateriaPrima);
	}
	
	public LoteMateriaPrima buscar(int id) {
		return this.repositoryLoteMateriaPrima.findById(id);
	} 
	
	public LoteMateriaPrima obtener(int id) {
		return this.repositoryLoteMateriaPrima.getOne(id);
	} 
	
	
	public List<LoteMateriaPrima> obtenerLista(){
		return this.repositoryLoteMateriaPrima.findAll();
	}
}
