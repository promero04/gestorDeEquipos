package domain;

import java.io.Serializable;
import java.util.Date;

public class Jugador extends Persona implements Serializable{
	private int numDorsal;
	private Double seguro;
	private Posicion posicion;
	
	
	public Jugador(String nombre, String apellido1, String apellido2, String dni, Date fNac, int numDorsal,
			Double seguro, Posicion posicion) {
		super(nombre, apellido1, apellido2, dni, fNac);
		this.numDorsal = numDorsal;
		this.seguro = seguro;
		this.posicion = posicion;
	}
	public Jugador() {
		super();
		
	}
	public int getNumDorsal() {
		return numDorsal;
	}
	public void setNumDorsal(int numDorsal) {
		this.numDorsal = numDorsal;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public Double getSeguro() {
		return seguro;
	}
	public void setSeguro(Double seguro) {
		this.seguro = seguro;
	}

	@Override
	public String toString() {
		return  posicion + "  " + getNombre() +" "+ getApellido1() +" "+getApellido2();
		}
	
}
