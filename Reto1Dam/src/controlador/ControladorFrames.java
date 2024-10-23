package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vista.FrameWorkoutsPrincipal;
import vista.FrameLogin;
import vista.FrameModificarDatos;
import vista.FramePerfilUsuario;
import vista.FrameRegistro;

public class ControladorFrames implements ActionListener, ListSelectionListener {
	private FrameLogin login = new FrameLogin();
	private FrameRegistro registro = new FrameRegistro();
	private FrameWorkoutsPrincipal workoutsPrincipal = new FrameWorkoutsPrincipal();
	private FramePerfilUsuario perfilUsuario = new FramePerfilUsuario();
	private FrameModificarDatos modificarDatos = new FrameModificarDatos();
	
	

	public ControladorFrames(FrameLogin login, FrameRegistro registro, FrameWorkoutsPrincipal workoutsPrincipal, FramePerfilUsuario perfilUsuario,FrameModificarDatos modificarDatos) {
		this.login = login;
		this.registro = registro;
		this.workoutsPrincipal = workoutsPrincipal;
		this.perfilUsuario = perfilUsuario;
		this.modificarDatos = modificarDatos;

		addListeners();
	}

	private void addListeners() {

		//frame login
		login.getBtnLogin().addActionListener(this);
		login.getBtnRegistro().addActionListener(this);

		//frame registro
		registro.getBtnAtras().addActionListener(this);
		registro.getBtnRegistrarse().addActionListener(this);    	

		//frame principal de workouts
		workoutsPrincipal.getBtnPerfil().addActionListener(this);
		workoutsPrincipal.getBtnHistorial().addActionListener(this);
		workoutsPrincipal.getBtnSeleccionar().addActionListener(this);

		//frame perfil de usuario
		perfilUsuario.getBtnAtras().addActionListener(this);
		perfilUsuario.getBtnModificar().addActionListener(this);

		//frame modificar datos del usuario
		modificarDatos.getBtnModificarAceptar().addActionListener(this);
		modificarDatos.getBtnCancelar().addActionListener(this);
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {

		//funcion botones frame login
		if (e.getSource() == login.getBtnLogin()) {
			//comprobar que el login sea correcto
			if (Metodos.comprobarLogin(login.getTextFieldEmail(), login.getPasswordFieldContrasena())) {
				
				workoutsPrincipal.setVisible(true);
				login.dispose();
				
			} else {
				
				JOptionPane.showMessageDialog(null, "Login incorrecto.", "Error de Login", JOptionPane.ERROR_MESSAGE);
			}
		
		} else if (e.getSource() == login.getBtnRegistro()) {
			
			registro.setVisible(true);
			login.dispose();
			
		//funcion botones frame registro		
		} else if (e.getSource() == registro.getBtnAtras()) {
			
			login.setVisible(true);
			registro.dispose();
			
		} else if (e.getSource() == registro.getBtnRegistrarse()) {
			
			if(Metodos.comprobarRegistro()) {
				//metodo de guardar los datos ********************
				login.setVisible(true);
				registro.dispose();
				
			}else {
				
				JOptionPane.showMessageDialog(null, "Algún campo tiene datos incorrectos.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
			}
		//funcion botones frame workouts principal	
		} else if (e.getSource() == workoutsPrincipal.getBtnPerfil()) {

			perfilUsuario.setVisible(true);
			workoutsPrincipal.dispose();
			
		} else if (e.getSource() == workoutsPrincipal.getBtnHistorial()) {
			
			//frame historial
			
		} else if(e.getSource() == workoutsPrincipal.getBtnSeleccionar()) {
		
		//funcion botones frame perfil usuario
		} else if (e.getSource() == perfilUsuario.getBtnAtras()) {

			workoutsPrincipal.setVisible(true);
			perfilUsuario.dispose();
			
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}
}