package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import conexion.Conexion;

public class Serie implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreS;
    private Double numRepeticiones;
    private String foto;
    private Double tiempoSerie;
    private Ejercicio nombreE;

    private static String coleccionPrincipal = "WORKOUT";
    private static String coleccionSecundaria = "EJERCICIO";
    private static String coleccionTerciaria = "SERIE";

    private static String fieldNombre = "Nombre";
    private static String fieldNumRepeticiones = "NumRepeticiones";
    private static String fieldFoto = "Foto";
    private static String fieldTiempoSerie = "TiempoSerie";

    // Constructores
    public Serie() {
    }

    public Serie(String nombreS, Double numRepeticiones, String foto, Double tiempoSerie, Ejercicio nombreE) {
        this.nombreS = nombreS;
        this.numRepeticiones = numRepeticiones;
        this.foto = foto;
        this.tiempoSerie = tiempoSerie;
        this.nombreE = nombreE;
    }

    // Getters y setters
    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public Double getNumRepeticiones() {
        return numRepeticiones;
    }

    public void setNumRepeticiones(Double numRepeticiones) {
        this.numRepeticiones = numRepeticiones;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getTiempoSerie() {
        return tiempoSerie;
    }

    public void setTiempoSerie(Double tiempoSerie) {
        this.tiempoSerie = tiempoSerie;
    }

    public Ejercicio getNombreE() {
        return nombreE;
    }

    public void setNombreE(Ejercicio nombreE) {
        this.nombreE = nombreE;
    }

    // OBTENER SERIE ------------------------
    public Serie mObtenerSerie(String workoutNombre, String ejercicioNombre, String serieNombre) {
        Firestore co = null;

        try {
            co = Conexion.conectar();

            DocumentSnapshot serie = co.collection(coleccionPrincipal)            //coleccion principal WORKOUT
                    .document(workoutNombre)                   //documento (workout)
                    .collection(coleccionSecundaria)           //coleccion secundaria EJERCICIO
                    .document(ejercicioNombre)                 //documento (ejercicio)
                    .collection(coleccionTerciaria)            //coleccion terciaria SERIE
                    .document(serieNombre).get().get();

            if (serie.exists()) {
                setNombreS(serie.getString(fieldNombre));
                setNumRepeticiones(serie.getDouble(fieldNumRepeticiones));
                setFoto(serie.getString(fieldFoto));
                setTiempoSerie(serie.getDouble(fieldTiempoSerie));
                setNombreE(new Ejercicio(ejercicioNombre, null, null, new Workout(workoutNombre, null, null, null)));
            }

            co.close();
            
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: Clase Serie, metodo mObtenerSerie");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return this;
    }

    // OBTENER SERIES ------------------------
    public ArrayList<Serie> mObtenerSeries(String workoutNombre, String ejercicioNombre) {
        Firestore co = null;
        ArrayList<Serie> listaSeries = new ArrayList<Serie>();

        try {
            co = Conexion.conectar();

            ApiFuture<QuerySnapshot> query = co.collection(coleccionPrincipal).document(workoutNombre).collection(coleccionSecundaria).document(ejercicioNombre).collection(coleccionTerciaria).get();

            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> series = querySnapshot.getDocuments();

            for (QueryDocumentSnapshot serie : series) {
                Serie s = new Serie();
                s.setNombreS(serie.getString(fieldNombre));
                s.setNumRepeticiones(serie.getDouble(fieldNumRepeticiones));
                s.setFoto(serie.getString(fieldFoto));
                s.setTiempoSerie(serie.getDouble(fieldTiempoSerie));
                s.setNombreE(new Ejercicio(ejercicioNombre, null, null, new Workout(workoutNombre, null, null, null)));

                listaSeries.add(s);
            }

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: Clase Serie, metodo mObtenerSeries");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaSeries;
    }
}
