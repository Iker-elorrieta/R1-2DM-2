package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Date;
import vista.FrameWorkoutsPrincipal;
import vista.FrameEjercicios;
import vista.FrameHistorialWorkouts;
import vista.FrameLogin;
import vista.FrameModificarDatos;
import vista.FramePerfilUsuario;
import vista.FrameRegistro;
import vista.FrameResumenWorkout;
import vista.FrameWorkout;
import modelo.Usuario;

public class ControladorFrames implements ActionListener, ListSelectionListener {
	Usuario usuario = new Usuario();
	Usuario usuarioLogueado = Usuario.getUsuarioLogueado();

	private FrameLogin login = new FrameLogin();
	private FrameRegistro registro = new FrameRegistro();
	private FrameWorkoutsPrincipal workoutsPrincipal = new FrameWorkoutsPrincipal(usuario);
	private FramePerfilUsuario perfilUsuario = new FramePerfilUsuario(usuarioLogueado);
	private FrameModificarDatos modificarDatos = new FrameModificarDatos();
	private FrameHistorialWorkouts historialWorkouts = new FrameHistorialWorkouts();
	private FrameWorkout workout = new FrameWorkout();
	private FrameEjercicios ejercicios = new FrameEjercicios();
	private FrameResumenWorkout resumenWorkout = new FrameResumenWorkout();


	public ControladorFrames(FrameLogin login, FrameRegistro registro, FrameWorkoutsPrincipal workoutsPrincipal, FramePerfilUsuario perfilUsuario,FrameModificarDatos modificarDatos, FrameHistorialWorkouts historialWorkouts,
			FrameWorkout workout, FrameEjercicios ejercicios, FrameResumenWorkout resumenWorkout) {
		this.login = login;
		this.registro = registro;
		this.workoutsPrincipal = workoutsPrincipal;
		this.perfilUsuario = perfilUsuario;
		this.modificarDatos = modificarDatos;
		this.historialWorkouts = historialWorkouts;
		this.workout = workout;
		this.ejercicios = ejercicios;
		this.resumenWorkout = resumenWorkout;

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

		//frame historial de workouts
		historialWorkouts.getBtnAtras().addActionListener(this);

		//frame del workout elegido
		workout.getBtnAtras().addActionListener(this);
		workout.getBtnIniciar().addActionListener(this);

		//frame de los ejercicios del workout elegido
		ejercicios.getBtnAtras().addActionListener(this);
		ejercicios.getBtnInicioPausa().addActionListener(this);
		ejercicios.getBtnSalir().addActionListener(this);

		//frame resumen del workout realizado
		resumenWorkout.getBtnOk().addActionListener(this);

	}



	@Override
	public void actionPerformed(ActionEvent e) {

		//funcion botones frame login ---------------------------------------------- BOTONES FRAME LOGIN
		if (e.getSource() == login.getBtnLogin()) {
			//comprobar que el login sea correcto
			String email = login.getTextFieldEmail().getText();
			String contrasena = new String(login.getPasswordFieldContrasena().getPassword());

			if (Usuario.comprobarLogin(email, contrasena)) {
				Usuario usuario = Usuario.mObtenerUsuario(email);

				if(usuario != null) {

					Usuario.setUsuarioLogueado(usuario);
					this.usuarioLogueado = usuario;

					//workoutsPrincipal.setVisible(true);
					FrameWorkoutsPrincipal.cargarFrameWorkoutsPrincipal(usuario);					
					login.dispose();
				}
			}
		} else if (e.getSource() == login.getBtnRegistro()) {

			registro.setVisible(true);
			login.dispose();


		}
		//funcion botones frame registro ---------------------------------------------- BOTONES FRAME REGISTRO
		else if (e.getSource() == registro.getBtnAtras()) {

			login.setVisible(true);
			registro.dispose();

		} else if (e.getSource() == registro.getBtnRegistrarse()) {

			String nombre = registro.getTextFieldNombre().getText();
			String apellido = registro.getTextFieldApellido().getText();
			String email = registro.getTextFieldEmail().getText();
			String contrasena = new String(registro.getPasswordFieldContrasena().getPassword());
			Date fechaNac = registro.getDateChooserFechaNac().getDate();

			if(Metodos.comprobarRegistro(nombre, apellido, email, contrasena, fechaNac)) {
				Usuario.mRegistrarUsuario(nombre, apellido, email, contrasena, fechaNac);
				login.setVisible(true);
				registro.dispose();

			}else {

				JOptionPane.showMessageDialog(null, "Algún campo tiene datos incorrectos.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
			}
		}
		//funcion botones frame workouts principal ---------------------------------------------- BOTONES FRAME WORKOUTS PRINCIPAL
		else if (e.getSource() == workoutsPrincipal.getBtnPerfil()) {

			if (usuarioLogueado != null) {

				//perfilUsuario.setVisible(true);
				FramePerfilUsuario.cargarFramePerfilUsuario(usuarioLogueado);
				workoutsPrincipal.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == workoutsPrincipal.getBtnHistorial()) {

			historialWorkouts.setVisible(true);
			workoutsPrincipal.dispose();

		} else if(e.getSource() == workoutsPrincipal.getBtnSeleccionar()) {

			workout.setVisible(true);
			workoutsPrincipal.dispose();


		}
		//funcion botones frame workout ---------------------------------------------- BOTONES FRAME WORKOUT
		else if(e.getSource() == workout.getBtnAtras()) {

			workoutsPrincipal.setVisible(true);
			workout.dispose();

		} else if(e.getSource() == workout.getBtnIniciar()) {

			//*


		}
		//funcion botones frame ejercicio ---------------------------------------------- BOTONES FRAME EJERCICIOS
		else if (e.getSource() == ejercicios.getBtnAtras()) {

			workout.setVisible(true);
			ejercicios.dispose();
		} else if(e.getSource() == ejercicios.getBtnInicioPausa()) {

			//*cronometro

		} else if (e.getSource() == ejercicios.getBtnSalir()) {

			//*
			//guardar los datos en el historial
			resumenWorkout.setVisible(true);
			ejercicios.dispose();

		} else if(e.getSource() == resumenWorkout.getBtnOk()) {

			workoutsPrincipal.setVisible(true);
			resumenWorkout.dispose();


		} else if (e.getSource() == historialWorkouts.getBtnAtras()) {

			workoutsPrincipal.setVisible(true);
			historialWorkouts.dispose();

		}
		//funcion botones frame perfil usuario ---------------------------------------------- BOTONES FRAME PERFIL USUARIO
		else if (e.getSource() == perfilUsuario.getBtnAtras()) {

			workoutsPrincipal.setVisible(true);
			perfilUsuario.dispose();

		} else if (e.getSource() == perfilUsuario.getBtnModificar()) {

			modificarDatos.setVisible(true);
			perfilUsuario.dispose();


		}
		//funciones botones frame modificar datos ---------------------------------------------- BOTONES FRAME MODIFICAR DATOS
		else if(e.getSource() == modificarDatos.getBtnCancelar()) {

			perfilUsuario.setVisible(true);
			modificarDatos.dispose();

		}else if (e.getSource() == modificarDatos.getBtnModificarAceptar()) {

			if(Metodos.modificarDatos()) {

				JOptionPane.showMessageDialog(null, "Datos modificados.", "Modificar datos", JOptionPane.INFORMATION_MESSAGE);

			}else {

				JOptionPane.showMessageDialog(null, "Algún campo tiene datos incorrectos.", "Error de Modificar", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}
}