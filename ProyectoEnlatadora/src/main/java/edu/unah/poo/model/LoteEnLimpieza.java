package edu.unah.poo.model;



import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table (name= "loteenlimpieza")

public class LoteEnLimpieza{
	@Id
	private int idLoteLimpieza;
	
	public LoteEnLimpieza() {}
	

	
	public LoteEnLimpieza(int idLote, int idLimpieza, Limpieza limpieza, LoteMateriaPrima lote) {
		super();
		this.idLoteLimpieza = idLote+idLimpieza;
		this.limpieza = limpieza;
		this.lote = lote;
	}



	@ManyToOne
	@JoinColumn(name="idlimpieza")
	@JsonBackReference
	private Limpieza limpieza;
	
	@OneToOne
	@JoinColumn(name="idLote")
	@JsonBackReference
	private LoteMateriaPrima lote;
	
	
	
	public int getIdLoteLimpieza() {
		return idLoteLimpieza;
	}



	public void setIdLoteLimpieza(int idLoteLimpieza) {
		this.idLoteLimpieza = idLoteLimpieza;
	}



	public Limpieza getLimpieza() {
		return limpieza;
	}



	public void setLimpieza(Limpieza limpieza) {
		this.limpieza = limpieza;
	}



	public LoteMateriaPrima getLote() {
		return lote;
	}



	public void setLote(LoteMateriaPrima lote) {
		this.lote = lote;
	}




}
