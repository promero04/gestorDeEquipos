package gui;


import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import domain.PrimeraLinea;


public class ModeloTablaJugadoresPrimeraLinea extends DefaultTableModel{
	private List<PrimeraLinea> lista;
	private List<String> titulos = (List<String>) Arrays.asList("NOMBRE","APELLIDOS",  "POSICION", "DNI");

	public ModeloTablaJugadoresPrimeraLinea(List<PrimeraLinea> pl) {
		lista = pl;
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
		PrimeraLinea pl = lista.get(row); 
		
		switch(column) {
			
			case 0: return pl.getNombre();
			case 1: return pl.getApellido1() + " " + pl.getApellido2();
			case 2: return pl.getPosicion();
			case 3: return pl.getDni();
			default: return null;
		}
	}
	

}
