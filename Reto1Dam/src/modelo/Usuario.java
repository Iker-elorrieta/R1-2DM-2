package modelo;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import conexion.Conexion;

public class Usuario {

	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private Date fechanac;
	private String tipoUsuario;


	private static String collectionName = "USUARIO";
	private static String fieldNombre = "Nombre";
	private static String fieldApellido = "Apellido";
	private static String fieldContrasena = "Contrasenya";
	private static String fieldEmail = "Email";
	private static String fieldFechaNac = "FechaNac";
	private static String fieldTipoUsuario = "TipoUsuario";

	//constructores	
	public Usuario() {

	}

	public Usuario(String nombre, String apellido, String email, String contrasena, Date fechanac, String tipoUsuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		this.fechanac = fechanac;
		this.tipoUsuario = tipoUsuario;
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

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}




	//OBTENER USUARIO ------------------------
	public Usuario mObtenerUsuario(String idIntroducido, String contrasenaIntroducida) {
		Firestore co =null;

		try {
			co = Conexion.conectar();

			if (co.collection(collectionName).document(idIntroducido).get().get().exists()) {
				DocumentSnapshot dsUsuario = co.collection(collectionName).document(idIntroducido).get().get();
				if (dsUsuario.getString(fieldContrasena).equals(contrasenaIntroducida)) {
					setEmail(dsUsuario.getId());
					setNombre(dsUsuario.getString(fieldNombre));
					setApellido(dsUsuario.getString(fieldApellido));
					setContrasena(dsUsuario.getString(fieldContrasena));
					setFechanac(obtenerFechaDate(dsUsuario, fieldFechaNac));

					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
					return this;

				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorecctos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorecctos", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

			co.close();
		} catch (InterruptedException | ExecutionException | IOException e) {
			System.out.println("Error: Clase Usuario, metodo mObtenerUsuario");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
				JOptionPane.showMessageDialog(null, "El email no existe.", "Error login", JOptionPane.ERROR_MESSAGE);				
			} else {
				DocumentSnapshot usuario = usuarios.get(0);
				String contrasenaDB = usuario.getString("Contrasenya");
				if (contrasenaDB != null && contrasenaDB.equals(contrasena)) {
					return true;
					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				} else {
					return false;
					JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.", "Error login", JOptionPane.ERROR_MESSAGE);
				}
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



	// Convertir de timeStamp de Firestore a date
	public Date obtenerFechaDate(DocumentSnapshot documentSnapshot, String fieldName) {
		Timestamp timestamp = documentSnapshot.getTimestamp(fieldName);
		return (timestamp != null) ? timestamp.toDate() : null;
	}


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
				nuevoUsuario.put(fieldFechaNac, this.fechanac);
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
