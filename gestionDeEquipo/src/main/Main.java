package main;



import java.util.List;

import domain.Gestor;
import domain.Partido;
import gui.VentanaDePartido;
import gui.VentanaInicial;


public class Main {
	private static String nombreFich = "partidos.dat";
	private static List<Partido> listaDePartidos = Gestor.cargarPartidos(nombreFich);

	
	public static void main(String[] args) {
		Gestor.listaDelCsvJugadores();
		Gestor.listaDelCsvEntrenadores();
		new VentanaInicial();
	}
	
	public static List<Partido> getListaDePartidos() {
		return listaDePartidos;
	}

	

}
