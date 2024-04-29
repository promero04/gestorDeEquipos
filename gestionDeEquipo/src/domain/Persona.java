package domain;

import java.util.Date;

public abstract class Persona {
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private Date fNac;
	
	
	
	
	public Persona(String nombre, String apellido1,String apellido2, String dni, Date fNac
			) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fNac = fNac;
		
	}
	public Persona() {
		super();
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.dni = "";
		this.fNac = null;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getfNac() {
		return fNac;
	}
	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni
				+ ", fNac=" + fNac + "]";
	}
	
	

}
