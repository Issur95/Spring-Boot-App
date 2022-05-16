package com.app.pack.entity;

import java.io.Serializable;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	@NotBlank(message="Campo vacío")
	private String nombre;
	
	@Column
	@NotBlank(message="Campo vacío")
	@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message="El formato debe ser 8 numeros y 1 letra")
	private String dni;

	@Column
	@NotBlank(message="Campo vacío")
	private String apellido1;

	@Column
	private String apellido2;
	
	@Column
	@NotBlank(message="Campo vacío")
	private String fechaNac;
	
	@Column
	@Size(min=10, message="Debe tener al menos 10 caracteres")
	private String email;
	
	@Column
	@Size(min=6, message ="Contraseña demasiado corta")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles"
		,joinColumns=@JoinColumn(name="user_id")
		,inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;

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
		//BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
	       
		//this.password = bCryptPasswordEncoder.encode(password);
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, dni, email, fechaNac, nombre, password, uid);
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
				&& Objects.equals(password, other.password) 
				&& Objects.equals(uid, other.uid);
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", nombre=" + nombre + ", dni=" + dni + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", fechaNac=" + fechaNac + ",  email=" + email + ", password=" + password
				+ "]";
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
