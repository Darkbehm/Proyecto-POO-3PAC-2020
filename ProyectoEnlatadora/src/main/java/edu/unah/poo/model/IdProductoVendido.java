package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdProductoVendido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4414735871227721716L;
	private int numeroFactura;
	private int idLote;
	
	public IdProductoVendido() {}
	
	
	
	public IdProductoVendido(int numeroFactura, int idLote) {
		super();
		this.numeroFactura = numeroFactura;
		this.idLote = idLote;
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdProductoVendido) {
			IdProductoVendido tmpid = (IdProductoVendido)obj;
			if (this.idLote == tmpid.getIdLote() && this.numeroFactura == tmpid.getNumeroFactura()){
				return true;
			}else 
				return false;
		}else return false;
		
	}
	
	
	public int hashCode() {
		return (int) this.numeroFactura+ this.idLote;
	}



	public int getNumeroFactura() {
		return numeroFactura;
	}



	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}



	public int getIdLote() {
		return idLote;
	}



	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}
}