package gui;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import domain.Gestor;
import domain.Jugador;
import domain.Posicion;

import java.awt.BorderLayout;

import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import java.util.Date;


import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VentanaVisualizarEquipo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	private JTable table;
	private ModeloTablaJugadores modeloTablaJugadores;
	private JScrollPane scrollTabla;
	
	
	private JPanel panel, panelIzqDeVisualizar, panelIzqDeVisualizarFoto;
	private JButton btnVolver;
	private JPanel panel_1;
	private JButton btnAniadirJugador;
	private JButton btnNewButton_1;
	private JPanel panel_2;
	private JLabel lblNombre, lblApellidos, lblDni, lblFechaNac, lblPosicion, lblImagen;

	
	public VentanaVisualizarEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
//		Comparator c = new Comparator<Jugador>() {
//
//			@Override
//			public int compare(Jugador o1, Jugador o2) {
//				
//				Long fecha1 = Long.parseLong(o1.getfNac().toString());
//				Long fecha2 = Long.parseLong(o2.getfNac().toString());
//					
//				
//				return (int) (fecha1 - fecha2);
//			}
//		};
//		lj.sort(c);
		
		
		modeloTablaJugadores = new ModeloTablaJugadores(Gestor.listaJugadores);
		table = new JTable(modeloTablaJugadores);
		table.setDefaultRenderer(Object.class, new RendererTablaDeJugadores());

		panel_2 = new JPanel();
		
		panelIzqDeVisualizar = new JPanel(new GridLayout(8, 1));
		panelIzqDeVisualizarFoto = new JPanel();
		panel_2.setLayout(new BorderLayout());
		panel_2.add(panelIzqDeVisualizarFoto, BorderLayout.WEST);
		panel_2.add(panelIzqDeVisualizar, BorderLayout.EAST);	
		lblNombre = new JLabel();
		lblApellidos = new JLabel();
		lblDni = new JLabel();
		lblFechaNac = new JLabel();
		lblPosicion = new JLabel();
		
		ImageIcon icono = new ImageIcon("imagenes/jugador.png");
		lblImagen = new JLabel(icono);
		
		panelIzqDeVisualizarFoto.add(lblImagen);
		panelIzqDeVisualizar.add(lblNombre);
		panelIzqDeVisualizar.add(lblApellidos);
		panelIzqDeVisualizar.add(lblDni);
		panelIzqDeVisualizar.add(lblFechaNac);
		panelIzqDeVisualizar.add(lblPosicion);
		
		
		
		
		
		
		table.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int fila = table.rowAtPoint(p);
				String nombre = (String) table.getModel().getValueAt(fila, 0);
				String apellidos = (String) table.getModel().getValueAt(fila, 1);
				String [] partes = apellidos.split(" ");
				Date fNac =  (Date) table.getModel().getValueAt(fila, 2);
				String dni = (String) table.getModel().getValueAt(fila, 3);
				Double seguro = 140.2;
				Posicion pos = (Posicion) table.getModel().getValueAt(fila, 4);
				
				
				
				Jugador jugador = new Jugador(nombre, partes[0], partes[1], dni, fNac, 0, seguro, pos); 
				
				lblNombre.setText("NOMBRE: " + jugador.getNombre());
				
				lblApellidos.setText("APELLIDOS: " + jugador.getApellido1() + " " + jugador.getApellido2());
				
				lblDni.setText("DNI: " + jugador.getDni());
				
				lblFechaNac.setText("FECHA DE NACIMIENTO: " + jugador.getfNac().toString());
				
				lblPosicion.setText("POSICION: " + jugador.getPosicion());
				
				
				
				
				
				
				JOptionPane.showMessageDialog(
		                    null,
		                    panel_2,
		                    " ",
		                    JOptionPane.PLAIN_MESSAGE);
		        
				}
			});
				
	
		
		
		
		scrollTabla = new JScrollPane(table);
		contentPane.add(scrollTabla, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnVolver = new JButton("VOLVER");
		panel.add(btnVolver);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		btnAniadirJugador = new JButton("AÑADIR JUGADOR");
		panel_1.add(btnAniadirJugador);
		
		btnNewButton_1 = new JButton("ELIMINAR JUGADOR");
		panel_1.add(btnNewButton_1);
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicial();
				
			}
		});
		
		
		
		
	}

}
