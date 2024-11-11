package modelo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GenerarBackups {

	public static void main(String[] args) {
		escribirUsuariosEnArchivo(new Usuario().mObtenerTodosLosUsuarios());
		escribirWorkoutsEnArchivo(new Workout().mObtenerWorkouts());
	}

	private static final String USUARIOSFILEROUTE = "Ficheros/usuarios.dat";
	private static final String WORKOUTSFILEROUTE = "Ficheros/workouts.dat";

	private static void escribirUsuariosEnArchivo(ArrayList<Usuario> usuarios) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USUARIOSFILEROUTE))) {
			for (Usuario usu : usuarios) {
				oos.writeObject(usu);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void escribirWorkoutsEnArchivo(ArrayList<Workout> workouts) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(WORKOUTSFILEROUTE))) {
			for (Workout wk : workouts) {
				oos.writeObject(wk);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
