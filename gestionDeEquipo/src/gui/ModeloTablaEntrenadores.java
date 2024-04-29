package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.Entrenador;
import domain.Jugador;


public class ModeloTablaEntrenadores extends DefaultTableModel{
	private List<Entrenador> lista;
	private List<String> titulos = (List<String>) Arrays.asList("NOMBRE","APELLIDOS", "FECHA DE NACIMIENTO", "DNI", "NOMINA", "TITULO");

	public ModeloTablaEntrenadores(List<Entrenador> e) {
		lista = e;
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
		Entrenador e = lista.get(row); 
		switch(column) {
			case 0: return e.getNombre();
			case 1: return e.getApellido1() + " " + e.getApellido2();
			case 2: return e.getfNac();
			case 3: return e.getDni();
			case 4: return e.getNomina();
			case 5: return e.getTitulo();
			default: return null;
		}
	}
	

}
