package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table (name= "productovendido")
@IdClass(IdProductoVendido.class)
public class ProductoVendido {

		@Id
		private int idLote;
		@Id
		private int numeroFactura;
		
		private float precio;
		private int cantidad;

		public ProductoVendido() {}
		
		public ProductoVendido(int idLote, int numeroFactura, float precio, int cantidad, LoteEnlatado loteenlatado,
				Factura factura) {
			super();
			this.idLote = idLote;
			this.numeroFactura = numeroFactura;
			this.precio = precio;
			this.cantidad = cantidad;
			this.loteenlatado = loteenlatado;
			this.factura = factura;
		}

		@ManyToOne
		@JoinColumn(name="idLote", referencedColumnName="idLote", insertable = false, updatable = false)
		@JsonBackReference
		private LoteEnlatado loteenlatado;
		
		@ManyToOne
		@JoinColumn(name="numeroFactura", referencedColumnName="numeroFactura", insertable = false, updatable = false)
		@JsonBackReference
		private Factura factura;

		public int getIdLote() {
			return idLote;
		}

		public void setIdLote(int idLote) {
			this.idLote = idLote;
		}


		public float getPrecio() {
			return precio;
		}

		public void setPrecio(float precio) {
			this.precio = precio;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public int getNumeroFactura() {
			return numeroFactura;
		}

		public void setNumeroFactura(int numeroFactura) {
			this.numeroFactura = numeroFactura;
		}

		public LoteEnlatado getLoteenlatado() {
			return loteenlatado;
		}

		public void setLoteenlatado(LoteEnlatado loteenlatado) {
			this.loteenlatado = loteenlatado;
		}

		public Factura getFactura() {
			return factura;
		}

		public void setFactura(Factura factura) {
			this.factura = factura;
		}
		
		
		
}
