package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import conexion.Conexion;

public class HistoricoWorkouts {
	// private Workout nombreW;
	// private Workout nivel;
	private String nombreW;
	private Double nivel;
	private Double tiempoTotal;
	private Double tiempoPrevisto;
	private Date fecha;
	private Double ejerciciosCompletados;

	private static String coleccionPrincipal = "USUARIO";
	// private static String coleccionPrincipal2 = "WORKOUT";
	private static String coleccionSecundaria = "HISTORIALWORKOUTS";

	private static String fieldNombreWorkout = "Nombre";
	private static String fieldNivel = "Nivel";
	private static String fieldTiempoTotal = "TiempoTotal";
	private static String fieldTiempoPrevisto = "TiempoPrevisto";
	private static String fieldFecha = "Fecha";
	private static String fieldCompletado = "Completado";

	// Constructores
	public HistoricoWorkouts() {
	}

	// Workout nombreW,Workout nivel
	public HistoricoWorkouts(String nombreW, Double nivel, Double tiempoTotal, Double tiempoPrevisto, Date fecha,
			Double ejerciciosCompletados) {
		this.nombreW = nombreW;
		this.nivel = nivel;
		this.tiempoTotal = tiempoTotal;
		this.tiempoPrevisto = tiempoPrevisto;
		this.fecha = fecha;
		this.ejerciciosCompletados = ejerciciosCompletados;
	}

	// Getters y setters
	/*
	 * public Workout getNombreW() { return nombreW; }
	 */

	public String getNombreW() {
		return nombreW;
	}

	/*
	 * public void setNombreW(Workout nombreW) { this.nombreW = nombreW; }
	 */

	public void setNombreW(String nombreW) {
		this.nombreW = nombreW;
	}

	/*
	 * public Workout getNivel() { return nivel; }
	 */

	public Double getNivel() {
		return nivel;
	}

	public void setNivel(Double nivel) {
		this.nivel = nivel;
	}

	/*
	 * public void setNivel(Workout nivel) { this.nivel = nivel; }
	 */

	public Double getTiempoTotal() {
		return tiempoTotal;
	}

	public void setTiempoTotal(Double tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

	public Double getTiempoPrevisto() {
		return tiempoPrevisto;
	}

	public void setTiempoPrevisto(Double tiempoPrevisto) {
		this.tiempoPrevisto = tiempoPrevisto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getEjerciciosCompletados() {
		return ejerciciosCompletados;
	}

	public void setEjerciciosCompletados(Double ejerciciosCompletados) {
		this.ejerciciosCompletados = ejerciciosCompletados;
	}

	// // OBTENER HISTORICOWORKOUT ------------------------
	// public HistoricoWorkouts mObtenerHistoricoWorkout(String emailUsuario) {
	// Firestore co = null;
	// HistoricoWorkouts historicoWorkout = new HistoricoWorkouts();
	//
	// try {
	// co = Conexion.conectar();
	//
	// // Consulta para obtener el documento del usuario usando su email
	// CollectionReference usuariosRef = co.collection("USUARIO");
	// Query query = usuariosRef.whereEqualTo("Email", emailUsuario);
	// ApiFuture<QuerySnapshot> querySnapshot = query.get();
	//
	// List<QueryDocumentSnapshot> documentosUsuario =
	// querySnapshot.get().getDocuments();
	//
	// // Verificamos si encontramos algún usuario con el email proporcionado
	// if (!documentosUsuario.isEmpty()) {
	// DocumentSnapshot documentoUsuario = documentosUsuario.get(0); // Supongamos
	// que solo hay un usuario con ese email
	//
	// // Ahora obtenemos el workout específico desde la subcolección
	// HISTORIALWORKOUTS usando el IDWorkout
	// DocumentSnapshot historico = documentoUsuario.getReference()
	// .collection("HISTORIALWORKOUTS") // Colección secundaria HISTORIALWORKOUTS
	// .document(IDWorkout) // Documento del workout específico
	// .get().get();
	//
	// // Verificamos si el workout existe
	// if (historico.exists()) {
	// historicoWorkout.setNombreW(new Workout(historico.getString("NombreWorkout"),
	// null, null, null));
	// historicoWorkout.setNivel(historico.getString("Nivel"));
	// historicoWorkout.setTiempoTotal(historico.getDouble("TiempoTotal"));
	// historicoWorkout.setTiempoPrevisto(historico.getDouble("TiempoPrevisto"));
	// historicoWorkout.setFecha(historico.getDate("Fecha"));
	// historicoWorkout.setEjerciciosCompletados(historico.getDouble("Completado"));
	// }
	// } else {
	// System.out.println("No se encontró un usuario con el email: " +
	// emailUsuario);
	// }
	//
	// } catch (InterruptedException | ExecutionException e) {
	// System.out.println("Error: Clase HistoricoWorkouts, metodo
	// mObtenerHistoricoWorkout");
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// return historicoWorkout;
	// }

	// OBTENER HISTORICOWORKOUTS ------------------------
	public ArrayList<HistoricoWorkouts> mObtenerHistoricoWorkouts(String email) {
		Firestore co = null;
		ArrayList<HistoricoWorkouts> listaHistoricoWorkouts = new ArrayList<>();

		try {
			co = Conexion.conectar();

			// Consulta para obtener el documento del usuario usando su email 
			CollectionReference usuariosRef = co.collection(coleccionPrincipal);
			Query query = usuariosRef.whereEqualTo("Email", email);
			ApiFuture<QuerySnapshot> querySnapshot = query.get();

			List<QueryDocumentSnapshot> documentosUsuario = querySnapshot.get().getDocuments();

			// Verificamos si encontramos algún usuario con el email proporcionado
			if (!documentosUsuario.isEmpty()) {
				DocumentSnapshot documentoUsuario = documentosUsuario.get(0); // Supongamos que solo hay un usuario con
																				// ese email

				// Obtener la referencia a la subcolección HISTORIALWORKOUTS
				CollectionReference historicoWorkoutsRef = documentoUsuario.getReference().collection(coleccionSecundaria);
				ApiFuture<QuerySnapshot> historialSnapshot = historicoWorkoutsRef.get();

				for (DocumentSnapshot doc : historialSnapshot.get().getDocuments()) {
					if (doc.exists()) {
						HistoricoWorkouts workout = new HistoricoWorkouts();
						workout.setEjerciciosCompletados(doc.getDouble(fieldCompletado));
						workout.setFecha(doc.getDate(fieldFecha));
						workout.setTiempoPrevisto(doc.getDouble(fieldTiempoPrevisto));
						workout.setTiempoTotal(doc.getDouble(fieldTiempoTotal));
						// workout.setNombreW(new Workout(fieldNombreWorkout, null, null, null));
						// workout.setNivel(new Workout(fieldNivel, null, null, null));
						DocumentReference dirRef = (DocumentReference) doc.getData().get(fieldNivel);
						if (dirRef != null) {
							workout.setNombreW(dirRef.get().get().getString(fieldNombreWorkout));
							double nivelWork = dirRef.get().get().getDouble(fieldNivel);
							workout.setNivel(nivelWork);
						}

						listaHistoricoWorkouts.add(workout);
					}
				}
			} else {
				System.out.println("No se encontró un usuario con el email: " + email);
			}

		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase HistoricoWorkouts, metodo mObtenerHistoricoWorkouts");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaHistoricoWorkouts;
	}

}
