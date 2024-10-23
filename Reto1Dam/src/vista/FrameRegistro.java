package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

public class FrameRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JPasswordField passwordFieldContrasena;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JButton btnRegistrarse;
	private JButton btnAtras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRegistro frame = new FrameRegistro();
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
	public FrameRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(150, 70, 68, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(150, 120, 68, 14);
		contentPane.add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(150, 170, 68, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasena.setBounds(150, 220, 68, 14);
		contentPane.add(lblContrasena);
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaNac.setBounds(125, 270, 131, 14);
		contentPane.add(lblFechaNac);
		
		btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(241, 67, 170, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(241, 217, 170, 20);
		contentPane.add(passwordFieldContrasena);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(241, 117, 170, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(241, 167, 170, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrarse.setBounds(206, 313, 109, 23);
		contentPane.add(btnRegistrarse);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblRegistro.setBounds(224, 27, 89, 29);
		contentPane.add(lblRegistro);
		
		JDateChooser dateChooserFechaNac = new JDateChooser();
		dateChooserFechaNac.setBounds(268, 264, 143, 20);
		contentPane.add(dateChooserFechaNac);		
		
	}

	//getters
	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public JPasswordField getPasswordFieldContrasena() {
		return passwordFieldContrasena;
	}

	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	
	
	
	
}
