package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Ejercicio;
import modelo.Serie;
import modelo.Workout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
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
	private JLabel lblCronometroWorkout;
	private JLabel lblCronometro;
	private JLabel lblTiempoSerie;
	private JLabel lblTiempoSerieNom;

	private JTable tablaEjercicios;
	private DefaultTableModel defaultTableModel;
	private JLabel lblTiempoEjer;
	private JLabel lblTiempoDescanso;
	private JLabel lblCuentaAtrasV;
	private JTextArea textAreaFondo1;
	private JTextArea textAreaFondo2;


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
     * Render customizado para poner imagenes en una columna del Jtable
     */
    public class ImageRenderer extends DefaultTableCellRenderer {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                setIcon((ImageIcon) value);
            } else {
                setIcon(null);
                setText(value != null ? value.toString() : "");
            }
            return this;
        }
    }
	

	/**
	 * Create the frame.
	 */
	public FrameEjercicios(Workout workout, Ejercicio ejercicio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);

		lblNombreEjercicio = new JLabel("nombre ejercicio*");
		lblNombreEjercicio.setForeground(SystemColor.textHighlight);
		lblNombreEjercicio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombreEjercicio.setBounds(50, 66, 155, 14);
		contentPane.add(lblNombreEjercicio);

		lblNombreWorkout = new JLabel("nombre workout*");
		lblNombreWorkout.setForeground(SystemColor.textHighlight);
		lblNombreWorkout.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombreWorkout.setBounds(330, 66, 155, 14);
		contentPane.add(lblNombreWorkout);

		btnInicioPausa = new JButton("");
		btnInicioPausa.setBounds(256, 630, 122, 23);
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
		tablaEjercicios.setRowSelectionAllowed(false);
		tablaEjercicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		tablaEjercicios.setAutoCreateRowSorter(true);

		//anulamos la edicion de las celdas
		tablaEjercicios.setDefaultEditor(Object.class, null);
		
		
		//ponemos el render customizado para la imagen de la columna
        tablaEjercicios.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
        tablaEjercicios.setRowHeight(60);
		

		jScrollPanel.setViewportView(tablaEjercicios);

		lblCronometroWorkout = new JLabel("Cronometro workout");
		lblCronometroWorkout.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCronometroWorkout.setHorizontalAlignment(SwingConstants.LEFT);
		lblCronometroWorkout.setBounds(20, 400, 161, 14);
		contentPane.add(lblCronometroWorkout);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(165, 42, 42));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(535, 677, 89, 23);
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
		lblTiempoEjercicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiempoEjercicio.setBounds(255, 400, 102, 14);
		contentPane.add(lblTiempoEjercicio);

		lblDescanso = new JLabel("Descanso");
		lblDescanso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescanso.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescanso.setBounds(470, 402, 66, 14);
		contentPane.add(lblDescanso);
		
		lblCronometro = new JLabel("0:00");
		lblCronometro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCronometro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCronometro.setBackground(SystemColor.inactiveCaption);
		lblCronometro.setBounds(20, 445, 147, 29);
		contentPane.add(lblCronometro);
		
		lblTiempoEjer = new JLabel("0:00");
		lblTiempoEjer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoEjer.setBounds(230, 445, 147, 29);
		contentPane.add(lblTiempoEjer);
		
		lblTiempoDescanso = new JLabel("0:00");
		lblTiempoDescanso.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoDescanso.setBounds(465, 445, 76, 29);
		contentPane.add(lblTiempoDescanso);
		
		lblCuentaAtrasV = new JLabel("-");
		lblCuentaAtrasV.setForeground(new Color(199, 21, 133));
		lblCuentaAtrasV.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCuentaAtrasV.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuentaAtrasV.setBounds(286, 542, 44, 44);
		contentPane.add(lblCuentaAtrasV);
		
		JTextArea textAreaFondo = new JTextArea();
		textAreaFondo.setEditable(false);
		textAreaFondo.setBackground(new Color(204, 204, 255));
		textAreaFondo.setBounds(20, 445, 147, 29);
		contentPane.add(textAreaFondo);
		
		textAreaFondo1 = new JTextArea();
		textAreaFondo1.setEditable(false);
		textAreaFondo1.setBackground(SystemColor.inactiveCaption);
		textAreaFondo1.setBounds(230, 445, 147, 29);
		contentPane.add(textAreaFondo1);
		
		textAreaFondo2 = new JTextArea();
		textAreaFondo2.setEditable(false);
		textAreaFondo2.setBackground(new Color(204, 255, 204));
		textAreaFondo2.setBounds(465, 445, 76, 29);
		contentPane.add(textAreaFondo2);
		
		lblTiempoSerieNom = new JLabel("Tiempo de la serie -");
		lblTiempoSerieNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoSerieNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTiempoSerieNom.setBounds(20, 559, 147, 14);
		contentPane.add(lblTiempoSerieNom);
		
		lblTiempoSerie = new JLabel("0:00");
		lblTiempoSerie.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoSerie.setBounds(20, 597, 147, 29);
		contentPane.add(lblTiempoSerie);
		
		JTextArea textAreaFondo3 = new JTextArea();
		textAreaFondo3.setEditable(false);
		textAreaFondo3.setBackground(new Color(255, 222, 173));
		textAreaFondo3.setBounds(20, 597, 147, 29);
		contentPane.add(textAreaFondo3);
	}

	//metodo para insertar los datos de las series en la tabla
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
					serie.getNumRepeticiones().intValue()
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

	public JLabel getLblCronometroWorkout() {
		return lblCronometroWorkout;
	}

	public static String getRutaBaseImg() {
		return rutaBaseImg;
	}

	public JTable getTablaEjercicios() {
		return tablaEjercicios;
	}

	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}

	public JLabel getLblCronometro() {
		return lblCronometro;
	}

	public JLabel getLblTiempoEjer() {
		return lblTiempoEjer;
	}

	public JLabel getLblTiempoDescanso() {
		return lblTiempoDescanso;
	}

	public JLabel getLblCuentaAtrasV() {
		return lblCuentaAtrasV;
	}

	public JLabel getLblTiempoSerie() {
		return lblTiempoSerie;
	}

	public JLabel getLblTiempoSerieNom() {
		return lblTiempoSerieNom;
	}
	
	
	
	
}
