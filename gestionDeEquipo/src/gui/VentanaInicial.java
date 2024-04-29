package gui;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Entrenador;
import domain.Gestor;
import domain.Partido;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;

import java.util.Calendar;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import java.awt.GridLayout;


public class VentanaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelCrearPartido, pnlNombreDeEquipo, pnlImagen;
	private JTextField txtNombreEquipo;
	private JLabel lblNombreEquipo, lblEntrenador, lblIcon;
	private static Partido partido;
	
	public VentanaInicial() {
		
		
		getContentPane().setLayout(new BorderLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JPanel pnlVisualizarEquipo = new JPanel();
		panel.add(pnlVisualizarEquipo);
		
		JButton btnVisualizarEquipo = new JButton("VISUALIZAR EQUIPO");
		pnlVisualizarEquipo.add(btnVisualizarEquipo);
		
		JPanel pnlVisualizarEntrenadores = new JPanel();
		panel.add(pnlVisualizarEntrenadores);
		
		JButton btnVisualizarEntrenadores = new JButton("VISUALIZAR ENTRENADORES");
		pnlVisualizarEntrenadores.add(btnVisualizarEntrenadores);
		
		JPanel pnlNuevoPartido = new JPanel();
		panel.add(pnlNuevoPartido);
		
		JButton btnNuevoPartido = new JButton("NUEVO PARTIDO");
		pnlNuevoPartido.add(btnNuevoPartido);
		
		JPanel pnlVisualizarEstadisticas = new JPanel();
		panel.add(pnlVisualizarEstadisticas);
		
		JButton btnVisualizarEstadisticas = new JButton("VISUALIZAR ESTADISTICAS");
		pnlVisualizarEstadisticas.add(btnVisualizarEstadisticas);
		
		pnlImagen = new JPanel();
		ImageIcon icono = new ImageIcon("imagenes/balonmanobarcelona.jpg"); 
		lblIcon = new JLabel(icono);
		
		pnlImagen.add(lblIcon);
		getContentPane().add(pnlImagen, BorderLayout.CENTER);
		
		btnVisualizarEquipo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new VentanaVisualizarEquipo();
				
			}
		});
		
		btnVisualizarEntrenadores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new VentanaVisualizarEntrenadores();
				
			}
		});
		
		
		
		txtNombreEquipo = new JTextField();
		lblNombreEquipo = new JLabel("ELIGE NOMBRE DE EQUIPO: ");
		lblEntrenador = new JLabel("ELIGE UN SEGUNDO ENTRENADOR: ");
		panelCrearPartido = new JPanel(new GridLayout(2, 2));
		
		
		
		;
		JComboBox<String> comboEntrenador = new JComboBox<>();
		for(Entrenador e : Gestor.listaEntrenadores) {
			comboEntrenador.addItem(e.getNombre() + " Con titulo -> " + e.getTitulo() );
		}
		panelCrearPartido.add(lblNombreEquipo);
		panelCrearPartido.add(txtNombreEquipo);
		panelCrearPartido.add(lblEntrenador);
		panelCrearPartido.add(comboEntrenador);
		
		btnNuevoPartido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(
	                    null,
	                    panelCrearPartido,
	                    " ",
	                    JOptionPane.PLAIN_MESSAGE);
				String nombreDelEquipo = txtNombreEquipo.getText();
				String entrenador = (String) comboEntrenador.getSelectedItem();
				partido = new Partido(nombreDelEquipo, entrenador, null, Calendar.getInstance().getTime());
				new VentanaDePartido();
				dispose();
				
			}
		});
		btnVisualizarEstadisticas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaDeEstadisitcas();
			}
		});
		
		
		
	}

	public static Partido getPartido() {
		return partido;
	}

	

	
	
}
