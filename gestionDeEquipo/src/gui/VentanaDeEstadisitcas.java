package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import domain.Gestor;
import domain.Partido;

import java.awt.GridLayout;
import java.util.List;
import java.awt.BorderLayout;

public class VentanaDeEstadisitcas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblExplicacion;
	private JComboBox<Partido> comboPartidos;
	


	public VentanaDeEstadisitcas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2,1));
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		aniadirBordeAlJPanel("", panel);
		panel.setPreferredSize(new Dimension(anchoP, altoP-500));
		
		JPanel pnlArriba = new JPanel();
		panel.add(pnlArriba);
		pnlArriba.setLayout(new GridLayout(1,2));
		
		JPanel pnlTexto = new JPanel();
		pnlArriba.add(pnlTexto);
		
		Partido p = Gestor.cargarPartidos(Gestor.getNombreFich());
		comboPartidos = new JComboBox<Partido>();
		
		
		comboPartidos.addItem(p);
		
		
		JPanel pnlPartidos = new JPanel();
		
		pnlPartidos.add(comboPartidos);
		pnlArriba.add(pnlPartidos);
		
		
		JPanel pnlAbajo = new JPanel();
		panel.add(pnlAbajo);
		pnlTexto.setLayout(new BorderLayout(0, 0));
		
		lblExplicacion = new JLabel("Aqui podras ver todos los partidos que has tenido como entrenador, selecciona el que quieras consultar");
		lblExplicacion.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 21));
		pnlTexto.add(lblExplicacion);
		
		
	}
	public static void aniadirBordeAlJPanel(String titulo, JPanel panel) {
		LineBorder borde = new LineBorder(Color.BLACK, 7);
		TitledBorder bordeDelTitulo = new TitledBorder(borde, titulo);
		
		bordeDelTitulo.setTitleJustification(TitledBorder.CENTER);
		bordeDelTitulo.setTitleFont(new Font("verdana", Font.BOLD, 20));
		
		panel.setBorder(bordeDelTitulo);
	}

}
