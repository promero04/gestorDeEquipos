package gui;


import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import domain.PrimeraLinea;
import domain.SegundaLinea;


public class ModeloTablaJugadoresSegundaLinea extends DefaultTableModel{
	private List<SegundaLinea> lista;
	private List<String> titulos = (List<String>) Arrays.asList("NOMBRE","APELLIDOS",  "POSICION", "DNI");

	public ModeloTablaJugadoresSegundaLinea(List<SegundaLinea> sl) {
		lista = sl;
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
		SegundaLinea sl = lista.get(row); 
		
		switch(column) {
			
			case 0: return sl.getNombre();
			case 1: return sl.getApellido1() + " " + sl.getApellido2();
			case 2: return sl.getPosicion();
			case 3: return sl.getDni();
			default: return null;
		}
	}
	

}
