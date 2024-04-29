package main;



import domain.Gestor;
import gui.VentanaInicial;


public class Main {
	
	
	public static void main(String[] args) {
		Gestor.listaDelCsvJugadores();
		Gestor.listaDelCsvEntrenadores();
		new VentanaInicial();
	}

}
