package com.app.pack.entity;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long pid;
	

	@Column
	private String nombreP;
	

	@Column
	private String descripcion;
	

	@Column
	private int codBarras;
	

	@Column
	private int codQR;
	
	@Column
	private String tipo;
	
	@Column
	private float precio;
	
	@Column
	private int cantidad;
	
	@Column
	private String imagen;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(int codBarras) {
		this.codBarras = codBarras;
	}

	public int getCodQR() {
		return codQR;
	}

	public void setCodQR(int codQR) {
		this.codQR = codQR;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, codBarras, codQR, descripcion, imagen, nombreP, pid, precio, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return cantidad == other.cantidad && codBarras == other.codBarras && codQR == other.codQR
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(imagen, other.imagen)
				&& Objects.equals(nombreP, other.nombreP) && Objects.equals(pid, other.pid)
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio)
				&& Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", nombreP=" + nombreP + ", descripcion=" + descripcion + ", codBarras="
				+ codBarras + ", codQR=" + codQR + ", tipo=" + tipo + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", imagen=" + imagen + "]";
	}
	
	
	
	
	
	
}
