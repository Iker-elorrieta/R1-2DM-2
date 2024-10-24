package controlador;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

import conexion.Conexion;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;


public class Metodos {


	private static Firestore db;

	// Constructor que inicializa Firestore
	public Metodos(Firestore db) {
		Metodos.db = db;
	}

	// Método de login
	//public static boolean comprobarLogin(String email, String contrasena) {
	//try {
	//if (db == null) {
	//	System.out.println("Firestore no ha sido inicializado correctamente.");
	//	return false;
	//}
	//ApiFuture<QuerySnapshot> future = db.collection("USUARIO").whereEqualTo("Email", email).get();
	//List<QueryDocumentSnapshot> documents = future.get().getDocuments();

	//	if (documents.isEmpty()) {
	//		System.out.println("Usuario no encontrado.");
	//		return false;
	//	}

	//	DocumentSnapshot document = documents.get(0);

	//			String storedPassword = document.getString("Contrasenya");
	//			if (storedPassword != null && storedPassword.equals(contrasena)) {
	//				System.out.println("Login exitoso.");
	//				return true;
	//			} else {
	//				System.out.println("Contraseña incorrecta.");
	//				return false;
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			return false;
	//		}
	//	}


	//METODO PARA COMPROBAR EL REGISTRO
	public static boolean comprobarRegistro(String nombre, String apellido, String email, String contrasena, Date fechaNac) {
		if(nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasena.isEmpty() || fechaNac == null) {
			return false;
			//comprobar datatype de los inputs que sean correctos
		}else if(nombreContieneNumeros(nombre)) {
			JOptionPane.showMessageDialog(null, "El nombre contiene digitos.", "Error de Registro, nombre", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(apellidoContieneNumeros(apellido)) {
			JOptionPane.showMessageDialog(null, "El apellido contiene digitos.", "Error de Registro, apellido", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;

	}

	//metodo para ver que el nombre no contenga numeros
	public static boolean nombreContieneNumeros(String nombre) {
		for (int i = 0; i < nombre.length(); i++) {
			if (Character.isDigit(nombre.charAt(i))) {
				return true; //tiene numeros
			}
		}
		return false; //no tiene numeros
	}

	//metodo para ver que el apellido no contenga numeros
	public static boolean apellidoContieneNumeros(String apellido) {
		for (int i = 0; i < apellido.length(); i++) {
			if (Character.isDigit(apellido.charAt(i))) {
				return true; //tiene numeros
			}
		}
		return false; //no tiene numeros
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
	//public static boolean registrarUsuario() {

	//	Firestore co = null;
	//try {
	//co = Conexion.conectar();

	//CollectionReference root = co.collection(collectionName);
	//if (!root.document(this.email).get().get().exists()) {
	//	Map<String, Object> nuevoUsuario = new HashMap<>();
	//	nuevoUsuario.put(FIELD_NOMBRE, this.nombre);
	//	nuevoUsuario.put(FIELD_APELLIDOS, this.apellidos);
	//	nuevoUsuario.put(FIELD_PASS, this.pass);
	//	nuevoUsuario.put(FIELD_FECHA_NACIMIENTO, this.fechaNacimiento);
	//	nuevoUsuario.put(FIELD_FECHA_REGISTRO, this.fechaRegistro);
	//	nuevoUsuario.put(FIELD_NIVEL, this.nivel);
	//	DocumentReference newCont = root.document(this.email);
	//	newCont.set(nuevoUsuario);
	//	JOptionPane.showMessageDialog(null, "Usuario creado con éxito");
	//} else {
	//	JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese email");
	//}
	//	co.close();
	//} catch (IOException | InterruptedException | ExecutionException e) {
	//	e.printStackTrace();
	//} catch (Exception e) {
	// TODO Auto-generated catch block
	//	e.printStackTrace();
	//}
	//}

	//METODO PARA MODIFICAR LOS DATOS DEL PERFIL DE USUARIO
	public static boolean modificarDatos() {
		//*
		//comprobar la datatype correcta
		//modificar los datos en la bd

		return false;
	}


}
