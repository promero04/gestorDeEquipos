package domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import gui.VentanaDePartido;

public class Gestor {
	
	public static List<Jugador> listaJugadores = new ArrayList<>();
	public static List<Entrenador> listaEntrenadores = new ArrayList<>();
	private static String nombreFich = "partidos.dat";
	
	public static List<Jugador> listaDelCsvJugadores(){
		
		try {
			Scanner sc = new Scanner(new FileReader("ficheros/jugadoresCoras.csv"));
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				String [] partes = linea.split(";");
				String pos = partes[5];
				if(!pos.equals("EN")) {
					String apellido1 = partes[0];
					String apellido2 = partes[1];
					String nombre = partes[2];
					String fecha = partes[3];
					SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
					Date fechaEnDate;
					
						try {
							fechaEnDate = sdf.parse(fecha);
						} catch (ParseException e) {
							fechaEnDate = new Date();
						}
					
					String dni = partes[4];
					int dorsal = Integer.parseInt(partes[6]);
					Double seguro = 140.2;
					Posicion p = null;
					if(pos.equals("LI")) {
					 p = Posicion.LATERAL_IZQUIERDO;
					}if(pos.equals("LD")) {
						 p = Posicion.LATERAL_DERECHO;
					}if(pos.equals("CE")) {
						 p = Posicion.CENTRAL;
					}if(pos.equals("ED")) {
						 p = Posicion.EXTREMO_DERECHO;
					}if(pos.equals("EI")) {
						 p = Posicion.EXTREMO_IZQUIERDO;
					}if(pos.equals("PV")) {
						 p = Posicion.PIVOTE;
					}if(pos.equals("PO")) {
						 p = Posicion.PORTERO;
					}
					Jugador j = new Jugador(nombre, apellido1, apellido2, dni, fechaEnDate, dorsal, seguro, p);
					listaJugadores.add(j);
					
				}
				}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaJugadores;
		
	}
	
	
	
	public static List<Entrenador> listaDelCsvEntrenadores(){
		
		try {
			Scanner sc = new Scanner(new FileReader("ficheros/jugadoresCoras.csv"));
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				String [] partes = linea.split(";");
				String pos = partes[5];
				if(pos.equals("EN")) {
				String apellido1 = partes[0];
				String apellido2 = partes[1];
				String nombre = partes[2];
				String fecha = partes[3];
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				
				Date fechaEnDate;
				
				try {
					fechaEnDate = sdf.parse(fecha);
				} catch (ParseException e) {
					fechaEnDate = new Date();
				}
				String dni = partes[4];
				
				String tituloEnStr = partes[6];
				Titulo titulo = Titulo.valueOf(tituloEnStr);
				
				Double nomina = 0.0;
				
				if(tituloEnStr.equals("MONITOR")) {
					nomina = 75.5;
				}if(tituloEnStr.equals("BASE")) {
					nomina = 115.7;
				}if(tituloEnStr.equals("NACIONAL")) {
					nomina = 147.5;
				}if(tituloEnStr.equals("REGIONAL")) {
					nomina = 200.0;
				}if(tituloEnStr.equals("PROFESIONAL")) {
					nomina = 350.5;
				}
				Double seguro = 95.6;
				
				Entrenador e = new Entrenador(nombre, apellido1, apellido2, dni, fechaEnDate, nomina, seguro, titulo);
				listaEntrenadores.add(e);
				}
				}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return listaEntrenadores;
	}
	
	public static List<Portero> devuelveListaDePorteros(){
		List<Portero> listaPorteros = new ArrayList<>();
		for(Jugador jugadorP: listaJugadores) {
			if(jugadorP.getPosicion().toString().equals(Posicion.PORTERO.toString())) {
				Portero portero = new Portero(jugadorP.getNombre(), jugadorP.getApellido1(), jugadorP.getApellido2(), jugadorP.getDni(), jugadorP.getfNac(), jugadorP.getNumDorsal(), jugadorP.getSeguro(), jugadorP.getPosicion(), 0, 0, 0, 0);
				listaPorteros.add(portero);
			}
		}
		
		return listaPorteros;
		
	}
	
	
	public static List<PrimeraLinea> devuelveListaDePrimerasLineas(){
		List<PrimeraLinea> listaPrimeraLinea = new ArrayList<>();
		for(Jugador jugadorP: listaJugadores) {
			if(jugadorP.getPosicion().toString().equals(Posicion.LATERAL_IZQUIERDO.toString())||jugadorP.getPosicion().toString().equals(Posicion.LATERAL_DERECHO.toString())||jugadorP.getPosicion().toString().equals(Posicion.CENTRAL.toString())) {
				PrimeraLinea primerLinea = new PrimeraLinea(jugadorP.getNombre(), jugadorP.getApellido1(), jugadorP.getApellido2(), jugadorP.getDni(), jugadorP.getfNac(), jugadorP.getNumDorsal(), jugadorP.getSeguro(), jugadorP.getPosicion(), 0, 0, 0, 0);
				listaPrimeraLinea.add(primerLinea);
			}
		}
		
		return listaPrimeraLinea;
	}
	
	public static List<SegundaLinea> devuelveListaDeSegundasLineas(){
		List<SegundaLinea> listaSegundaLinea = new ArrayList<>();
		for(Jugador jugadorP: listaJugadores) {
			if(jugadorP.getPosicion().toString().equals(Posicion.EXTREMO_DERECHO.toString())||jugadorP.getPosicion().toString().equals(Posicion.EXTREMO_IZQUIERDO.toString())||jugadorP.getPosicion().toString().equals(Posicion.PIVOTE.toString())) {
				SegundaLinea segundaLinea = new SegundaLinea(jugadorP.getNombre(), jugadorP.getApellido1(), jugadorP.getApellido2(), jugadorP.getDni(), jugadorP.getfNac(), jugadorP.getNumDorsal(), jugadorP.getSeguro(), jugadorP.getPosicion(), 0, 0, 0, 0);
				listaSegundaLinea.add(segundaLinea);
			}
		}
		
		return listaSegundaLinea;
	}
	
	public static void guardarPartido(List<Partido> p,  String fichero) {
		try {
			FileOutputStream fos = new FileOutputStream(fichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(p);
			
			oos.close();
			fos.close();
			System.out.println("Guardado con exito");
		} catch (IOException e) {
			System.err.println("Error guardando el partido en " + fichero);
			e.printStackTrace();
		}
	}
	public static List<Partido> cargarPartidos(String fichero) {
		List<Partido> p = new ArrayList<Partido>();
		try {
			FileInputStream fis = new FileInputStream(fichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			p =  (List<Partido>) ois.readObject();
			
			
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error leyendo pedidos en " + fichero);
		}
		return p;
	
}



	public static String getNombreFich() {
		return nombreFich;
	}



	public static void setNombreFich(String nombreFich) {
		Gestor.nombreFich = nombreFich;
	}
	}
