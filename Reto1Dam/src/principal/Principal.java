package principal;

import controlador.ControladorFrames;
import vista.FramePerfilUsuario;
import vista.FrameWorkoutsPrincipal;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create instances of your frames
        FrameWorkoutsPrincipal workoutsPrincipal = new FrameWorkoutsPrincipal();
        FramePerfilUsuario perfilUsuario = new FramePerfilUsuario();

        // Create the controller and pass the frames to it
        ControladorFrames controladorFrames = new ControladorFrames(workoutsPrincipal, perfilUsuario);

        // Show the main frame initially
        workoutsPrincipal.setVisible(true);

	}

}
