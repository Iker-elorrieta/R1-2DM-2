package principal;

import controlador.ControladorFrames;
import modelo.Ejercicio;
import modelo.Usuario;
import modelo.Workout;
import vista.FrameEjercicios;
import vista.FrameHistorialWorkouts;
import vista.FrameLogin;
import vista.FrameModificarDatos;
import vista.FramePerfilUsuario;
import vista.FrameRegistro;
import vista.FrameResumenWorkout;
import vista.FrameWorkout;
import vista.FrameWorkoutsPrincipal;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		Usuario usuarioLogueado = Usuario.getUsuarioLogueado();
		Workout eWorkout = new Workout();
		Ejercicio ejercicio = new Ejercicio();

		FrameLogin login = new FrameLogin();
		FrameRegistro registro = new FrameRegistro();
		FrameWorkoutsPrincipal workoutsPrincipal = new FrameWorkoutsPrincipal(usuario);
		FramePerfilUsuario perfilUsuario = new FramePerfilUsuario(usuarioLogueado);
		FrameModificarDatos modificarDatos = new FrameModificarDatos();
		FrameHistorialWorkouts historialWorkouts = new FrameHistorialWorkouts(usuarioLogueado);
		FrameWorkout workout = new FrameWorkout(eWorkout);
		FrameEjercicios ejercicios = new FrameEjercicios(eWorkout, ejercicio);
		FrameResumenWorkout resumenWorkout = new FrameResumenWorkout();


		ControladorFrames controlador = new ControladorFrames(login, registro, workoutsPrincipal, perfilUsuario, modificarDatos, historialWorkouts, workout, ejercicios, resumenWorkout, usuario, usuarioLogueado);


		login.setVisible(true);
		
	}

}