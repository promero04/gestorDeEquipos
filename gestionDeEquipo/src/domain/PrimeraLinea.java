package domain;

import java.util.Date;

public class PrimeraLinea extends Jugador{
	
	private int numeroTirosNueveMetros;
	private int numeroTirosNueveMetrosMetidos;
	private int numeroTirosNueveMetrosFallados;
	private int perdidasDeBalon;
	
	public PrimeraLinea(String nombre, String apellido1, String apellido2, String dni, Date fNac, int numDorsal,
			Double seguro, Posicion posicion, int numeroTirosNueveMetros, int numeroTirosNueveMetrosMetidos,
			int numeroTirosNueveMetrosFallados, int perdidasDeBalon) {
		super(nombre, apellido1, apellido2, dni, fNac, numDorsal, seguro, posicion);
		this.numeroTirosNueveMetros = numeroTirosNueveMetros;
		this.numeroTirosNueveMetrosMetidos = numeroTirosNueveMetrosMetidos;
		this.numeroTirosNueveMetrosFallados = numeroTirosNueveMetrosFallados;
		this.perdidasDeBalon = perdidasDeBalon;
	}
	
	public PrimeraLinea() {
		this.numeroTirosNueveMetros = 0;
		this.numeroTirosNueveMetrosMetidos = 0;
		this.numeroTirosNueveMetrosFallados = 0;
		this.perdidasDeBalon = 0;
	}

	public int getNumeroTirosNueveMetros() {
		return numeroTirosNueveMetros;
	}

	public void setNumeroTirosNueveMetros(int numeroTirosNueveMetros) {
		this.numeroTirosNueveMetros = numeroTirosNueveMetros;
	}

	public int getNumeroTirosNueveMetrosMetidos() {
		return numeroTirosNueveMetrosMetidos;
	}

	public void setNumeroTirosNueveMetrosMetidos(int numeroTirosNueveMetrosMetidos) {
		this.numeroTirosNueveMetrosMetidos = numeroTirosNueveMetrosMetidos;
	}

	public int getNumeroTirosNueveMetrosFallados() {
		return numeroTirosNueveMetrosFallados;
	}

	public void setNumeroTirosNueveMetrosFallados(int numeroTirosNueveMetrosFallados) {
		this.numeroTirosNueveMetrosFallados = numeroTirosNueveMetrosFallados;
	}

	public int getPerdidasDeBalon() {
		return perdidasDeBalon;
	}

	public void setPerdidasDeBalon(int perdidasDeBalon) {
		this.perdidasDeBalon = perdidasDeBalon;
	}

	@Override
	public String toString() {
		return "PrimeraLinea [numeroTirosNueveMetros=" + numeroTirosNueveMetros + ", numeroTirosNueveMetrosMetidos="
				+ numeroTirosNueveMetrosMetidos + ", numeroTirosNueveMetrosFallados=" + numeroTirosNueveMetrosFallados
				+ ", perdidasDeBalon=" + perdidasDeBalon + ", getNumDorsal()=" + getNumDorsal() + ", getPosicion()="
				+ getPosicion() + ", getSeguro()=" + getSeguro() + ", getNombre()=" + getNombre() + ", getApellido1()="
				+ getApellido1() + ", getApellido2()=" + getApellido2() + ", getDni()=" + getDni() + ", getfNac()="
				+ getfNac() + "]";
	}

	
}
