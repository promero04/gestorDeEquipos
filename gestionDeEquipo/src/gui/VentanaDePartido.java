package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import domain.Estadisticas;
import domain.Gestor;
import domain.Jugador;
import domain.Partido;
import domain.Portero;
import main.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JCheckBox;

public class VentanaDePartido extends JFrame {

	private static final long serialVersionUID = 1L;
	private static int contadorLocal = 0;
	private static int contadorVisitante = 0;
	private JPanel contentPane;
	

	private int nDeTirosFallidos;
	private int nDePenaltisMetidos;
	private int nDePenaltisfallados;
	private int nDeGolesSeisMetros;
	private int nDeGolesNueveMetros;
	private int nDeExpulsiones;
	private int nDeAmarillas;
	private int nDeParadas;

	private JTable tableConvocados;
	private JPanel pnlCrearEstadisticas, pnlTablaConvocados, pnlCentro, pnlBtnBorrar, pnlBtnExportar;
	private JLabel lblInfo;
	private JButton btnBorrar, btnExportar;

	private ModeloTablaJugadoresPorteros modeloTablaJugadoresPorteros;
	private ModeloTablaJugadoresSegundaLinea modeloTablaJugadoresSegundaLinea;
	private ModeloTablaJugadoresPrimeraLinea modeloTablaJugadoresPrimeraLinea;
	private JScrollPane scrollTablaConvocados;
	
	
	private JCheckBox chckbxPrimerasLineas, chckbxSegundasLineas, chckbxPortero;

	private ModeloListajugadores<Jugador> modeloListaJugadores;
	private JList<Jugador> listaJugadores;
	private JScrollPane scrollListaJugadores;

	List<Jugador> listaJugadoresConvocados = new ArrayList<>();
	
	
	int fila = 0;
	int fila2 = 0;
	int numJugadoresConvocados = 0;

	/**
	 * Create the frame.
	 */
	public VentanaDePartido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		
		Partido p = VentanaInicial.getPartido();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String info = p.getNombreEquipo() + "\n" + " ha seleccionado como segundo entrenador ha "
				+ p.getSegundoEntrenador() + "\n" + " y el partido se disputo el dia " + sdf.format(p.getHoraDePartido());

		JMenuItem mntmNewMenuItem = new JMenuItem(info);
		menuBar.add(mntmNewMenuItem);
		
		JPanel panel_1 = new JPanel();
		menuBar.add(panel_1);
				
