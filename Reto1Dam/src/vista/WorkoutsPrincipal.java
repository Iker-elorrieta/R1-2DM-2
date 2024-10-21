package vista;

import javax.swing.JPanel;
import javax.swing.JList;

import modelo.Usuario;
import modelo.Workout;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class WorkoutsPrincipal extends JPanel {
	
	private JTable tablaContactos;
	private DefaultTableModel defaultTableModel;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public WorkoutsPrincipal(VentanaPrincipal vp, ArrayList<Usuario> usuarios) {
		setSize(640, 510);
		setLayout(null);
		
		JLabel lblWorkouts = new JLabel("Workouts");
		lblWorkouts.setBounds(25, 36, 117, 24);
		lblWorkouts.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblWorkouts);
		
		//boton para abrir el perfil del usuario
		JButton btnPerfilUsuario = new JButton("Perfil");
		btnPerfilUsuario.setBounds(541, 40, 89, 23);
		btnPerfilUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vp.cambioPaneles(4, usuarios);
			}
		});
		add(btnPerfilUsuario);
		
		//tabla con la informacion de los workout
		JScrollPane jScrollPanel;
		setLayout(null);
		jScrollPanel = new JScrollPane();
		jScrollPanel.setBounds(57, 115, 508, 267);
		add(jScrollPanel);
		
		

		String columnas[] = { "Nombre", "nº de ejercicios", "Nivel", "Video(URL)" };

		defaultTableModel = new DefaultTableModel(columnas, 0);

		tablaContactos = new JTable(defaultTableModel);
		tablaContactos.setAutoCreateRowSorter(true);
		tablaContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaContactos.setRowSelectionAllowed(false);
		tablaContactos.setCellSelectionEnabled(false);

		
		tablaContactos.setDefaultEditor(Object.class, null); //Anulamos la edici�n en la propia celda


		jScrollPanel.setViewportView(tablaContactos);
		
		
		
		//boton para seleccionar el workout
		JButton btnSeleccionarWorkout = new JButton("Seleccionar");
		btnSeleccionarWorkout.setBounds(525, 465, 89, 23);
		add(btnSeleccionarWorkout);
		
		JButton btnHistorial = new JButton("Historial de workouts");
		btnHistorial.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHistorial.setBounds(25, 465, 170, 23);
		add(btnHistorial);
		

	}
}
