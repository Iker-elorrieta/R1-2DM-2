package controlador;

import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.cloud.firestore.DocumentSnapshot;



public class Metodos {
	
	private Firestore db;

    // Constructor que inicializa Firestore
    public Metodos(Firestore db) {
        this.db = db;
    }

    // Método de login
    public boolean comprobarLogin(String email, String password) {
        try {
            if (db == null) {
                System.out.println("Firestore no ha sido inicializado correctamente.");
                return false;
            }
            ApiFuture<QuerySnapshot> future = db.collection("USUARIO").whereEqualTo("Email", email).get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();

            if (documents.isEmpty()) {
                System.out.println("Usuario no encontrado.");
                return false;
            }

            DocumentSnapshot document = documents.get(0);

            String storedPassword = document.getString("Contrasenya");
            if (storedPassword != null && storedPassword.equals(password)) {
                System.out.println("Login exitoso.");
                return true;
            } else {
                System.out.println("Contraseña incorrecta.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	//METODO PARA COMPROBAR EL REGISTRO
	public static boolean comprobarRegistro() {
		//*
		//comprobar datatype de los inputs que sean correctos
		return false;
		
	}
	
	public String registro(String email, String password) {
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(
                new CreateRequest().setEmail(email).setPassword(password)
            );
            return "Usuario registrado: " + userRecord.getUid();
        } catch (Exception e) {
            return "Error al registrar usuario: " + e.getMessage();
        }
    }
	
  
}
