package com.app.pack.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long uid;
	
	@Column
	@NotBlank
	private String nombre;
	
	@Column
	@NotBlank
	private String dni;

	@Column
	@NotBlank
	private String apellido1;

	@Column
	private String apellido2;
	
	@Column
	@NotBlank
	private String fechaNac;
	
	@Column
	private String rol;
	
	@Column
	@NotBlank
	@Size(min=10, message="Debe tener al menos 10 caracteres")
	private String email;
	
	@Column
	@NotBlank
	@Size(min=6, message ="Contraseña demasiado corta")
	private String password;
	
	

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, dni, email, fechaNac, nombre, password, rol, uid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(apellido1, other.apellido1) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(dni, other.dni) && Objects.equals(email, other.email)
				&& Objects.equals(fechaNac, other.fechaNac) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(rol, other.rol)
				&& Objects.equals(uid, other.uid);
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", nombre=" + nombre + ", dni=" + dni + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", fechaNac=" + fechaNac + ", rol=" + rol + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
}
