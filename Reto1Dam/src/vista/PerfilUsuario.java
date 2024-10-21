package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import modelo.Usuario;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PerfilUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldContrasena;
	private JTextField textFieldEmail;

	/**
	 * Create the panel.
	 */
	public PerfilUsuario(VentanaPrincipal vp, ArrayList<Usuario> usuarios) {
		setSize(640, 510);
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(40, 85, 81, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(40, 145, 81, 14);
		add(lblApellido);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasena.setBounds(40, 205, 107, 14);
		add(lblContrasena);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(40, 265, 107, 14);
		add(lblEmail);
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaNac.setBounds(40, 325, 159, 14);
		add(lblFechaNac);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vp.cambioPaneles(3, usuarios);
			}
		});
		btnCancelar.setBounds(386, 460, 89, 23);
		add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(514, 460, 89, 23);
		add(btnAceptar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(150, 82, 224, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(150, 142, 224, 20);
		add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(150, 202, 224, 20);
		add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(150, 262, 224, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JDateChooser CalendarFechaNac = new JDateChooser();
		CalendarFechaNac.setBounds(199, 322, 175, 20);
		add(CalendarFechaNac);

	}
}
