package vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import modelo.Usuario;

public class FrameModificarDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombreModificar;
	private JTextField textFieldApellidoModificar;
	private JTextField textFieldEmailModificar;
	private JButton btnModificarAceptar;
	private JButton btnCancelar;
	private JLabel lblcontrasena;
	private JTextField textFieldContrasenaModificar;
	private JDateChooser dateChooserFechaNacModificar;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameModificarDatos frame = new FrameModificarDatos();
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
	public FrameModificarDatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 66, 68, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(274, 66, 68, 14);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblApellido);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 151, 68, 14);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblEmail);

		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setBounds(10, 232, 131, 14);
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblFechaNac);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(279, 327, 89, 23);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnCancelar);

		textFieldNombreModificar = new JTextField();
		textFieldNombreModificar.setBounds(67, 63, 170, 20);
		contentPane.add(textFieldNombreModificar);
		textFieldNombreModificar.setColumns(10);

		textFieldApellidoModificar = new JTextField();
		textFieldApellidoModificar.setBounds(354, 63, 170, 20);
		contentPane.add(textFieldApellidoModificar);
		textFieldApellidoModificar.setColumns(10);

		textFieldEmailModificar = new JTextField();
		textFieldEmailModificar.setBounds(67, 148, 170, 20);
		contentPane.add(textFieldEmailModificar);
		textFieldEmailModificar.setColumns(10);

		btnModificarAceptar = new JButton("Aceptar");
		btnModificarAceptar.setBounds(378, 327, 146, 23);
		btnModificarAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnModificarAceptar);

		lblcontrasena = new JLabel("Contraseña");
		lblcontrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblcontrasena.setBounds(274, 151, 68, 14);
		contentPane.add(lblcontrasena);

		textFieldContrasenaModificar = new JTextField();
		textFieldContrasenaModificar.setColumns(10);
		textFieldContrasenaModificar.setBounds(354, 148, 170, 20);
		contentPane.add(textFieldContrasenaModificar);

		dateChooserFechaNacModificar = new JDateChooser();
		dateChooserFechaNacModificar.setBounds(139, 232, 98, 20);
		contentPane.add(dateChooserFechaNacModificar);
	}




	//metodo para poner los datos del usuario en los textField
	public void setUsuarioModificarDatos(Usuario usuario) {
		if (usuario != null) {
			textFieldNombreModificar.setText(usuario.getNombre());
			textFieldApellidoModificar.setText(usuario.getApellido());
			textFieldEmailModificar.setText(usuario.getEmail());
			dateChooserFechaNacModificar.setDate(usuario.getFechaNac());
		}
	}

	//getters
	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldNombreModificar() {
		return textFieldNombreModificar;
	}

	public JTextField getTextFieldApellidoModificar() {
		return textFieldApellidoModificar;
	}

	public JTextField getTextFieldEmailModificar() {
		return textFieldEmailModificar;
	}

	public JButton getBtnModificarAceptar() {
		return btnModificarAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JLabel getLblcontrasena() {
		return lblcontrasena;
	}

	public JTextField getTextFieldContrasenaModificar() {
		return textFieldContrasenaModificar;
	}

	public JDateChooser getDateChooserFechaNacModificar() {
		return dateChooserFechaNacModificar;
	}

}
