package vista;

import java.util.ArrayList;
import javax.swing.JFrame;
import controlador.LecturaUsuario;
import modelo.Usuario;

public class VentanaPrincipal extends JFrame {

	public static VentanaPrincipal frame;
	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {
		setSize(1280, 720);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}

	public void cambioPaneles(int opcion, ArrayList<Usuario> usuarios) {
		// TODO gestor que cambia de paneles

		switch (opcion) {

		case 1:
			setContentPane(new PanelLogin(this, usuarios));
			break;
		case 2:
			setContentPane(new PanelRegistro(this, usuarios));
			break;
		case 3:
			setContentPane(new WorkoutsPrincipal(this, usuarios));
			break;
		case 4:
			setContentPane(new PerfilUsuario(this, usuarios));
			break;
		}
	}

	public static void main(String[] args) {
		ArrayList<Usuario> usuarios = LecturaUsuario.leerUsuario();
		VentanaPrincipal vp = new VentanaPrincipal();
		vp.cambioPaneles(2, usuarios);

	}

}
