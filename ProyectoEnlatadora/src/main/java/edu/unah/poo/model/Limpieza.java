package edu.unah.poo.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "limpieza")
public class Limpieza {
	@Id
	private int idLimpieza;
	private String horaInicial;
	private String horaFinal;
	private int numeroEmpleados;
	private int numeroDeEnlatados;
	
	
	
	public Limpieza() {}

	public Limpieza(int idLimpieza, String horaInicial, String horaFinal, int numeroEmpleados, int numeroEnlatados,
			Empleado empleado) {
		super();
		this.idLimpieza = idLimpieza;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.numeroEmpleados = numeroEmpleados;
		this.numeroDeEnlatados = numeroEnlatados;
		this.empleado = empleado;
	}

	@ManyToOne
	@JoinColumn(name="idEmpleado")
	@JsonBackReference
	private Empleado empleado;
	
	@OneToMany(mappedBy="idLoteLimpieza",fetch=FetchType.EAGER)
	private List<LoteEnLimpieza> lotes;
	
	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getIdLimpieza() {
		return idLimpieza;
	}

	public void setIdLimpieza(int idLimpieza) {
		this.idLimpieza = idLimpieza;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public int getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	public int getNumeroEnlatados() {
		return numeroDeEnlatados;
	}

	public void setNumeroEnlatados(int numeroEnlatados) {
		this.numeroDeEnlatados = numeroEnlatados;
	}
	
	
}
