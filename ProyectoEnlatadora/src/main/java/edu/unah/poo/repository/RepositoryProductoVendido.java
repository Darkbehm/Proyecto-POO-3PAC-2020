package edu.unah.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Factura;
import edu.unah.poo.model.IdProductoVendido;
import edu.unah.poo.model.ProductoVendido;

public interface RepositoryProductoVendido extends JpaRepository<ProductoVendido, IdProductoVendido> {

	public List<ProductoVendido> findByFactura(Factura factura);

}
