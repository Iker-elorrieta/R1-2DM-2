package modelo;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import conexion.Conexion;

public class Usuario {

	private static Usuario usuarioLogueado = null;

	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private Date fechaNac;

	//nombre campos BD
	private static String collectionName = "USUARIO";
	private static String fieldNombre = "Nombre";
	private static String fieldApellido = "Apellido";
	private static String fieldContrasena = "Contrasenya";
	private static String fieldEmail = "Email";
	private static String fieldFechaNac = "FechaNac";


	//constructores
	public Usuario() {

	}

	public Usuario(String nombre, String apellido, String email, String contrasena, Date fechaNac) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		this.fechaNac = fechaNac;

	}


	//getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}


	//METODOS PARA EL USUARIO QUE HA LOGUEADO
	public static void setUsuarioLogueado(Usuario usuario) {
		usuarioLogueado = usuario;
	}


	public static Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}


	public static boolean estaLogueado() {
		return usuarioLogueado != null;
	}


	//OBTENER USUARIO ------------------------
	public static Usuario mObtenerUsuario(String email) {
		Firestore co =null;
		Usuario usuario = new Usuario();

		try {
			co = Conexion.conectar();


			ApiFuture<QuerySnapshot> future = co.collection(collectionName).whereEqualTo("Email", email).get();


			List<QueryDocumentSnapshot> documents = future.get().getDocuments();

			if (!documents.isEmpty()) {
				DocumentSnapshot doc = documents.get(0);

				usuario.setNombre(doc.getString(fieldNombre));
				usuario.setApellido(doc.getString(fieldApellido));
				usuario.setEmail(doc.getString(fieldEmail));
				usuario.setContrasena(doc.getString(fieldContrasena));
				usuario.setFechaNac(doc.getDate(fieldFechaNac));

			}
		} catch ( InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Usuario, metodo mObtenerUsuario");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;
	}

	//METODO PARA COMPORBAR EL LOGIN
	public static boolean comprobarLogin(String email, String contrasena) {
		Firestore co = null;

		try {
			co = Conexion.conectar();

			ApiFuture<QuerySnapshot> query = co.collection(collectionName).whereEqualTo("Email", email).get();

			QuerySnapshot querySnapshot = query.get();
			List<QueryDocumentSnapshot> usuarios = querySnapshot.getDocuments();

			if (usuarios.isEmpty()) {
				return false;
			}

			DocumentSnapshot usuario = usuarios.get(0);
			String contrasenaDB = usuario.getString("Contrasenya");

			if (contrasenaDB == null || !contrasenaDB.equals(contrasena)) {

				JOptionPane.showMessageDialog(null, "El login es incorrecto.", "Error login", JOptionPane.ERROR_MESSAGE);
				return false;

			} else {
				return true;
			}

		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Usuario, metodo comprobarLogin");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}


	/* Convertir de timeStamp de Firestore a date
public Date obtenerFechaDate(DocumentSnapshot documentSnapshot, String fieldName) {
Timestamp timestamp = documentSnapshot.getTimestamp(fieldName);
return (timestamp != null) ? timestamp.toDate() : null;
}*/


	public void mRegistrarUsuario(String email, String contrasena) {

		Firestore co = null;
		try {
			co = Conexion.conectar();

			CollectionReference root = co.collection(collectionName);

			if (!root.document(this.email).get().get().exists()) {
				Map<String, Object> nuevoUsuario = new HashMap<>();
				nuevoUsuario.put(fieldNombre, this.nombre);
				nuevoUsuario.put(fieldApellido, this.apellido);
				nuevoUsuario.put(fieldContrasena, this.contrasena);
				nuevoUsuario.put(fieldFechaNac, this.fechaNac);

				DocumentReference newCont = root.document(this.email);
				newCont.set(nuevoUsuario);

				JOptionPane.showMessageDialog(null, "Usuario creado con éxito");
			} else {
				JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese email");
			}
			co.close();
		} catch (IOException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}