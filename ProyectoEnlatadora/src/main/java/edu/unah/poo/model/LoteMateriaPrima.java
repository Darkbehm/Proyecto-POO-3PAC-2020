package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "loteMateriaPrima")
public class LoteMateriaPrima extends Lote implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String proveedor;
	
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="idEmpleado")
	@JsonBackReference
	private Empleado empleado;

	
	
	public LoteMateriaPrima() {
	}



	public LoteMateriaPrima(int idLote, int cantidad, float precioPorUnidadDeMedida, String unidadDeMedida,
			int indiceDeCalidad, Pescado pescado, String proveedor, String estado, Empleado empleado) {
		super(idLote, cantidad, precioPorUnidadDeMedida, unidadDeMedida, indiceDeCalidad, pescado);
		this.proveedor = proveedor;
		this.estado = estado;
		this.empleado = empleado;
	}



	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
}
