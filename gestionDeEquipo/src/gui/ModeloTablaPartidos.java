package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.Partido;
import domain.Portero;

public class ModeloTablaPartidos extends DefaultTableModel{
	private List<Partido> lista;
	private List<String> titulos = (List<String>) Arrays.asList( "NOMBRE DE EQUIPO","SEGUNDO ENTRENADOR", "LISTA JUGADORES", "ESTADISTICAS", "HORA DE PARTIDO");

	public ModeloTablaPartidos(List<Partido> p) {
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
		Partido p = lista.get(row); 
		
		switch(column) {
			
			case 0: return p.getNombreEquipo();
			case 1: return p.getSegundoEntrenador();
			case 2: return p.getlJugadores();
			case 3: return p.getEstadisticas();
			case 4: return p.getHoraDePartido();
			
			default: return null;
		}
	}
	

}
