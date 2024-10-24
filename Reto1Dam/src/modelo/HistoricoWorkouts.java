package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import conexion.Conexion;

public class HistoricoWorkouts {
    private Workout nombreW;
    private String nivel;
    private Double tiempoTotal;
    private Double tiempoPrevisto;
    private Date fecha;
    private Double ejerciciosCompletados;

    private static String coleccionPrincipal = "USUARIO";
    private static String coleccionSecundaria = "HISTORIALWORKOUTS";

    private static String fieldNombreWorkout = "NombreWorkout";
    private static String fieldNivel = "Nivel";
    private static String fieldTiempoTotal = "TiempoTotal";
    private static String fieldTiempoPrevisto = "TiempoPrevisto";
    private static String fieldFecha = "Fecha";
    private static String fieldCompletado = "Completado";

    // Constructores
    public HistoricoWorkouts() {
    }

    public HistoricoWorkouts(Workout nombreW, String nivel, Double tiempoTotal, Double tiempoPrevisto, Date fecha,
            Double ejerciciosCompletados) {
        this.nombreW = nombreW;
        this.nivel = nivel;
        this.tiempoTotal = tiempoTotal;
        this.tiempoPrevisto = tiempoPrevisto;
        this.fecha = fecha;
        this.ejerciciosCompletados = ejerciciosCompletados;
    }

    // Getters y setters
    public Workout getNombreW() {
        return nombreW;
    }

    public void setNombreW(Workout nombreW) {
        this.nombreW = nombreW;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

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

    // OBTENER HISTORICOWORKOUT ------------------------
    public HistoricoWorkouts mObtenerHistoricoWorkout(String IDUsuario, String IDWorkout) {
        Firestore co = null;

        try {
            co = Conexion.conectar();

            DocumentSnapshot historico = co
                    .collection(coleccionPrincipal)            //coleccion principal USUARIO
                    .document(IDUsuario)                       //documento (usuario)
                    .collection(coleccionSecundaria)           //coleccion secundaria HISTORIALWORKOUTS
                    .document(IDWorkout).get().get();

            if (historico.exists()) {
                setNombreW(new Workout(historico.getString(fieldNombreWorkout), null, null, null));
                setNivel(historico.getString(fieldNivel));
                setTiempoTotal(historico.getDouble(fieldTiempoTotal));
                setTiempoPrevisto(historico.getDouble(fieldTiempoPrevisto));
                setFecha(historico.getDate(fieldFecha));
                setEjerciciosCompletados(historico.getDouble(fieldCompletado));
            }

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: Clase HistoricoWorkouts, metodo mObtenerHistoricoWorkout");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    // OBTENER HISTORICOWORKOUTS ------------------------
    public ArrayList<HistoricoWorkouts> mObtenerHistoricoWorkouts(String userId) {
        Firestore co = null;
        ArrayList<HistoricoWorkouts> listaHistoricoWorkouts = new ArrayList<HistoricoWorkouts>();

        try {
            co = Conexion.conectar();

            ApiFuture<QuerySnapshot> query = co.collection(coleccionPrincipal).document(userId).collection(coleccionSecundaria).get();

            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> historicos = querySnapshot.getDocuments();

            for (QueryDocumentSnapshot historico : historicos) {
                HistoricoWorkouts hw = new HistoricoWorkouts();
                hw.setNombreW(new Workout(historico.getString(fieldNombreWorkout), null, null, null));
                hw.setNivel(historico.getString(fieldNivel));
                hw.setTiempoTotal(historico.getDouble(fieldTiempoTotal));
                hw.setTiempoPrevisto(historico.getDouble(fieldTiempoPrevisto));
                hw.setFecha(historico.getDate(fieldFecha));
                hw.setEjerciciosCompletados(historico.getDouble(fieldCompletado));

                listaHistoricoWorkouts.add(hw);
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
