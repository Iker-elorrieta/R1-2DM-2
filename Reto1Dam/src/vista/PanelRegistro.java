package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

//import controlador.EscrituraUsuario;
import modelo.Usuario;

public class PanelRegistro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textPassword;
	private JTextField textFechaNacimiento;

	public PanelRegistro(VentanaPrincipal vp, ArrayList<Usuario> usuarios) {
		setSize(1280, 720);
		setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(490, 134, 120, 40);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 25));
		add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(490, 175, 120, 40);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 25));
		add(lblApellido);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(490, 226, 220, 26);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		add(lblEmail);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(490, 263, 220, 40);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 25));
		add(lblPassword);
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setFont(new Font("Arial", Font.PLAIN, 25));
		lblFechaNac.setBounds(454, 315, 256, 40);
		add(lblFechaNac);

		//JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		//lblFechaNacimiento.setBounds(490, 303, 220, 40);
		//lblFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 25));
		//add(lblFechaNacimiento);

		textNombre = new JTextField();
		textNombre.setBounds(713, 145, 170, 26);
		add(textNombre);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(713, 186, 170, 26);
		add(textApellido);

		textEmail = new JTextField();
		textEmail.setBounds(713, 229, 170, 23);
		add(textEmail);
		textEmail.setColumns(10);

		textPassword = new JTextField();
		textPassword.setBounds(713, 275, 170, 24);
		add(textPassword);
		textPassword.setColumns(10);

		//textFechaNacimiento = new JTextField();
		//textFechaNacimiento.setColumns(10);
		//textFechaNacimiento.setBounds(713, 314, 170, 26);
		//add(textFechaNacimiento);
		JDateChooser fechaNacimientoCalendar = new JDateChooser();
		fechaNacimientoCalendar.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
        fechaNacimientoCalendar.setBounds(708, 325, 175, 20);
        add(fechaNacimientoCalendar);

        JTextFieldDateEditor editor = (JTextFieldDateEditor) fechaNacimientoCalendar.getDateEditor();
        editor.setEditable(false);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.setBounds(490, 471, 157, 63);
		add(btnLogin);

		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRegistro.setBounds(831, 471, 160, 63);
		add(btnRegistro);
		
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vp.cambioPaneles(1, usuarios);
			}
		});
		
		btnRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario newusuario = new Usuario();
				newusuario.setNombre(textNombre.getText());
				newusuario.setApellido(textApellido.getText());
				newusuario.setEmail(textEmail.getText());
				newusuario.setContrasena(textPassword.getText());
				newusuario.setFechanac(textFechaNacimiento.getText());
				usuarios.add(newusuario);
				//EscrituraUsuario eu = new EscrituraUsuario();
				//eu.escrituraUsuario(usuarios);
				vp.cambioPaneles(2, usuarios);
			}
		});

	}
}
