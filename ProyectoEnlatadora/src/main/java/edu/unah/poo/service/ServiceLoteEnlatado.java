package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.LoteEnlatado;
import edu.unah.poo.repository.RepositoryLoteEnlatado;

@Service
public class ServiceLoteEnlatado {
	@Autowired 
	RepositoryLoteEnlatado repositoryLoteEnlatado;
	
	public void crear(LoteEnlatado loteenlatado) {
		this.repositoryLoteEnlatado.save(loteenlatado);
	}
	
	public LoteEnlatado buscar(int id) {
		return this.repositoryLoteEnlatado.findById(id);
	} 
	
	public LoteEnlatado obtener(int id) {
		return this.repositoryLoteEnlatado.getOne(id);
	} 
	
	
	public List<LoteEnlatado> obtenerLista(){
		return this.repositoryLoteEnlatado.findAll();
	}
}