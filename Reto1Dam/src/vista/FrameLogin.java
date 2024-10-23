package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class FrameLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldContrasena;
	private JButton btnRegistro;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel(new ImageIcon("src/Imagen/file.jpg"));
		logo.setSize(240, 240);
		logo.setLocation(10, 11);
		logo.setVisible(true);
		getContentPane().add(logo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(282, 114, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasena.setBounds(260, 173, 75, 14);
		contentPane.add(lblContrasena);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(338, 111, 186, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(338, 170, 186, 20);
		contentPane.add(passwordFieldContrasena);
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistro.setBounds(115, 307, 116, 23);
		contentPane.add(btnRegistro);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(366, 307, 99, 23);
		contentPane.add(btnLogin);
		
		JLabel lblInicioSesion = new JLabel("Inicio de Sesión");
		lblInicioSesion.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		lblInicioSesion.setBounds(338, 46, 150, 14);
		contentPane.add(lblInicioSesion);
	}

	//getters
	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JPasswordField getPasswordFieldContrasena() {
		return passwordFieldContrasena;
	}

	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}
	
	
}
