package controlador;

import java.util.Date;
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


	private static Firestore db;

	// Constructor que inicializa Firestore
	public Metodos(Firestore db) {
		Metodos.db = db;
	}

	// Método de login
	public static boolean comprobarLogin(String email, String contrasena) {
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
			if (storedPassword != null && storedPassword.equals(contrasena)) {
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
	public static boolean comprobarRegistro(String nombre, String apellido, String email, String contrasena, Date fechaNac) {
		if(nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasena.isEmpty() /*|| fechaNac empty*/) {
			return false;
		}
		//comprobar datatype de los inputs que sean correctos
		return true;

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

	//METODO PARA REGISTRAR AL NUEVO USUARIO
	public static boolean registrarUsuario() {

		if(comprobarRegistro()) {
			//*
			//insertar en la base de datos
			return true;
		}else {
			return false;
		}
	}

	//METODO PARA MODIFICAR LOS DATOS DEL PERFIL DE USUARIO
	public static boolean modificarDatos() {
		//*
		//comprobar la datatype correcta
		//modificar los datos en la bd

		return false;
	}


}
