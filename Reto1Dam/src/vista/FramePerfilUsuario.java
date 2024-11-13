package vista;

import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;

public class FramePerfilUsuario extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre, textFieldApellido, textFieldEmail, textFieldFechaNac;
	private JButton btnModificar, btnAtras;

	
	/**
	 * Create the frame.
	 */
	public FramePerfilUsuario(Usuario usuario) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 95, 68, 14);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(298, 95, 68, 14);
		contentPane.add(lblApellido);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 166, 68, 14);
		contentPane.add(lblEmail);

		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaNac.setBounds(10, 232, 131, 14);
		contentPane.add(lblFechaNac);

		btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);

		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(67, 92, 170, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		textFieldApellido.setBounds(354, 92, 170, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setBounds(67, 163, 170, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		btnModificar = new JButton("Modificar datos");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(378, 327, 146, 23);
		contentPane.add(btnModificar);

		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setEditable(false);
		textFieldFechaNac.setBounds(142, 229, 95, 20);
		contentPane.add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);


	}

	//metodo para poner los datos del usuario en los textField
	public void setUsuarioDatos(Usuario usuario) {
		if (usuario != null) {
			textFieldNombre.setText(usuario.getNombre());
			textFieldApellido.setText(usuario.getApellido());
			textFieldEmail.setText(usuario.getEmail());
			if (usuario.getFechaNac() != null) {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
	            String formattedDate = dateFormat.format(usuario.getFechaNac());
	            textFieldFechaNac.setText(formattedDate);
	        } else {
	            textFieldFechaNac.setText("");
	        }
		}
	}



	//getters
	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JTextField getTextFieldFechaNac() {
		return textFieldFechaNac;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}



}
