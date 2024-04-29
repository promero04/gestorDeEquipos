package domain;

import java.util.Date;

public class Entrenador extends Persona{
	
	
	
	private Double nomina;
	private Double seguro;
	private Titulo titulo;
	
	
	
	public Entrenador(String nombre, String apellido1, String apellido2, String dni, Date fNac, Double nomina,
			Double seguro, Titulo titulo) {
		super(nombre, apellido1, apellido2, dni, fNac);
		this.nomina = nomina;
		this.seguro = seguro;
		this.titulo = titulo;
	}
	
	
	public Entrenador() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Double getNomina() {
		return nomina;
	}


	public void setNomina(Double nomina) {
		this.nomina = nomina;
	}


	public Double getSeguro() {
		return seguro;
	}


	public void setSeguro(Double seguro) {
		this.seguro = seguro;
	}


	public Titulo getTitulo() {
		return titulo;
	}


	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}


	@Override
	public String toString() {
		return "Entrenador [nomina=" + nomina + ", seguro=" + seguro + ", titulo=" + titulo + "]";
	}

	

	




	
	
	

}
