package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Usuario;
import modelo.Workout;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class FrameWorkoutsPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaEjercicios;
	private DefaultTableModel defaultTableModel;
	private JLabel lblWorkouts;
	private JButton btnPerfil;
	private JButton btnHistorial;
	private JButton btnFiltro;
	private JButton btnSeleccionar;
	private JComboBox<Integer> comboBoxFiltrosNivel;

	private String nombreWorkout;

	/**
	 * Launch the application.
	 */
	/*
	public void cargarFrameWorkoutsPrincipal(Usuario usuario, FrameWorkoutsPrincipal frame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameWorkoutsPrincipal frame = new FrameWorkoutsPrincipal(usuario);
					frame.setVisible(true);

					//cargamos la tabla con los datos
					frame.insertarWorkouts();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FrameWorkoutsPrincipal(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		//tabla con datos
		JScrollPane jScrollPanel = new JScrollPane();
		jScrollPanel.setBounds(63, 120, 408, 167);
		contentPane.add(jScrollPanel);


		String columnas[] = { "Nombre", "nº de ejercicios", "Nivel", "Video(URL)"};

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

		tablaEjercicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tablaEjercicios.getSelectedRow();
				if (row != -1) {
					nombreWorkout = (String) defaultTableModel.getValueAt(row, 0); //valor de la primera columna de la fila seleccionada
				}
			}
		});


		lblWorkouts = new JLabel("WORKOUTS");
		lblWorkouts.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWorkouts.setBounds(10, 11, 99, 14);
		contentPane.add(lblWorkouts);

		btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(435, 9, 89, 23);
		contentPane.add(btnPerfil);

		btnHistorial = new JButton("Historial de workouts");
		btnHistorial.setBounds(10, 327, 168, 23);
		contentPane.add(btnHistorial);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(412, 327, 112, 23);
		contentPane.add(btnSeleccionar);

		JLabel lblFiltroNivel = new JLabel("Filtros de nivel: ");
		lblFiltroNivel.setBounds(10, 59, 99, 14);
		contentPane.add(lblFiltroNivel);

		comboBoxFiltrosNivel = new JComboBox<Integer>();
		comboBoxFiltrosNivel.setBounds(110, 55, 89, 22);
		contentPane.add(comboBoxFiltrosNivel);

		btnFiltro = new JButton("Filtrar");
		btnFiltro.setBounds(239, 55, 89, 23);
		contentPane.add(btnFiltro);

		comboBoxFiltrosNivel.addItem(null);
		comboBoxFiltrosNivel.addItem(0);
		comboBoxFiltrosNivel.addItem(1);
		comboBoxFiltrosNivel.addItem(2);

	}

	//metodo para insertar los workout en la tabla
	public void insertarWorkouts() {
		//limpiar las filas
		defaultTableModel.setRowCount(0);

		Workout workoutInstance = new Workout();

		Integer nivelSeleccionado = (Integer) comboBoxFiltrosNivel.getSelectedItem();

		ArrayList<Workout> listaWorkouts;

		if(nivelSeleccionado == null) {

			listaWorkouts = workoutInstance.mObtenerWorkouts();

		} else {
			listaWorkouts = workoutInstance.mObtenerWorkoutsNivel(nivelSeleccionado);
		}

		//lo recorremos y añadimos a la tabla
		for (Workout workout : listaWorkouts) {
			Object[] rowData = {
					workout.getNombreW(),
					workout.getNumEjercicios().intValue(), //convertir a int para visualizarlo mejor
					workout.getNivel().intValue(), //convertir a int para visualizarlo mejor
					workout.getVideo()
			};

			defaultTableModel.addRow(rowData);
		}

		//ponemos que por defecto este seleccionado el primer ejercicio para que no de errores
		if (defaultTableModel.getRowCount() > 0) {
			tablaEjercicios.setRowSelectionInterval(0, 0);
			
			nombreWorkout = (String) defaultTableModel.getValueAt(0, 0);
		}
	}


	//getters
	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTablaEjercicios() {
		return tablaEjercicios;
	}

	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}

	public JLabel getLblWorkouts() {
		return lblWorkouts;
	}

	public JButton getBtnPerfil() {
		return btnPerfil;
	}

	public JButton getBtnHistorial() {
		return btnHistorial;
	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public JComboBox<Integer> getComboBoxFiltrosNivel() {
		return comboBoxFiltrosNivel;
	}

	public JButton getBtnFiltro() {
		return btnFiltro;
	}

	public String getNombreWorkout() {
		return nombreWorkout;
	}




}
