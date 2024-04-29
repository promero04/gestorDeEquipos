package domain;

import java.util.Date;

public class Portero extends Jugador{
	
	private int numeroDeParadas;
	private int pasesDeContraataque;
	private int pasesDeContraataqueAcertados;
	private int pasesDeContraataqueFallidos;
	
	public Portero(String nombre, String apellido1, String apellido2, String dni, Date fNac, int numDorsal,
			Double seguro, Posicion posicion, int numeroDeParadas, int pasesDeContraataque,
			int pasesDeContraataqueAcertados, int pasesDeContraataqueFallidos) {
		super(nombre, apellido1, apellido2, dni, fNac, numDorsal, seguro, posicion);
		this.numeroDeParadas = numeroDeParadas;
		this.pasesDeContraataque = pasesDeContraataque;
		this.pasesDeContraataqueAcertados = pasesDeContraataqueAcertados;
		this.pasesDeContraataqueFallidos = pasesDeContraataqueFallidos;
	}
	
	public Portero() {
		this.numeroDeParadas = 0;
		this.pasesDeContraataque = 0;
		this.pasesDeContraataqueAcertados = 0;
		this.pasesDeContraataqueFallidos = 0;
	}

	public int getNumeroDeParadas() {
		return numeroDeParadas;
	}

	public void setNumeroDeParadas(int numeroDeParadas) {
		this.numeroDeParadas = numeroDeParadas;
	}

	public int getPasesDeContraataque() {
		return pasesDeContraataque;
	}

	public void setPasesDeContraataque(int pasesDeContraataque) {
		this.pasesDeContraataque = pasesDeContraataque;
	}

	public int getPasesDeContraataqueAcertados() {
		return pasesDeContraataqueAcertados;
	}

	public void setPasesDeContraataqueAcertados(int pasesDeContraataqueAcertados) {
		this.pasesDeContraataqueAcertados = pasesDeContraataqueAcertados;
	}

	public int getPasesDeContraataqueFallidos() {
		return pasesDeContraataqueFallidos;
	}

	public void setPasesDeContraataqueFallidos(int pasesDeContraataqueFallidos) {
		this.pasesDeContraataqueFallidos = pasesDeContraataqueFallidos;
	}

	@Override
	public String toString() {
		return "Portero [numeroDeParadas=" + numeroDeParadas + ", pasesDeContraataque=" + pasesDeContraataque
				+ ", pasesDeContraataqueAcertados=" + pasesDeContraataqueAcertados + ", pasesDeContraataqueFallidos="
				+ pasesDeContraataqueFallidos + ", getNumDorsal()=" + getNumDorsal() + ", getPosicion()="
				+ getPosicion() + ", getSeguro()=" + getSeguro() + ", getNombre()=" + getNombre() + ", getApellido1()="
				+ getApellido1() + ", getApellido2()=" + getApellido2() + ", getDni()=" + getDni() + ", getfNac()="
				+ getfNac() + "]";
	}

	

}
