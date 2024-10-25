package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.HistoricoWorkouts;

import javax.swing.JButton;

public class FrameHistorialWorkouts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtras;
	private DefaultTableModel defaultTableModel;
	private JTable tablaHistorial;
	private JLabel lblWorkouts;
	private JButton btnPerfil;
	private JButton btnSeleccionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHistorialWorkouts frame = new FrameHistorialWorkouts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameHistorialWorkouts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// tabla con datos
		JScrollPane jScrollPanel = new JScrollPane();
		jScrollPanel.setBounds(63, 68, 408, 217);
		contentPane.add(jScrollPanel);

		String columnas[] = { "Nombre", "nº de ejercicios", "Nivel", "Video(URL)" };

		defaultTableModel = new DefaultTableModel(columnas, 0);

		tablaHistorial = new JTable(defaultTableModel);
		tablaHistorial.setColumnSelectionAllowed(false);
		tablaHistorial.setCellSelectionEnabled(false);
		tablaHistorial.setRowSelectionAllowed(true);
		tablaHistorial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaHistorial.setAutoCreateRowSorter(true);

		// anulamos la edicion de las celdas
		tablaHistorial.setDefaultEditor(Object.class, null);

		jScrollPanel.setViewportView(tablaHistorial);

		lblWorkouts = new JLabel("WORKOUTS");
		lblWorkouts.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWorkouts.setBounds(10, 11, 99, 14);
		contentPane.add(lblWorkouts);

		btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(435, 9, 89, 23);
		contentPane.add(btnPerfil);

//				btnHistorial = new JButton("Historial de workouts");
//				btnHistorial.setBounds(10, 327, 168, 23);
//				contentPane.add(btnHistorial);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(412, 327, 112, 23);
		contentPane.add(btnSeleccionar);

		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);
	}
	
	//metodo para insertar los workout en la tabla
		public void insertarHistoricos() {
			//limpiar las filas
			defaultTableModel.setRowCount(0);

			HistoricoWorkouts historicoInstance = new HistoricoWorkouts();
			ArrayList<HistoricoWorkouts> listaHistoricoWorkouts = historicoInstance.mObtenerHistoricoWorkouts(getName());

			//lo recorremos y añadimos a la tabla
			for (HistoricoWorkouts HistoricoWorkout : listaHistoricoWorkouts) {
				Object[] rowData = {
						HistoricoWorkout.getNombreW(),
						HistoricoWorkout.getNivel(),
						HistoricoWorkout.getTiempoTotal().intValue(),
						HistoricoWorkout.getTiempoPrevisto().intValue(),
						HistoricoWorkout.getFecha()
				};

				defaultTableModel.addRow(rowData);
			}
		}

	// getters
	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

}
