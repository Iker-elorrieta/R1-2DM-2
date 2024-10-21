package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class FrameLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldContrasena;

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
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(231, 80, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasena.setBounds(231, 173, 75, 14);
		contentPane.add(lblContrasena);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(319, 77, 186, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(319, 170, 186, 20);
		contentPane.add(passwordFieldContrasena);
		
		JButton btRegistro = new JButton("Registrarse");
		btRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btRegistro.setBounds(115, 307, 99, 23);
		contentPane.add(btRegistro);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(406, 307, 99, 23);
		contentPane.add(btnLogin);
	}
}
