package gui;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RendererTablaDeJugadores implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel l = new JLabel(value.toString());
		l.setOpaque(true);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		if(column==2) {
			try {
				sdf.parse(value.toString());
			} catch (ParseException e) {
				new Date(0);
			}
			
		}
		
		return l;
	}

}
