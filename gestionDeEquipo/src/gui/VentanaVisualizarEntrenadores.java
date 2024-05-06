package gui;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import domain.Entrenador;
import domain.Gestor;
import domain.Titulo;


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

public class VentanaVisualizarEntrenadores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	private JTable table;
	private ModeloTablaEntrenadores modeloTablaEntrenadores;
	private JScrollPane scrollTabla;
	private JPanel panel, panelIzqDeVisualizar, panelIzqDeVisualizarFoto;
	private JButton btnVolver;
	private JPanel pnlBotonera;
	private JButton btnAniadirJugador;
	private JButton btnBorrarEntrenador;
	private JPanel panel_2, panelAniadirJugador;
	private JLabel lblNombre, lblApellidos, lblDni, lblFechaNac, lblNomina, lblSeguro, lblTitulo, lblImagen;
	
	private int fila = 0;
	
	public VentanaVisualizarEntrenadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout());
		
		
		

		
		
		modeloTablaEntrenadores = new ModeloTablaEntrenadores(Gestor.listaEntrenadores);
		table = new JTable(modeloTablaEntrenadores);
		//table.setDefaultRenderer(Object.class, new RendererTablaDeJugadores());
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
		lblNomina = new JLabel();
		lblSeguro = new JLabel();
		lblTitulo = new JLabel();
		ImageIcon icono = new ImageIcon("imagenes/entrenador.png");
		lblImagen = new JLabel(icono);
		
		panelIzqDeVisualizarFoto.add(lblImagen);
		panelIzqDeVisualizar.add(lblNombre);
		panelIzqDeVisualizar.add(lblApellidos);
		panelIzqDeVisualizar.add(lblDni);
		panelIzqDeVisualizar.add(lblFechaNac);
		panelIzqDeVisualizar.add(lblNomina);
		panelIzqDeVisualizar.add(lblSeguro);
		panelIzqDeVisualizar.add(lblTitulo);
		
		
		table.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				fila = table.rowAtPoint(p);
				String nombre = (String) table.getModel().getValueAt(fila, 0);
				String apellidos = (String) table.getModel().getValueAt(fila, 1);
				String [] partes = apellidos.split(" ");
				
				Date fNac =  (Date) table.getModel().getValueAt(fila, 2);
				
				String dni = (String) table.getModel().getValueAt(fila, 3);
				Double nomina = (Double) table.getModel().getValueAt(fila, 4); 
				Double seguro = 95.6; 
				Titulo titulo = (Titulo) table.getModel().getValueAt(fila, 5);
				
				Entrenador en = new Entrenador(nombre, partes[0], partes[1], dni, fNac, nomina, seguro, titulo);
				
				
				
				lblNombre.setText("NOMBRE: " + en.getNombre());
				
				lblApellidos.setText("APELLIDOS: " + en.getApellido1() + " " + en.getApellido2());
				
				lblDni.setText("DNI: " + en.getDni());
				
				lblFechaNac.setText("FECHA DE NACIMIENTO: " + en.getfNac().toString());
				
				lblNomina.setText("NOMINA: " + en.getNomina().toString());
				
				lblSeguro.setText("SEGURO: " + en.getSeguro().toString());
				
				lblTitulo.setText("TITULO: " + en.getTitulo().toString());
				
				
				
				
				
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
		
		pnlBotonera = new JPanel();
		contentPane.add(pnlBotonera, BorderLayout.CENTER);
		
		
		
		
		
		panelAniadirJugador = new JPanel();
		
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicial();
				
			}
		});
		
	}

}
