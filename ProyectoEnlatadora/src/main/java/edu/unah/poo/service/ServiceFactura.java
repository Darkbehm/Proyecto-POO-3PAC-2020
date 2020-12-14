package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Factura;
import edu.unah.poo.repository.RepositoryFactura;

@Service
public class ServiceFactura {
	@Autowired 
	RepositoryFactura repositoryFactura;
	
	public void crear(Factura factura) {
		this.repositoryFactura.save(factura);
	}
	
	public Factura buscar(int id) {
		return this.repositoryFactura.findById(id);
	} 
	
	public List<Factura> obtenerLista(){
		return this.repositoryFactura.findAll();
	}
}
