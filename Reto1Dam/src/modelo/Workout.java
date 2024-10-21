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

public class Workout {
	private String nombreW;
	private Double numEjercicios;
	private Double nivel;
	private String video;

	private static String collectionName = "WORKOUT";
	private static String fieldNombre = "Nombre";
	private static String fieldNumEjer = "NumEjercicios";
	private static String fieldNivel = "Nivel";
	private static String fieldVideo = "Video";

	//constructores
	public Workout() {

	}

	public Workout(String nombreW, Double numEjercicios, Double nivel, String video) {
		super();
		this.nombreW = nombreW;
		this.numEjercicios = numEjercicios;
		this.nivel = nivel;
		this.video = video;
	}


	//getters y setters
	public String getNombreW() {
		return nombreW;
	}

	public void setNombreW(String nombreW) {
		this.nombreW = nombreW;
	}

	public Double getNumEjercicios() {
		return numEjercicios;
	}

	public void setNumEjercicios(Double numEjercicios) {
		this.numEjercicios = numEjercicios;
	}

	public Double getNivel() {
		return nivel;
	}

	public void setNivel(Double nivel) {
		this.nivel = nivel;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}


	//OBTENER WORKOUT ------------------------
	public Workout mObtenerWorkout() {
		Firestore co =null;

		try {			
			co= Conexion.conectar();

			DocumentSnapshot workout = co.collection(collectionName).document(nombreW).get().get();

			setNombreW(workout.getString(fieldNombre));
			setNumEjercicios(workout.getDouble(fieldNumEjer));
			setNivel(workout.getDouble(fieldNivel));
			setVideo(workout.getString(fieldVideo));


		} catch ( InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Workout, metodo mObtenerWorkouts");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this;
	}

	//OBTENER WORKOUTS ------------------------
	public ArrayList<Workout> mObtenerWorkouts() {
		Firestore co =null;

		ArrayList<Workout> listaWorkouts = new 	ArrayList<Workout>();

		try {			
			co= Conexion.conectar();

			ApiFuture<QuerySnapshot> query = co.collection(collectionName).get();

			QuerySnapshot querySnapshot = query.get();
			List<QueryDocumentSnapshot> workouts = querySnapshot.getDocuments();
			
			for (QueryDocumentSnapshot workout : workouts) {

				Workout w = new Workout();

				w.setNombreW(workout.getString(fieldNombre));
				w.setNumEjercicios(workout.getDouble(fieldNumEjer));
				w.setNivel(workout.getDouble(fieldNivel));
				w.setVideo(workout.getString(fieldVideo));

				listaWorkouts.add(w);
			}


		} catch ( InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Workout, metodo mObtenerWorkouts");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaWorkouts;
	}



}
