package edu.unah.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "loteenlatado")
public class LoteEnlatado extends Lote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tamanioLata;
	private LocalDate fechaDePrecio;
	
	
	public LoteEnlatado() {	}
	


	public LoteEnlatado(int idLote, int cantidad, float precioPorUnidadDeMedida, String unidadDeMedida,
			int indiceDeCalidad, Pescado pescado, int tamanioLata, LocalDate fechaDePrecio) {
		super(idLote, cantidad, precioPorUnidadDeMedida, unidadDeMedida, indiceDeCalidad, pescado);
		this.tamanioLata = tamanioLata;
		this.fechaDePrecio = fechaDePrecio;
	}



	public int getTamanioLata() {
		return tamanioLata;
	}



	public void setTamanioLata(int tamanioLata) {
		this.tamanioLata = tamanioLata;
	}



	public LocalDate getFechaDePrecio() {
		return fechaDePrecio;
	}



	public void setFechaDePrecio(LocalDate fechaDePrecio) {
		this.fechaDePrecio = fechaDePrecio;
	}
	
	
	
	
	
}
