package principal;

import controlador.ControladorFrames;
import modelo.Usuario;
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
		
		//FRAME INICIAL
		FrameLogin login = new FrameLogin();
		login.setVisible(true);
		
		FrameRegistro registro = new FrameRegistro();
		FrameWorkoutsPrincipal workoutsPrincipal = new FrameWorkoutsPrincipal(usuario);
		FramePerfilUsuario perfilUsuario = new FramePerfilUsuario(usuario);
		FrameModificarDatos modificarDatos = new FrameModificarDatos();
		FrameHistorialWorkouts historialWorkouts = new FrameHistorialWorkouts();
		FrameWorkout workout = new FrameWorkout();
		FrameEjercicios ejercicios = new FrameEjercicios();
		FrameResumenWorkout resumenWorkout = new FrameResumenWorkout();
        
		
		ControladorFrames controlador = new ControladorFrames(login, registro, workoutsPrincipal, perfilUsuario, modificarDatos, historialWorkouts, workout, ejercicios, resumenWorkout);
        

	}

}
