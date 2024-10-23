package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;

public class FrameWorkout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtras;
	private JButton btnIniciar;

	/**
	 * Launch the application.
	 */
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
	}

	/**
	 * Create the frame.
	 */
	public FrameWorkout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreWorkout = new JLabel("nombre workout***");
		lblNombreWorkout.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreWorkout.setBounds(189, 20, 155, 14);
		contentPane.add(lblNombreWorkout);
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(10, 9, 89, 23);
		contentPane.add(btnAtras);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setForeground(new Color(0, 153, 0));
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIniciar.setBounds(218, 327, 97, 23);
		contentPane.add(btnIniciar);
		
		JList list = new JList();
		list.setBounds(72, 110, 389, 147);
		contentPane.add(list);
	}

	//getters
	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public JButton getBtnIniciar() {
		return btnIniciar;
	}
	
	
}
