package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class FrameWorkoutsPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tablaContactos;
    private DefaultTableModel defaultTableModel;
    private JLabel lblWorkouts;
    private JButton btnPerfil;
    private JButton btnHistorial;
    private JButton btnSeleccionar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrameWorkoutsPrincipal frame = new FrameWorkoutsPrincipal();
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
    public FrameWorkoutsPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 400);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
       
        JScrollPane jScrollPanel = new JScrollPane();
        jScrollPanel.setBounds(63, 68, 408, 217);
        contentPane.add(jScrollPanel);

        //tabla con datos
        String columnas[] = { "Nombre", "nº de ejercicios", "Nivel", "Video(URL)" };
        defaultTableModel = new DefaultTableModel(columnas, 0);
        tablaContactos = new JTable(defaultTableModel);
        tablaContactos.setAutoCreateRowSorter(true);
        tablaContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaContactos.setRowSelectionAllowed(false);
        tablaContactos.setCellSelectionEnabled(false);
        tablaContactos.setDefaultEditor(Object.class, null);
        
        jScrollPanel.setViewportView(tablaContactos);

        lblWorkouts = new JLabel("WORKOUTS");
        lblWorkouts.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblWorkouts.setBounds(10, 11, 99, 14);
        contentPane.add(lblWorkouts);

        btnPerfil = new JButton("Perfil");
        btnPerfil.setBounds(435, 9, 89, 23);
        contentPane.add(btnPerfil);

        btnHistorial = new JButton("Historial de workouts");
        btnHistorial.setBounds(10, 327, 142, 23);
        contentPane.add(btnHistorial);

        btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setBounds(435, 327, 89, 23);
        contentPane.add(btnSeleccionar);
    }

    //getters
	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTablaContactos() {
		return tablaContactos;
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
    

  
}
