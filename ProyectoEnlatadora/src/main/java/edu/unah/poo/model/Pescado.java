package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="pescado")
public class Pescado {
	
	@Id
	private int idPescado;
	private float tamanioPromedio;
	private String nombre;
	private String color;
	private String tipo;
	
	
	
	
	public Pescado() {}
	
	public Pescado(int idPescado, float tamanioPromedio, String nombre, String color, String tipo) {
		super();
		this.idPescado = idPescado;
		this.tamanioPromedio = tamanioPromedio;
		this.nombre = nombre;
		this.color = color;
		this.tipo = tipo;
	}
	public int getIdPescado() {
		return idPescado;
	}
	public void setIdPescado(int idPescado) {
		this.idPescado = idPescado;
	}
	public float getTamanioPromedio() {
		return tamanioPromedio;
	}
	public void setTamanioPromedio(float tamanioPromedio) {
		this.tamanioPromedio = tamanioPromedio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