		JLabel lblConvocados = new JLabel("LLevas " + numJugadoresConvocados + " de 16 jugadores convocados");
		panel_1.add(lblConvocados);

		

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(3, 1));

		JPanel pnlAbajo = new JPanel();
		contentPane.add(pnlAbajo, BorderLayout.SOUTH);

		JPanel pnlBtnVolver = new JPanel();
		pnlAbajo.add(pnlBtnVolver);

		JButton btnNewButton_2 = new JButton("VOLVER");
		pnlBtnVolver.add(btnNewButton_2);

		JPanel pnlSeleccionTotal = new JPanel();
		contentPane.add(pnlSeleccionTotal, BorderLayout.CENTER);
		pnlSeleccionTotal.setLayout(new BorderLayout(0, 0));

		JPanel pnlCheckBox = new JPanel();
		pnlSeleccionTotal.add(pnlCheckBox, BorderLayout.NORTH);

		chckbxPrimerasLineas = new JCheckBox("PRIMERAS LINEAS");
		pnlCheckBox.add(chckbxPrimerasLineas);

		chckbxSegundasLineas = new JCheckBox("SEGUNDAS LINEAS");
		pnlCheckBox.add(chckbxSegundasLineas);

		chckbxPortero = new JCheckBox("PORTEROS");
		pnlCheckBox.add(chckbxPortero);

		JPanel pnlLabelInfo = new JPanel();
		pnlCheckBox.add(pnlLabelInfo);

		lblInfo = new JLabel("Para seleccionar a los jugadores presione A (añadir) encima en la tabla");
		pnlLabelInfo.add(lblInfo);

		pnlCentro = new JPanel();
		pnlSeleccionTotal.add(pnlCentro, BorderLayout.CENTER);

		pnlTablaConvocados = new JPanel(new GridLayout(2, 2));
		pnlTablaConvocados.setVisible(true);
		pnlCentro.add(pnlTablaConvocados);

		pnlCrearEstadisticas = new JPanel();
		pnlCrearEstadisticas.setVisible(false);
		pnlCentro.add(pnlCrearEstadisticas);

		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicial();

			}
		});

		tableConvocados = new JTable();
		scrollTablaConvocados = new JScrollPane(tableConvocados);
		pnlTablaConvocados.add(scrollTablaConvocados);
		modeloTablaJugadoresPorteros = new ModeloTablaJugadoresPorteros(null);

		pnlBtnBorrar = new JPanel();
		pnlBtnExportar = new JPanel();
		btnBorrar = new JButton("BORRAR");
		btnExportar = new JButton("GUARDAR CONVOCATORIA");
		pnlBtnBorrar.add(btnBorrar);
		pnlBtnExportar.add(btnExportar);

		modeloListaJugadores = new ModeloListajugadores<Jugador>();
		listaJugadores = new JList<>(modeloListaJugadores);
		scrollListaJugadores = new JScrollPane(listaJugadores);
		pnlTablaConvocados.add(scrollListaJugadores);
		pnlTablaConvocados.add(pnlBtnBorrar);
		pnlTablaConvocados.add(pnlBtnExportar);

		

		

		chckbxPrimerasLineas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chckbxSegundasLineas.setSelected(false);
				chckbxPortero.setSelected(false);
				if (chckbxPrimerasLineas.isSelected() == true) {
					modeloTablaJugadoresPrimeraLinea = new ModeloTablaJugadoresPrimeraLinea(
							Gestor.devuelveListaDePrimerasLineas());
					tableConvocados.setModel(modeloTablaJugadoresPrimeraLinea);

				}
			}
		});

		chckbxSegundasLineas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chckbxPrimerasLineas.setSelected(false);
				chckbxPortero.setSelected(false);
				if (chckbxSegundasLineas.isSelected() == true) {
					modeloTablaJugadoresSegundaLinea = new ModeloTablaJugadoresSegundaLinea(
							Gestor.devuelveListaDeSegundasLineas());
					tableConvocados.setModel(modeloTablaJugadoresSegundaLinea);
				}

			}
		});
		chckbxPortero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chckbxPrimerasLineas.setSelected(false);
				chckbxSegundasLineas.setSelected(false);
				if (chckbxPortero.isSelected() == true) {
					modeloTablaJugadoresPorteros = new ModeloTablaJugadoresPorteros(Gestor.devuelveListaDePorteros());
					tableConvocados.setModel(modeloTablaJugadoresPorteros);
				}

			}
		});

		tableConvocados.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				fila = tableConvocados.rowAtPoint(p);

			}
		});

		tableConvocados.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A) {
					String dni = (String) tableConvocados.getModel().getValueAt(fila, 3);
					for (Jugador j : Gestor.listaJugadores) {
						if (j.getDni().equals(dni)) {
							if(!modeloListaJugadores.contains(j)) {
								modeloListaJugadores.addElement(j);
								numJugadoresConvocados++;
								lblConvocados.setText("LLevas " + numJugadoresConvocados + " de 16 jugadores convocados");

							}else {
								JOptionPane.showMessageDialog(null, "No puedes meter a un jugador dos veces!");
							}
							
						}
					}

				}

			}

		});

		listaJugadores.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e2) {
				Point p2 = e2.getPoint();
				fila2 = listaJugadores.locationToIndex(p2);

			}
		});

		btnBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(modeloListaJugadores.size()>fila2) {
					Jugador jugador = modeloListaJugadores.getElementAt(fila2);
					modeloListaJugadores.removeElement(jugador);
					numJugadoresConvocados--;
					lblConvocados.setText("LLevas " + numJugadoresConvocados + " de 16 jugadores convocados");

				}else {
					JOptionPane.showMessageDialog(null, "Selecciona bien el jugador que quieras quitar de la lista de convocados");
				}
				
			}
		});

		btnExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opciones = -1;
				if(numJugadoresConvocados > 16) {
					opciones = JOptionPane.showConfirmDialog(null,
							"Recuerda que solo se pueden convocar 16 jugadores por partido ¿Deseas continuar?",
							"Confirmación", JOptionPane.YES_NO_OPTION);
					if (opciones == JOptionPane.YES_OPTION) {
						for (int i = 0; i < 16; i++) {
							Jugador jugador = listaJugadores.getModel().getElementAt(i);
							VentanaInicial.getPartido().addJugadores(jugador);
							lblConvocados.setText("LLevas " + 16 + " de 16 jugadores convocados");
							
						}
						cambioAlExportar();

					} else {
						JOptionPane.showMessageDialog(null,
								"Tienes un boton de borrar para poder seleccionar bien a tus jugadores");
					}

				}else if(numJugadoresConvocados == 16){
					for (int i = 0; i < 16; i++) {
						Jugador jugador = listaJugadores.getModel().getElementAt(i);
						
						VentanaInicial.getPartido().addJugadores(jugador);

					}
					cambioAlExportar();

					
				}else if(numJugadoresConvocados < 16 && numJugadoresConvocados > 9){
					
					int jugadoresRestantes = 16 - numJugadoresConvocados;
					int opcion = JOptionPane.showConfirmDialog(null, "Te quedan "
							+ jugadoresRestantes +" jugadores por convocar, ¿deseas continuar?", "", JOptionPane.CANCEL_OPTION);
					if(opcion == JOptionPane.YES_OPTION) {
						
						for (int i = 0; i < numJugadoresConvocados; i++) {
							Jugador jugador = listaJugadores.getModel().getElementAt(i);
							VentanaInicial.getPartido().addJugadores(jugador);
						}
						cambioAlExportar();
					}
					
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Tienes que llevar a mas de 9 jugadores si no quieres recivir una multa");
				}
				
			}
		});

		pnlCrearEstadisticas.setLayout(new BorderLayout());

		JPanel pnlGeneral = new JPanel();
		pnlCrearEstadisticas.add(pnlGeneral, BorderLayout.CENTER);
		
		List<Jugador> lJ = VentanaInicial.getPartido().getlJugadores();
		Estadisticas e = new Estadisticas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		List<Estadisticas> lE = new ArrayList<>();
		lE.add(e);
		

		JPanel pnlPrincipal = new JPanel();
		JPanel pnlGuardarTodo = new JPanel();
		
		
		pnlPrincipal.setPreferredSize(new Dimension(anchoP-150, altoP-450));
	
		pnlCrearEstadisticas.add(pnlPrincipal);
		
		pnlPrincipal.setLayout(new GridLayout(3,1));
		
		JPanel pnlArribaDeTabla = new JPanel();
		pnlPrincipal.add(pnlArribaDeTabla);
		pnlArribaDeTabla.setLayout(new GridLayout(2,1));
		
		JPanel pnlLabel = new JPanel();
		pnlArribaDeTabla.add(pnlLabel);
		pnlLabel.setLayout(new GridLayout(1,2));
		
		
		
		String tituloLocal = p.getNombreEquipo();
		String tituloVIsitante = "VISITANTE";
		
		Font font = new Font("Agency FB", Font.BOLD, 41);
		
		
		JLabel lblNumIzq = new JLabel(tituloLocal + "\n" + "0");
		pnlLabel.add(lblNumIzq);
		
		
		JLabel lblNumDrch = new JLabel( tituloVIsitante + "\n" + "0");
		pnlLabel.add(lblNumDrch);
		
		lblNumIzq.setFont(font);
		lblNumDrch.setFont(font);
		
		JPanel pnlBotones = new JPanel();
		pnlArribaDeTabla.add(pnlBotones);
		pnlBotones.setLayout(new GridLayout(1,2));
		
		JPanel pnlBotonesIzq = new JPanel();
		pnlBotones.add(pnlBotonesIzq);
		pnlBotonesIzq.setLayout(new GridLayout(2,1));
		
		
		JPanel pnlBotonSumarIzq = new JPanel();
		JButton btnSumarIzq = new JButton("+");
		pnlBotonSumarIzq.add(btnSumarIzq);
		pnlBotonesIzq.add(pnlBotonSumarIzq);
		
		
		JPanel pnlBotonRestarIzq = new JPanel();
		JButton btnRestarIzq = new JButton("-");
		pnlBotonRestarIzq.add(btnRestarIzq);
		pnlBotonesIzq.add(pnlBotonRestarIzq);
		
		
		JPanel pnlBotonesDrch = new JPanel();
		pnlBotones.add(pnlBotonesDrch);
		pnlBotonesDrch.setLayout(new GridLayout(2,1));
		
		JButton btnSumarDrch = new JButton("+");
		JPanel pnlBotonSumarDrch = new JPanel();
		pnlBotonSumarDrch.add(btnSumarDrch);
		pnlBotonesDrch.add(pnlBotonSumarDrch);
		
		JButton btnRestarDrch = new JButton("-");
		JPanel pnlBotonRestarDrch = new JPanel();
		pnlBotonRestarDrch.add(btnRestarDrch);
		pnlBotonesDrch.add(pnlBotonRestarDrch);
		
		btnSumarIzq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contadorLocal++;
				lblNumIzq.setText(tituloLocal + "\n" + contadorLocal);
				
			}
		});
		btnRestarIzq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(contadorLocal != 0) {
					contadorLocal--;
					lblNumIzq.setText(tituloLocal + "\n" + contadorLocal);
				}
					
				
				
			}
		});
		
		btnSumarDrch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contadorVisitante++;
				lblNumDrch.setText(tituloVIsitante + "\n" + contadorVisitante);
				
			}
		});
		btnRestarDrch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(contadorVisitante != 0) {
					contadorVisitante--;
					lblNumDrch.setText(tituloVIsitante + "\n" + contadorVisitante);
				}
					
				
				
			}
		});
		
		JPanel pnlParaLaTabla = new JPanel();
		
		pnlPrincipal.add(pnlParaLaTabla);
		
		pnlParaLaTabla.setLayout(new GridLayout(8,2));
		
		JLabel lblPM = new JLabel("PENALTIS METIDOS");
		pnlParaLaTabla.add(lblPM);
		JSpinner jsPM = new JSpinner();
		pnlParaLaTabla.add(jsPM);
		
		JLabel lblPF = new JLabel("PENALTIS FALLADOS");
		pnlParaLaTabla.add(lblPF);
		JSpinner jsPF = new JSpinner();
		pnlParaLaTabla.add(jsPF);
		
		JLabel lblG6 = new JLabel("GOLES DE 6M");
		pnlParaLaTabla.add(lblG6);
		JSpinner jsG6 = new JSpinner();
		pnlParaLaTabla.add(jsG6);
		
		JLabel lblNE = new JLabel("NUMERO DE EXPULSIONES");
		pnlParaLaTabla.add(lblNE);
		JSpinner jsNE = new JSpinner();
		pnlParaLaTabla.add(jsNE);
		
		JLabel lblNA = new JLabel("NUMERO DE AMARILLAS");
		pnlParaLaTabla.add(lblNA);
		JSpinner jsNA = new JSpinner();
		pnlParaLaTabla.add(jsNA);
		
		JLabel lblNP = new JLabel("NUMERO DE PARADAS");
		pnlParaLaTabla.add(lblNP);
		JSpinner jsNP = new JSpinner();
		pnlParaLaTabla.add(jsNP);
		
		JLabel lblG9 = new JLabel("GOLES DE 9M");
		pnlParaLaTabla.add(lblG9);
		JSpinner jsG9 = new JSpinner();
		pnlParaLaTabla.add(jsG9);
		
		JLabel lblTF = new JLabel("TIROS FALLADOS");
		pnlParaLaTabla.add(lblTF);
		JSpinner jsTF = new JSpinner();
		pnlParaLaTabla.add(jsTF);
		
		pnlPrincipal.add(pnlGuardarTodo);
		pnlGuardarTodo.setLayout(new GridLayout(1,3));
		
		JButton btnFinalizarPartido = new JButton("FINALIZAR PARTIDO");
		JButton btnResetearMarcador = new JButton("RESETEAR MARCADOR");
		JButton btnResetearEstadisticas = new JButton("RESETEAR ESTADISTICAS");
		JButton btnResetearTodo = new JButton("RESETEAR PARTIDO");
		JButton btnSalirSinGuardar = new JButton("SALIR SIN GUARDAR");
		
		pnlGuardarTodo.add(btnResetearEstadisticas);
		pnlGuardarTodo.add(btnResetearMarcador);
		pnlGuardarTodo.add(btnResetearTodo);
		pnlGuardarTodo.add(btnFinalizarPartido);
		pnlGuardarTodo.add(btnSalirSinGuardar);
		
		btnResetearMarcador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contadorLocal = 0;
				contadorVisitante = 0;
				lblNumDrch.setText(tituloVIsitante + "\n" + contadorVisitante);
				lblNumIzq.setText(tituloLocal + "\n" + contadorLocal);
				
			}
		});
		
		btnResetearEstadisticas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jsG6.setValue(0);
				jsG9.setValue(0);
				jsNA.setValue(0);
				jsNE.setValue(0);
				jsNP.setValue(0);
				jsPF.setValue(0);
				jsPM.setValue(0);
				jsTF.setValue(0);
			}
		});
		
		
		btnResetearTodo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contadorLocal = 0;
				contadorVisitante = 0;
				lblNumDrch.setText(tituloVIsitante + "\n" + contadorVisitante);
				lblNumIzq.setText(tituloLocal + "\n" + contadorLocal);
				
				jsG6.setValue(0);
				jsG9.setValue(0);
				jsNA.setValue(0);
				jsNE.setValue(0);
				jsNP.setValue(0);
				jsPF.setValue(0);
				jsPM.setValue(0);
				jsTF.setValue(0);
				
			}
		});
		
		btnFinalizarPartido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				nDeTirosFallidos= (Integer) jsTF.getValue();
				nDePenaltisMetidos = (Integer) jsPM.getValue();
				nDePenaltisfallados = (Integer) jsPF.getValue();
				nDeGolesSeisMetros = (Integer) jsG6.getValue();
				nDeGolesNueveMetros = (Integer) jsG9.getValue();
				nDeExpulsiones = (Integer) jsNE.getValue();
				nDeAmarillas = (Integer) jsNA.getValue();
				nDeParadas = (Integer) jsNP.getValue();
				
				Estadisticas estadisticas = new Estadisticas(contadorLocal, contadorVisitante, nDeTirosFallidos, nDePenaltisMetidos, nDePenaltisfallados, nDeGolesSeisMetros, nDeGolesNueveMetros, nDeExpulsiones, nDeAmarillas, nDeParadas);
				p.addEstaditicas(estadisticas);

				
				Main.getListaDePartidos().add(p);
				
				Gestor.guardarPartido(Main.getListaDePartidos(), Gestor.getNombreFich());
				
				dispose();
				new VentanaInicial();
				
			}
		});
		btnSalirSinGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicial();
			}
		});


	}
	
	public void cambioAlExportar() {
		lblInfo.setText("Estos son tus jugadores convocados");
		chckbxPrimerasLineas.setSelected(false);
		chckbxSegundasLineas.setSelected(false);
		chckbxPortero.setSelected(false);
		pnlTablaConvocados.setVisible(false);
		pnlCrearEstadisticas.setVisible(true);
	}

	
	
	
	

	
	
	

	
	
	
	

}
