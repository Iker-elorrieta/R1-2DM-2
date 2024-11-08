package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import conexion.Conexion;

public class Ejercicio {
	private String nombreE;
	private String descripcion;
	private Double tiempoDescanso;
	private Workout nombreW;

	private static String coleccionPrincipal = "WORKOUT";
	private static String coleccionSecundaria = "EJERCICIO";

	private static String fieldNombre = "Nombre";
	private static String fieldDescripcion = "Descripcion";
	private static String fieldTiempodescanso = "TiempoDescanso";
	//private static String fieldNombreWorkout = "NombreWorkout";

	// Constructores
	public Ejercicio() {
	}

	public Ejercicio(String nombreE, String descripcion, Double tiempoDescanso, Workout nombreW) {
		this.nombreE = nombreE;
		this.descripcion = descripcion;
		this.tiempoDescanso = tiempoDescanso;
		this.nombreW = nombreW;
	}

	// Getters y setters
	public String getNombreE() {
		return nombreE;
	}

	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getTiempoDescanso() {
		return tiempoDescanso;
	}

	public void setTiempoDescanso(Double tiempoDescanso) {
		this.tiempoDescanso = tiempoDescanso;
	}

	public Workout getNombreW() {
		return nombreW;
	}

	public void setNombreW(Workout nombreW) {
		this.nombreW = nombreW;
	}

	// OBTENER EJERCICIO ------------------------
	public Ejercicio mObtenerEjercicio(String nombreWorkout, String nombreEjercicio) {
		Firestore co = null;

		try {
			co = Conexion.conectar();

			DocumentSnapshot ejercicio = co.collection(coleccionPrincipal)   //coleccion principal WORKOUT
					.document(nombreWorkout)                   				//nombre del documento (workout) en el que se encuentra
					.collection(coleccionSecundaria)           				//coleccion en la que se encuentra (EJERCICIO)
					.document(nombreEjercicio).get().get();

			if (ejercicio.exists()) {
				setNombreE(ejercicio.getString(fieldNombre));
				setDescripcion(ejercicio.getString(fieldDescripcion));
				setTiempoDescanso(ejercicio.getDouble(fieldTiempodescanso));
				setNombreW(new Workout(nombreWorkout, null, null, null));
			}
			
			co.close();

		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Ejercicio, metodo mObtenerEjercicio");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this;
	}

	// OBTENER EJERCICIOS ------------------------
	public ArrayList<Ejercicio> mObtenerEjercicios(String nombreWorkout) {
		Firestore co = null;
		ArrayList<Ejercicio> listaEjercicios = new ArrayList<Ejercicio>();

		try {
			co = Conexion.conectar();

			ApiFuture<QuerySnapshot> query = co.collection(coleccionPrincipal).document(nombreWorkout).collection(coleccionSecundaria).get();

			QuerySnapshot querySnapshot = query.get();
			List<QueryDocumentSnapshot> ejercicios = querySnapshot.getDocuments();

			for (QueryDocumentSnapshot ejercicio : ejercicios) {
				Ejercicio e = new Ejercicio();
				e.setNombreE(ejercicio.getString(fieldNombre));
				e.setDescripcion(ejercicio.getString(fieldDescripcion));
				e.setTiempoDescanso(ejercicio.getDouble(fieldTiempodescanso));
				e.setNombreW(new Workout(nombreWorkout, null, null, null));

				listaEjercicios.add(e);
			}

			co.close();
			
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Ejercicio, metodo mObtenerEjercicios");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaEjercicios;
	}
}
