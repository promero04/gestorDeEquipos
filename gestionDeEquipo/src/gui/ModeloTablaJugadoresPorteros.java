package gui;


import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import domain.Portero;
import domain.PrimeraLinea;
import domain.SegundaLinea;


public class ModeloTablaJugadoresPorteros extends DefaultTableModel{
	private List<Portero> lista;
	private List<String> titulos = (List<String>) Arrays.asList( "NOMBRE","APELLIDOS", "POSICION", "DNI");

	public ModeloTablaJugadoresPorteros(List<Portero> p) {
		lista = p;
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
		Portero p = lista.get(row); 
		
		switch(column) {
			
			case 0: return p.getNombre();
			case 1: return p.getApellido1() + " " + p.getApellido2();
			case 2: return p.getPosicion();
			case 3: return p.getDni();
			
			default: return null;
		}
	}
	

}
