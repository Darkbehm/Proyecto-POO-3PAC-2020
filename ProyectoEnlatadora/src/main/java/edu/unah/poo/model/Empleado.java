package edu.unah.poo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
	@Id
	private int idEmpleado;
	private String nombre;
	private int telefono;
	private String direccion;
	private LocalDate fechaDeNacimiento;
	private String Puesto;
	private LocalDate fechaDeContratacion;
	private String contrasenia;
	
	
	public Empleado () {}
	
	public Empleado(int idEmpleado, String nombre, int telefono, String direccion, LocalDate fechaDeNacimiento,
			String puesto, LocalDate fechaDeContratacion, String contrasenia) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaDeNacimiento = fechaDeNacimiento;
		Puesto = puesto;
		this.fechaDeContratacion = fechaDeContratacion;
		this.contrasenia = contrasenia;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getPuesto() {
		return Puesto;
	}

	public void setPuesto(String puesto) {
		Puesto = puesto;
	}

	public LocalDate getFechaDeContratacion() {
		return fechaDeContratacion;
	}

	public void setFechaDeContratacion(LocalDate fechaDeContratacion) {
		this.fechaDeContratacion = fechaDeContratacion;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	
}
