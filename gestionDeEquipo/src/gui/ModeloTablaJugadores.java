package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.Jugador;


public class ModeloTablaJugadores extends DefaultTableModel{
	private List<Jugador> lista;
	private List<String> titulos = (List<String>) Arrays.asList("NOMBRE","APELLIDOS", "FECHA DE NACIMIENTO", "DNI", "POSICION");

	public ModeloTablaJugadores(List<Jugador> j) {
		lista = j;
	}
	
	@Override
	public int getRowCount() {
		if(lista==null)
			return 0;
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return titulos.size();
	}

	@Override
	public String getColumnName(int column) {
		return titulos.get(column);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		Jugador j = lista.get(row); 
		switch(column) {
			case 0: return j.getNombre();
			case 1: return j.getApellido1() + " " + j.getApellido2();
			case 2: return j.getfNac();
			case 3: return j.getDni();
			case 4: return j.getPosicion();
			default: return null;
		}
	}
	

}
