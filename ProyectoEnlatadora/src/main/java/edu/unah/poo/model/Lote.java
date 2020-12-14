package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

public abstract class Lote {
	@Id
	private int idLote;
	private int cantidad;
	private float precioPorUnidadDeMedida;
	private String unidadDeMedida;
	private int indiceDeCalidad;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="idPescado")
	@JsonBackReference
	private Pescado pescado;
	
	public Lote() {}
	
	public Lote(int idLote, int cantidad, float precioPorUnidadDeMedida, String unidadDeMedida, int indiceDeCalidad,
			Pescado pescado) {
		super();
		this.idLote = idLote;
		this.cantidad = cantidad;
		this.precioPorUnidadDeMedida = precioPorUnidadDeMedida;
		this.unidadDeMedida = unidadDeMedida;
		this.indiceDeCalidad = indiceDeCalidad;
		this.pescado = pescado;
	}

	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioPorUnidadDeMedida() {
		return precioPorUnidadDeMedida;
	}

	public void setPrecioPorUnidadDeMedida(float precioPorCantidadDeMedida) {
		this.precioPorUnidadDeMedida = precioPorCantidadDeMedida;
	}

	public String getUnidadDeMedida() {
		return unidadDeMedida;
	}

	public void setUnidadDeMedida(String unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}

	public int getIndiceDeCalidad() {
		return indiceDeCalidad;
	}

	public void setIndiceDeCalidad(int indiceDeCalidad) {
		this.indiceDeCalidad = indiceDeCalidad;
	}

	public Pescado getPescado() {
		return pescado;
	}

	public void setPescado(Pescado pescado) {
		this.pescado = pescado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
