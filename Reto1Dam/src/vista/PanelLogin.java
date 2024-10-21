package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Usuario;

public class PanelLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textEmail;
	private JTextField textPassword;

	public PanelLogin(VentanaPrincipal vp,ArrayList<Usuario> usuarios) {
		setSize(1280, 618);
		setLayout(null);
		
		JLabel  logo = new JLabel(new ImageIcon("src/Imagen/logo.jpeg"));
		logo.setSize(700, 494);
		logo.setLocation(22, 39);
		this.add(logo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(788, 147, 198, 66);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 30));
		add(lblEmail);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(732, 249, 273, 66);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 30));
		add(lblPassword);
		
		//JLabel lblError = new JLabel("Algun campo es incorrecto");
		//lblError.setBounds(549, 345, 500, 60);
		//lblError.setFont(new Font("Arial", Font.PLAIN, 30));
		//lblError.setVisible(false);
		//lblError.setForeground(Color.red);
		//add(lblError);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textEmail.setBounds(914, 151, 273, 56);
		add(textEmail);
		

		textPassword = new JTextField();
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textPassword.setBounds(914, 255, 273, 52);
		add(textPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.setBounds(990, 397, 226, 77);
		add(btnLogin);

		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRegistro.setBounds(732, 397, 213, 77);
		add(btnRegistro);
		
		
		btnRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vp.cambioPaneles(2, usuarios);
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < usuarios.size(); i++) {
					if(textEmail.getText().equals(usuarios.get(i).getEmail()) && textPassword.getText().equals(usuarios.get(i).getContrasena())) {
						//lblError.setVisible(false);
						vp.cambioPaneles(8, usuarios);
					}else {
						//lblError.setVisible(true);
						System.out.println("Usuario incorrecto");
					}
					
				}
			}
		});

		
	}

}
