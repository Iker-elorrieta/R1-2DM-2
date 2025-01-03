package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Ejercicio;
import modelo.Workout;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameWorkout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtras;
	private JButton btnEntrar;
	private JLabel lblNombreWorkout;

	private JTable tablaEjercicios;
	private DefaultTableModel defaultTableModel;
	
	private String nombreWorkoutTabla;
	private String nombreEjercicioTabla;
	private String descripcionEjercicioTabla;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameWorkout frame = new FrameWorkout();
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
	public FrameWorkout(Workout workout) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombreWorkout = new JLabel("");
		lblNombreWorkout.setForeground(SystemColor.textHighlight);
		lblNombreWorkout.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombreWorkout.setBounds(190, 20, 155, 14);
		contentPane.add(lblNombreWorkout);

		//tabla con datos
		JScrollPane jScrollPanel = new JScrollPane();
		jScrollPanel.setBounds(10, 100, 514, 167);
		contentPane.add(jScrollPanel);


		String columnas[] = { "Nombre del workout", "Nombre", "Tiempo de descanso", "Descripcion"};

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
                int row = tablaEjercicios.getSelectedRow(); // Get the selected row
                if (row != -1) { // Check if a row is selected
                    nombreWorkoutTabla = (String) defaultTableModel.getValueAt(row, 0); //valor de la primera columna de la fila seleccionada
                    nombreEjercicioTabla = (String) defaultTableModel.getValueAt(row, 1); //valor de la segunda columna de la fila seleccionada
                    descripcionEjercicioTabla = (String) defaultTableModel.getValueAt(row, 3); //valor de la tercera columna de la fila seleccionada
                }
            }
        });

		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(10, 9, 89, 23);
		contentPane.add(btnAtras);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(0, 153, 0));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.setBounds(218, 327, 97, 23);
		contentPane.add(btnEntrar);
	}

	//metodo para insertar los workout en la tabla
	public void insertarEjercicios(String nombreWorkout) {
		//limpiar las filas
		defaultTableModel.setRowCount(0);

		Ejercicio ejercicioInstance = new Ejercicio();

		ArrayList<Ejercicio> listaEjercicios = ejercicioInstance.mObtenerEjercicios(nombreWorkout);

		//lo recorremos y añadimos a la tabla
		for (Ejercicio ejercicio : listaEjercicios) {
			Object[] rowData = {
					nombreWorkout,
					ejercicio.getNombreE(), 
					ejercicio.getTiempoDescanso().intValue(), 
					ejercicio.getDescripcion()
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

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public JTable getTablaEjercicios() {
		return tablaEjercicios;
	}

	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}

	public JLabel getLblNombreWorkout() {
		return lblNombreWorkout;
	}

	public String getNombreWorkoutTabla() {
		return nombreWorkoutTabla;
	}

	public String getNombreEjercicioTabla() {
		return nombreEjercicioTabla;
	}

	public String getDescripcionEjercicioTabla() {
		return descripcionEjercicioTabla;
	}
	
	
	
	
	
	




}
