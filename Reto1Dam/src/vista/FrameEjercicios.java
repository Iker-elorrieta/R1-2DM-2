package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Ejercicio;
import modelo.Serie;
import modelo.Workout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class FrameEjercicios extends JFrame {
	
	private static String rutaBaseImg = "src/Imagen/";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtras;
	private JButton btnInicioPausa;
	private JButton btnSalir;

	private JLabel lblNombreEjercicio;
	private JLabel lblNombreWorkout;
	private JTextArea textAreaDescripcion;
	private JLabel lblTiempoEjercicio;
	private JLabel lblDescanso;
	private JLabel lblListaSeries;
	private JLabel lblCronometroWorkout;
	private JList<Serie> listSeries;

	private JTable tablaEjercicios;
	private DefaultTableModel defaultTableModel;


	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEjercicios frame = new FrameEjercicios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FrameEjercicios(Workout workout, Ejercicio ejercicio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);

		lblNombreEjercicio = new JLabel("nombre ejercicio***");
		lblNombreEjercicio.setForeground(SystemColor.textHighlight);
		lblNombreEjercicio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombreEjercicio.setBounds(50, 66, 155, 14);
		contentPane.add(lblNombreEjercicio);

		lblNombreWorkout = new JLabel("nombre workout***");
		lblNombreWorkout.setForeground(SystemColor.textHighlight);
		lblNombreWorkout.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombreWorkout.setBounds(330, 66, 155, 14);
		contentPane.add(lblNombreWorkout);

		btnInicioPausa = new JButton("Iniciar/Pausar****");
		btnInicioPausa.setBounds(256, 580, 122, 23);
		contentPane.add(btnInicioPausa);

		//tabla con datos
		JScrollPane jScrollPanel = new JScrollPane();
		jScrollPanel.setBounds(50, 178, 514, 167);
		contentPane.add(jScrollPanel);


		String columnas[] = { "Imagen", "Nombre serie", "Numero de repeticiones"};

		defaultTableModel = new DefaultTableModel(columnas, 0);

		tablaEjercicios = new JTable(defaultTableModel);
		tablaEjercicios.setColumnSelectionAllowed(false);
		tablaEjercicios.setCellSelectionEnabled(false);
		tablaEjercicios.setRowSelectionAllowed(true);
		tablaEjercicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		tablaEjercicios.setAutoCreateRowSorter(true);

		//anulamos la edicion de las celdas
		tablaEjercicios.setDefaultEditor(Object.class, null);

		jScrollPanel.setViewportView(tablaEjercicios);

		lblCronometroWorkout = new JLabel("cronometro workout");
		lblCronometroWorkout.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCronometroWorkout.setHorizontalAlignment(SwingConstants.CENTER);
		lblCronometroWorkout.setBounds(50, 400, 128, 14);
		contentPane.add(lblCronometroWorkout);

		lblListaSeries = new JLabel("Lista de Series");
		lblListaSeries.setBounds(50, 145, 95, 14);
		contentPane.add(lblListaSeries);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(165, 42, 42));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(535, 627, 89, 23);
		contentPane.add(btnSalir);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBackground(SystemColor.inactiveCaptionBorder);
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setWrapStyleWord(true);
		textAreaDescripcion.setEditable(false);
		textAreaDescripcion.setBounds(50, 91, 436, 23);
		contentPane.add(textAreaDescripcion);

		lblTiempoEjercicio = new JLabel("Tiempo ejercicio");
		lblTiempoEjercicio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTiempoEjercicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoEjercicio.setBounds(266, 400, 102, 14);
		contentPane.add(lblTiempoEjercicio);

		lblDescanso = new JLabel("Descanso");
		lblDescanso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescanso.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescanso.setBounds(518, 400, 66, 14);
		contentPane.add(lblDescanso);
	}

	//metodo para insertar las series en el jlist
	public void insertarSeries(String workoutNombre, String ejercicioNombre) {
		//limpiar las filas
		defaultTableModel.setRowCount(0);

		
		Serie serieInstance = new Serie();
		
		ArrayList<Serie> listaSeries = serieInstance.mObtenerSeries(workoutNombre, ejercicioNombre);

		for (Serie serie : listaSeries) {
			
			String nombreImg = serie.getFoto();
			
			String rutaImg = rutaBaseImg + nombreImg;
			
			 ImageIcon imageIcon = new ImageIcon(rutaImg);
			
			Object[] rowData = {
					imageIcon,
					serie.getNombreS(),
					serie.getNumRepeticiones()
			};

			defaultTableModel.addRow(rowData);
		}
	}

	//getters
	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public JButton getBtnInicioPausa() {
		return btnInicioPausa;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JLabel getLblNombreEjercicio() {
		return lblNombreEjercicio;
	}

	public JLabel getLblNombreWorkout() {
		return lblNombreWorkout;
	}

	public JTextArea getTextAreaDescripcion() {
		return textAreaDescripcion;
	}

	public JLabel getLblTiempoEjercicio() {
		return lblTiempoEjercicio;
	}

	public JLabel getLblDescanso() {
		return lblDescanso;
	}

	public JLabel getLblListaSeries() {
		return lblListaSeries;
	}

	public JLabel getLblCronometroWorkout() {
		return lblCronometroWorkout;
	}

	public JList<Serie> getListSeries() {
		return listSeries;
	}






}
