package com.app.pack.entity;


import java.io.Serializable;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	@NotBlank(message="Campo vacío")
	private String nombreP;
	

	@Column
	@NotBlank(message="Campo vacío")
	private String descripcion;
	

	@Column
	@NotNull(message="Campo vacío")
	@Pattern(regexp = "[0-9]{13}", message="El formato correcto son 13 dígitos")
	private String codBarras;
	

	@Column
	@NotNull(message="Campo vacío")
	private String codQR;
	
	@Column
	@NotBlank(message="Campo vacío")
	private String tipo;
	
	@Column
	@NotNull(message="Campo vacío")
	private Float precio;
	
	@Column
	@NotNull(message="Campo vacío")
	private Long cantidad;
	
	@Column
	@NotBlank(message="Campo vacío")
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

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getCodQR() {
		return codQR;
	}

	public void setCodQR(String codQR) {
		this.codQR = codQR;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
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
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(codBarras, other.codBarras)
				&& Objects.equals(codQR, other.codQR) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(imagen, other.imagen) && Objects.equals(nombreP, other.nombreP)
				&& Objects.equals(pid, other.pid) && Objects.equals(precio, other.precio)
				&& Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", nombreP=" + nombreP + ", descripcion=" + descripcion + ", codBarras="
				+ codBarras + ", codQR=" + codQR + ", tipo=" + tipo + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", imagen=" + imagen + "]";
	}

	
   
	
	
}
