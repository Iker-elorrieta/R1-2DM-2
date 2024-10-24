package principal;

import controlador.ControladorFrames;
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
		
		//FRAME INICIAL
		FrameLogin login = new FrameLogin();
		FrameRegistro registro = new FrameRegistro();
		FrameWorkoutsPrincipal workoutsPrincipal = new FrameWorkoutsPrincipal();
		FramePerfilUsuario perfilUsuario = new FramePerfilUsuario();
		FrameModificarDatos modificarDatos = new FrameModificarDatos();
		FrameHistorialWorkouts historialWorkouts = new FrameHistorialWorkouts();
		FrameWorkout workout = new FrameWorkout();
		FrameEjercicios ejercicios = new FrameEjercicios();
		FrameResumenWorkout resumenWorkout = new FrameResumenWorkout();
        
		
		ControladorFrames controlador = new ControladorFrames(login, registro, workoutsPrincipal, perfilUsuario, modificarDatos, historialWorkouts, workout, ejercicios, resumenWorkout);
        login.setVisible(true);

	}

}
