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
	
	private FrameLogin login;
	private FrameRegistro registro;
	private FrameWorkoutsPrincipal workoutsPrincipal;
	private FramePerfilUsuario perfilUsuario;
	private FrameModificarDatos modificarDatos;
	private FrameHistorialWorkouts historialWorkouts;
	private FrameWorkout workout;
	private FrameEjercicios ejercicios;
	private FrameResumenWorkout resumenWorkout;
	private Usuario usuarioLogueado;


	public ControladorFrames(FrameLogin login, FrameRegistro registro, FrameWorkoutsPrincipal workoutsPrincipal, FramePerfilUsuario perfilUsuario,FrameModificarDatos modificarDatos, FrameHistorialWorkouts historialWorkouts,
			FrameWorkout workout, FrameEjercicios ejercicios, FrameResumenWorkout resumenWorkout, Usuario usuario, Usuario usuarioLogueado) {
		this.login = login;
		this.registro = registro;
		this.workoutsPrincipal = workoutsPrincipal;
		this.perfilUsuario = perfilUsuario;
		this.modificarDatos = modificarDatos;
		this.historialWorkouts = historialWorkouts;
		this.workout = workout;
		this.ejercicios = ejercicios;
		this.resumenWorkout = resumenWorkout;
		this.usuarioLogueado = usuarioLogueado;

		
		addListeners();
		
		
		login.setVisible(true);
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
		workoutsPrincipal.getBtnFiltro().addActionListener(this);

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
		workout.getBtnEntrar().addActionListener(this);

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
					
					workoutsPrincipal.insertarWorkouts();
					workoutsPrincipal.setVisible(true);					
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

				perfilUsuario.setUsuarioDatos(usuarioLogueado);
				perfilUsuario.setVisible(true);
				
				workoutsPrincipal.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == workoutsPrincipal.getBtnHistorial()) {
			String email = usuarioLogueado.getEmail();
			historialWorkouts.insertarHistoricos(email);

			historialWorkouts.setVisible(true);
			workoutsPrincipal.dispose();

		} else if(e.getSource() == workoutsPrincipal.getBtnSeleccionar()) {
			
			String nombreWorkout = workoutsPrincipal.getNombreWorkout();
			
			workout.getLblNombreWorkout().setText(nombreWorkout);
			
			workout.insertarEjercicios(nombreWorkout);

			workout.setVisible(true);
			workoutsPrincipal.dispose();


		}else if(e.getSource() == workoutsPrincipal.getBtnFiltro()) {
			
			workoutsPrincipal.insertarWorkouts();
			
		}
		//funcion botones frame workout ---------------------------------------------- BOTONES FRAME WORKOUT
		else if(e.getSource() == workout.getBtnAtras()) {

			workoutsPrincipal.setVisible(true);
			workout.dispose();

		} else if(e.getSource() == workout.getBtnEntrar()) {

			String descripcionEjercicio = workout.getDescripcionEjercicioTabla();
			String nombreWorkout = workout.getNombreWorkoutTabla();
			String nombreEjercicio = workout.getNombreEjercicioTabla();
			
			ejercicios.getLblNombreWorkout().setText(nombreWorkout);
			ejercicios.getLblNombreEjercicio().setText(nombreEjercicio);
			ejercicios.getTextAreaDescripcion().setText(descripcionEjercicio);
			
			ejercicios.insertarSeries(nombreWorkout, nombreEjercicio);
			
			ejercicios.setVisible(true);
			workout.dispose();


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

			
			modificarDatos.setUsuarioModificarDatos(usuarioLogueado);
			modificarDatos.setVisible(true);
			perfilUsuario.dispose();


		}
		//funciones botones frame modificar datos ---------------------------------------------- BOTONES FRAME MODIFICAR DATOS
		else if(e.getSource() == modificarDatos.getBtnCancelar()) {

			perfilUsuario.setVisible(true);
			modificarDatos.dispose();

		}else if (e.getSource() == modificarDatos.getBtnModificarAceptar()) {
			
			String nombre = modificarDatos.getTextFieldNombreModificar().getText();
			String apellido = modificarDatos.getTextFieldApellidoModificar().getText();
			String email = modificarDatos.getTextFieldEmailModificar().getText();
			String contrasena = new String(registro.getPasswordFieldContrasena().getPassword());
			Date fechaNac = modificarDatos.getDateChooserFechaNacModificar().getDate();

			if(Metodos.comprobarModificarDatos(nombre, apellido, email, fechaNac)) {
				
				email = Usuario.mModificarDatos(usuarioLogueado, nombre, apellido, email, contrasena, fechaNac);

				usuarioLogueado.setEmail(email);
				
				JOptionPane.showMessageDialog(null, "Datos modificados.", "Modificar datos", JOptionPane.INFORMATION_MESSAGE);
				
				modificarDatos.setUsuarioModificarDatos(usuarioLogueado);
				perfilUsuario.setUsuarioDatos(Usuario.mObtenerUsuario(email));
				perfilUsuario.setVisible(true);
				modificarDatos.dispose();

			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}
}