package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Factura;
import edu.unah.poo.model.IdProductoVendido;

import edu.unah.poo.model.ProductoVendido;
import edu.unah.poo.repository.RepositoryProductoVendido;


@Service
public class ServiceProductoVendido {

	@Autowired 
	RepositoryProductoVendido  repositoryproductovendido;
	
	public void crear(ProductoVendido productovendido) {
		this.repositoryproductovendido.save(productovendido);
	}
	
	public ProductoVendido buscar(IdProductoVendido idproductovendido) {
		return this.repositoryproductovendido.getOne(idproductovendido);
	}
	
	public List<ProductoVendido> obtenerLista(){
		return this.repositoryproductovendido.findAll();
	}
	
	public List<ProductoVendido> obtenerListaPorFactura(Factura factura ){
		return this.repositoryproductovendido.findByFactura(factura);
	}
}
