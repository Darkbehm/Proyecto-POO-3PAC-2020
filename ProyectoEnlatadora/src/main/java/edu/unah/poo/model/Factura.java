package edu.unah.poo.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "factura")
public class Factura {
	@Id
	private int numeroFactura;
	private LocalDate fechaVenta;
	private String lugar;
	
	@ManyToOne
	@JoinColumn(name="idEmpleado")
	@JsonBackReference
	private Empleado empleado;
	

	
	
	public Factura() {}

	public Factura(int numeroFactura, LocalDate fechaVenta, String lugar, Empleado empleado) {
		super();
		this.numeroFactura = numeroFactura;
		this.fechaVenta = fechaVenta;
		this.lugar = lugar;
		this.empleado = empleado;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
}
