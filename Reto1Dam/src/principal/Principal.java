package principal;

import controlador.ControladorFrames;
import vista.FrameLogin;
import vista.FrameModificarDatos;
import vista.FramePerfilUsuario;
import vista.FrameRegistro;
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
        
		
		ControladorFrames controlador = new ControladorFrames(login, registro, workoutsPrincipal, perfilUsuario, modificarDatos);
        login.setVisible(true);

	}

}
