package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partido implements Serializable {
	
	private String nombreEquipo;
	private String segundoEntrenador;
	private List<Jugador> lJugadores;
	private Estadisticas estadisticas;
	private Date horaDePartido;
	
	
	public Partido(String nombreEquipo, String segundoEntrenador, Estadisticas estadisticas,
			Date horaDePartido) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.segundoEntrenador = segundoEntrenador;
		this.lJugadores = new ArrayList<Jugador>();
		this.estadisticas = estadisticas;
		this.horaDePartido = horaDePartido;
	}


	public Partido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNombreEquipo() {
		return nombreEquipo;
	}


	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}


	public String getSegundoEntrenador() {
		return segundoEntrenador;
	}


	public void setSegundoEntrenador(String segundoEntrenador) {
		this.segundoEntrenador = segundoEntrenador;
	}


	public List<Jugador> getlJugadores() {
		return lJugadores;
	}
	
	public void addJugadores(Jugador jugador) {
		lJugadores.add(jugador);
	}


	public void setlJugadores(List<Jugador> lJugadores) {
		this.lJugadores = lJugadores;
	}


	public Estadisticas getEstadisticas() {
		return estadisticas;
	}

	
	

	public void addEstaditicas(Estadisticas e) {
		this.estadisticas = e;
	}
	public Date getHoraDePartido() {
		return horaDePartido;
	}


	public void setHoraDePartido(Date horaDePartido) {
		this.horaDePartido = horaDePartido;
	}


	@Override
	public String toString() {
		return "Partido con "+ getNombreEquipo()+ " entrenador "+getSegundoEntrenador()+" el dia "+getHoraDePartido() ;
	}
	
	
	
	
	
	
}
