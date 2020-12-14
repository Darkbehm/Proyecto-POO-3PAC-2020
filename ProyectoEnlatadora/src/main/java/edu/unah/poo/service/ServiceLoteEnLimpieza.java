package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Limpieza;
import edu.unah.poo.model.LoteEnLimpieza;
import edu.unah.poo.repository.RepositoryLoteEnLimpieza;

@Service
public class ServiceLoteEnLimpieza {
	@Autowired 
	RepositoryLoteEnLimpieza repositoryLoteEnLimpieza;
	
	public void crear(LoteEnLimpieza loteenlimpieza) {
		this.repositoryLoteEnLimpieza.save(loteenlimpieza);
	}
	
	public LoteEnLimpieza buscar(int id) {
		return this.repositoryLoteEnLimpieza.findById(id);
	} 
	
	public List<LoteEnLimpieza> obtenerLista(){
		return this.repositoryLoteEnLimpieza.findAll();
	}
	
	public List<LoteEnLimpieza> obtenerListaPorLimpieza(Limpieza limpieza ){
		return this.repositoryLoteEnLimpieza.findByLimpieza(limpieza);
	}
}
