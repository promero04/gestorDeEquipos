package domain;

import java.util.Date;

public class SegundaLinea extends Jugador{
	
	
	private int numeroDeContrataques;
	private int numeroDeContrataquesMetidos;
	private int numeroDeContrataquesFallados;
	private int perdidasDeBalon;
	
	
	public SegundaLinea(String nombre, String apellido1, String apellido2, String dni, Date fNac, int numDorsal,
			Double seguro, Posicion posicion, int numeroDeContrataques, int numeroDeContrataquesMetidos,
			int numeroDeContrataquesFallados, int perdidasDeBalon) {
		super(nombre, apellido1, apellido2, dni, fNac, numDorsal, seguro, posicion);
		this.numeroDeContrataques = numeroDeContrataques;
		this.numeroDeContrataquesMetidos = numeroDeContrataquesMetidos;
		this.numeroDeContrataquesFallados = numeroDeContrataquesFallados;
		this.perdidasDeBalon = perdidasDeBalon;
	}
	
	public SegundaLinea() {
		this.numeroDeContrataques = 0;
		this.numeroDeContrataquesMetidos = 0;
		this.numeroDeContrataquesFallados = 0;
		this.perdidasDeBalon = 0;
	}

	public int getNumeroDeContrataques() {
		return numeroDeContrataques;
	}

	public void setNumeroDeContrataques(int numeroDeContrataques) {
		this.numeroDeContrataques = numeroDeContrataques;
	}

	public int getNumeroDeContrataquesMetidos() {
		return numeroDeContrataquesMetidos;
	}

	public void setNumeroDeContrataquesMetidos(int numeroDeContrataquesMetidos) {
		this.numeroDeContrataquesMetidos = numeroDeContrataquesMetidos;
	}

	public int getNumeroDeContrataquesFallados() {
		return numeroDeContrataquesFallados;
	}

	public void setNumeroDeContrataquesFallados(int numeroDeContrataquesFallados) {
		this.numeroDeContrataquesFallados = numeroDeContrataquesFallados;
	}

	public int getPerdidasDeBalon() {
		return perdidasDeBalon;
	}

	public void setPerdidasDeBalon(int perdidasDeBalon) {
		this.perdidasDeBalon = perdidasDeBalon;
	}

	@Override
	public String toString() {
		return "SegundaLinea [numeroDeContrataques=" + numeroDeContrataques + ", numeroDeContrataquesMetidos="
				+ numeroDeContrataquesMetidos + ", numeroDeContrataquesFallados=" + numeroDeContrataquesFallados
				+ ", perdidasDeBalon=" + perdidasDeBalon + ", getNumDorsal()=" + getNumDorsal() + ", getPosicion()="
				+ getPosicion() + ", getSeguro()=" + getSeguro() + ", getNombre()=" + getNombre() + ", getApellido1()="
				+ getApellido1() + ", getApellido2()=" + getApellido2() + ", getDni()=" + getDni() + ", getfNac()="
				+ getfNac() + "]";
	}

	
}
