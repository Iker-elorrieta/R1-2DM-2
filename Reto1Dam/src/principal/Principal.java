package principal;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControladorFrames;
import controlador.Metodos;
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
	static FrameLogin login;
	static FrameRegistro registro;
	public static void main(String[] args) {
		// TODO Auto-generated method stub		

		//FRAME INICIAL
		login = new FrameLogin();
		registro = new FrameRegistro();
		FrameWorkoutsPrincipal workoutsPrincipal = new FrameWorkoutsPrincipal();
		FramePerfilUsuario perfilUsuario = new FramePerfilUsuario();
		FrameModificarDatos modificarDatos = new FrameModificarDatos();
		FrameHistorialWorkouts historialWorkouts = new FrameHistorialWorkouts();
		FrameWorkout workout = new FrameWorkout();
		FrameEjercicios ejercicios = new FrameEjercicios();
		FrameResumenWorkout resumenWorkout = new FrameResumenWorkout();

		login.setVisible(true);

		 new Metodos(login, registro);
		 
		//ControladorFrames controlador = new ControladorFrames(login, registro, workoutsPrincipal, perfilUsuario, modificarDatos, historialWorkouts, workout, ejercicios, resumenWorkout);




	}
	public FrameLogin getLogin () {
		return login;
	}
	
	public FrameRegistro getRegistro () {
		return registro;
	}
}

