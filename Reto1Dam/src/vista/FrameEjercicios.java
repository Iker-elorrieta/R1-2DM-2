package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class FrameEjercicios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtras;
	private JButton btnInicioPausa;
	private JButton btnSalir;
	

	/**
	 * Launch the application.
	 */
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
	}

	/**
	 * Create the frame.
	 */
	public FrameEjercicios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel lblNombreEjercicio = new JLabel("nombre ejercicio***");
		lblNombreEjercicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreEjercicio.setBounds(189, 15, 155, 14);
		contentPane.add(lblNombreEjercicio);
		
		JLabel lblNombreWorkout = new JLabel("nombre workout***");
		lblNombreWorkout.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreWorkout.setBounds(369, 13, 155, 14);
		contentPane.add(lblNombreWorkout);
		
		btnInicioPausa = new JButton("Iniciar/Pausar****");
		btnInicioPausa.setBounds(206, 327, 122, 23);
		contentPane.add(btnInicioPausa);
		
		JList listSeries = new JList();
		listSeries.setBounds(170, 120, 290, 141);
		contentPane.add(listSeries);
		
		JLabel lblNewLabel = new JLabel("cronometro*********");
		lblNewLabel.setBounds(10, 111, 109, 90);
		contentPane.add(lblNewLabel);
		
		JLabel lblListaSeries = new JLabel("Lista de Series");
		lblListaSeries.setBounds(170, 95, 95, 14);
		contentPane.add(lblListaSeries);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(435, 327, 89, 23);
		contentPane.add(btnSalir);
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
	
	

}
