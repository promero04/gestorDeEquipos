package domain;

import java.io.Serializable;

public class Estadisticas implements Serializable{
	
	
	private int nTotalDeGolesAFavor;
	private int nTotalDeGolesEnContra;
	private int nDeTirosFallidos;
	private int nDePenaltisMetidos;
	private int nDePenaltisfallados;
	private int nDeGolesSeisMetros;
	private int nDeGolesNueveMetros;
	private int nDeExpulsiones;
	private int nDeAmarillas;
	private int nDeParadas;
	
	public int getnTotalDeGolesAFavor() {
		return nTotalDeGolesAFavor;
	}
	public void setnTotalDeGolesAFavor(int nTotalDeGolesAFavor) {
		this.nTotalDeGolesAFavor = nTotalDeGolesAFavor;
	}
	public int getnTotalDeGolesEnContra() {
		return nTotalDeGolesEnContra;
	}
	public void setnTotalDeGolesEnContra(int nTotalDeGolesEnContra) {
		this.nTotalDeGolesEnContra = nTotalDeGolesEnContra;
	}
	public int getnDeTirosFallidos() {
		return nDeTirosFallidos;
	}
	public void setnDeTirosFallidos(int nDeTirosFallidos) {
		this.nDeTirosFallidos = nDeTirosFallidos;
	}
	public int getnDePenaltisMetidos() {
		return nDePenaltisMetidos;
	}
	public void setnDePenaltisMetidos(int nDePenaltisMetidos) {
		this.nDePenaltisMetidos = nDePenaltisMetidos;
	}
	public int getnDePenaltisfallados() {
		return nDePenaltisfallados;
	}
	public void setnDePenaltisfallados(int nDePenaltisfallados) {
		this.nDePenaltisfallados = nDePenaltisfallados;
	}
	public int getnDeGolesSeisMetros() {
		return nDeGolesSeisMetros;
	}
	public void setnDeGolesSeisMetros(int nDeGolesSeisMetros) {
		this.nDeGolesSeisMetros = nDeGolesSeisMetros;
	}
	public int getnDeGolesNueveMetros() {
		return nDeGolesNueveMetros;
	}
	public void setnDeGolesNueveMetros(int nDeGolesNueveMetros) {
		this.nDeGolesNueveMetros = nDeGolesNueveMetros;
	}
	public int getnDeExpulsiones() {
		return nDeExpulsiones;
	}
	public void setnDeExpulsiones(int nDeExpulsiones) {
		this.nDeExpulsiones = nDeExpulsiones;
	}
	public int getnDeAmarillas() {
		return nDeAmarillas;
	}
	public void setnDeAmarillas(int nDeAmarillas) {
		this.nDeAmarillas = nDeAmarillas;
	}
	public int getnDeParadas() {
		return nDeParadas;
	}
	public void setnDeParadas(int nDeParadas) {
		this.nDeParadas = nDeParadas;
	}
	public Estadisticas(int nTotalDeGolesAFavor, int nTotalDeGolesEnContra, int nDeTirosFallidos,
			int nDePenaltisMetidos, int nDePenaltisfallados, int nDeGolesSeisMetros, int nDeGolesNueveMetros,
			int nDeExpulsiones, int nDeAmarillas, int nDeParadas) {
		super();
		this.nTotalDeGolesAFavor = nTotalDeGolesAFavor;
		this.nTotalDeGolesEnContra = nTotalDeGolesEnContra;
		this.nDeTirosFallidos = nDeTirosFallidos;
		this.nDePenaltisMetidos = nDePenaltisMetidos;
		this.nDePenaltisfallados = nDePenaltisfallados;
		this.nDeGolesSeisMetros = nDeGolesSeisMetros;
		this.nDeGolesNueveMetros = nDeGolesNueveMetros;
		this.nDeExpulsiones = nDeExpulsiones;
		this.nDeAmarillas = nDeAmarillas;
		this.nDeParadas = nDeParadas;
	}
	public Estadisticas() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GF: "+nTotalDeGolesAFavor+ " GC: " + nTotalDeGolesEnContra +" TF: "+ nDeTirosFallidos +" PM: "+ nDePenaltisMetidos +" PF: "+nDePenaltisfallados 
				+" G6: "+nDeGolesSeisMetros +" G9"+ nDeGolesNueveMetros +" NE: "+nDeExpulsiones + " NA: " + nDeAmarillas + " NP: "+ nDeParadas;
				}
	
	
	
	
	

}
