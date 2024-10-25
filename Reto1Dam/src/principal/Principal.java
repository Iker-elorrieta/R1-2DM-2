package principal;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControladorFrames;
<<<<<<< HEAD
import controlador.Metodos;
=======
import modelo.Usuario;
>>>>>>> branch 's1' of https://github.com/Iker-elorrieta/R1-2DM-2.git
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
		Usuario usuario = new Usuario();
		
		//FRAME INICIAL

		login = new FrameLogin();
		registro = new FrameRegistro();
		FrameWorkoutsPrincipal workoutsPrincipal = new FrameWorkoutsPrincipal();
		FramePerfilUsuario perfilUsuario = new FramePerfilUsuario();

		FrameLogin login = new FrameLogin();
		FrameRegistro registro = new FrameRegistro();
		FrameWorkoutsPrincipal workoutsPrincipal = new FrameWorkoutsPrincipal(usuario);
		FramePerfilUsuario perfilUsuario = new FramePerfilUsuario(usuario);
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

