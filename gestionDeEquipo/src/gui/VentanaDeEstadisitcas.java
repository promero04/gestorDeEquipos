package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import domain.Estadisticas;
import domain.Gestor;
import domain.Jugador;
import domain.Partido;
import main.Main;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.awt.BorderLayout;

public class VentanaDeEstadisitcas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnlBotones;
	private JButton btnSalir, btnVaciar;
	private JTable tablaPartidos;
	private ModeloTablaPartidos modeloTablaPartidos;
	private JScrollPane scrollTabla;
	private int fila = 0;
	private JLabel lblNombreEquipo, lblNombreEntrenador, lblListaJugadores, lblEstadisticas, lblHoraDePartido;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	private static String jugadoresStr = "";
	
	public VentanaDeEstadisitcas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3,1));
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		
		panel.setPreferredSize(new Dimension(anchoP, altoP-300));
		
		
		
		
		modeloTablaPartidos = new ModeloTablaPartidos(Gestor.cargarPartidos(Gestor.getNombreFich()));
		tablaPartidos = new JTable(modeloTablaPartidos);
		scrollTabla = new JScrollPane(tablaPartidos);
		
		panel.add(scrollTabla);
		
		
		JPanel pnlAbajo = new JPanel();
		pnlAbajo.setLayout(new GridLayout(1, 5));
		panel.add(pnlAbajo);
		
		lblNombreEquipo = new JLabel();
		lblNombreEntrenador = new JLabel();
		lblEstadisticas = new JLabel();
		lblListaJugadores = new JLabel();
		lblHoraDePartido = new JLabel();
		
		aniadirBordeAlJPanel("ESTADISTICAS", lblEstadisticas);
		aniadirBordeAlJPanel("SEGUNDO ENTRENADOR", lblNombreEntrenador);
		aniadirBordeAlJPanel("LISTA JUGADORES", lblListaJugadores);
		aniadirBordeAlJPanel("HORA DE PARTIDO", lblHoraDePartido);
		aniadirBordeAlJPanel("NOMBRE DE EQUIPO", lblNombreEquipo);
		
		
		
		pnlAbajo.add(lblNombreEquipo);
		pnlAbajo.add(lblNombreEntrenador);
		pnlAbajo.add(lblListaJugadores);
		pnlAbajo.add(lblEstadisticas);
		pnlAbajo.add(lblHoraDePartido);
		
		tablaPartidos.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				fila = tablaPartidos.rowAtPoint(p);
				String nombreDeEquipo = (String) tablaPartidos.getModel().getValueAt(fila, 0);
				String segundoEntrenador = (String) tablaPartidos.getModel().getValueAt(fila, 1);
				List<Jugador> lJugadores = (List<Jugador>) tablaPartidos.getModel().getValueAt(fila, 2);
				Estadisticas estadisticas = (Estadisticas) tablaPartidos.getModel().getValueAt(fila, 3);
				Date horaDePartido = (Date) tablaPartidos.getModel().getValueAt(fila, 4);
				
				String estadisticasStr = String.format("<html>GF: %s <br> GC: %s <br> TF: %s <br> PM: %s <br> PF: %s <br> G6: %s <br> G9: %s <br> NE: %s <br> NA: %s <br> NP: %s</html>", estadisticas.getnTotalDeGolesAFavor(), estadisticas.getnTotalDeGolesEnContra(), estadisticas.getnDeTirosFallidos(), estadisticas.getnDePenaltisMetidos(), estadisticas.getnDePenaltisfallados(), estadisticas.getnDeGolesSeisMetros(), estadisticas.getnDeGolesNueveMetros(), estadisticas.getnDeExpulsiones(),estadisticas.getnDeAmarillas(), estadisticas.getnDeParadas());
				
				
				
				
					
					
				
			
				
				lblNombreEquipo.setText(nombreDeEquipo);
				lblNombreEntrenador.setText(segundoEntrenador);
				lblListaJugadores.setText(lJugadores.toString());
				lblEstadisticas.setText(estadisticasStr);
				lblHoraDePartido.setText(sdf.format(horaDePartido));
				}
		});
				
		pnlBotones = new JPanel();
		panel.add(pnlBotones);
		
		
		btnSalir = new JButton("SALIR");
		btnVaciar = new JButton("BORRAR BASE DE DATOS");
		pnlBotones.add(btnVaciar);
		
		pnlBotones.add(btnSalir);
		
		
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				
			}
		});
		
		btnVaciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.getListaDePartidos().clear();
				Gestor.guardarPartido(Main.getListaDePartidos(), Gestor.getNombreFich());
				dispose();
				new VentanaDeEstadisitcas();
			}
		});
	}
	public static void aniadirBordeAlJPanel(String titulo, JLabel label) {
		LineBorder borde = new LineBorder(Color.BLUE, 2);
		TitledBorder bordeDelTitulo = new TitledBorder(borde, titulo);
		
		bordeDelTitulo.setTitleJustification(TitledBorder.CENTER);
		bordeDelTitulo.setTitleFont(new Font("verdana", Font.BOLD, 20));
		
		label.setBorder(bordeDelTitulo);
	}

}
