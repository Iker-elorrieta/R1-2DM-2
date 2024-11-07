package modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
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
import controlador.Metodos;
import conexion.Conexion;

public class Usuario {

	private static Usuario usuarioLogueado = null;

	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private Date fechaNac;
	private static Metodos metodos = new Metodos();
	private static final String USUARIOSFILEROUTE = "Ficheros/usuarios.dat";

	// nombre campos BD
	private static String collectionName = "USUARIO";
	private static String fieldNombre = "Nombre";
	private static String fieldApellido = "Apellido";
	private static String fieldContrasena = "Contrasenya";
	private static String fieldEmail = "Email";
	private static String fieldFechaNac = "FechaNac";

	// constructores
	public Usuario() {

	}

	public Usuario(String nombre, String apellido, String email, String contrasena, Date fechaNac) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		this.fechaNac = fechaNac;

	}

	// getters y setters
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

	// METODOS PARA EL USUARIO QUE HA LOGUEADO
	public static void setUsuarioLogueado(Usuario usuario) {
		usuarioLogueado = usuario;
	}

	public static Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public static boolean estaLogueado() {
		return usuarioLogueado != null;
	}

	// OBTENER USUARIO ------------------------
	public static Usuario mObtenerUsuario(String email) {
		Usuario usuario = new Usuario();

		if (metodos.hayInternet()) {
			Firestore co = null;

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

				co.close();

			} catch (InterruptedException | ExecutionException e) {
				System.out.println("Error: Clase Usuario, metodo mObtenerUsuario");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				ProcessBuilder builder = new ProcessBuilder("java", "-jar", "GenerarBackups.jar");
				builder.start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			try {
				FileInputStream fic = new FileInputStream(USUARIOSFILEROUTE);
				ObjectInputStream ois = new ObjectInputStream(fic);
				while (fic.getChannel().position() < fic.getChannel().size()) {
					usuario = (Usuario) ois.readObject();

					if (usuario.getEmail().equals(email)) {
						ois.close();
						return usuario;
					}
					ois.close();
				}
			} catch (IOException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		return usuario;

	}

	// METODO PARA COMPORBAR EL LOGIN
	public static boolean comprobarLogin(String email, String contrasena) {

		if (metodos.hayInternet()) {
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

				co.close();

				if (contrasenaDB == null || !contrasenaDB.equals(contrasena)) {

					JOptionPane.showMessageDialog(null, "El login es incorrecto.", "Error login",
							JOptionPane.ERROR_MESSAGE);
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
			} catch (Exception e) {
				return false;
			}
		} else {
			try {
				FileInputStream fic = new FileInputStream(USUARIOSFILEROUTE);
				ObjectInputStream ois = new ObjectInputStream(fic);
				while (fic.getChannel().position() < fic.getChannel().size()) {
					Usuario usuario = (Usuario) ois.readObject();

					if (usuario.getEmail().equals(email) && usuario.getContrasena().equals(contrasena)) {
						ois.close();
						return true;
					}
					ois.close();
				}
			} catch (IOException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		return false;
	}

	// METODO PARA REGISTRAR AL USUARIO
	public static void mRegistrarUsuario(String nombre, String apellido, String email, String contrasena,
			Date fechaNac) {

		Firestore co = null;
		try {
			co = Conexion.conectar();

			CollectionReference usuario = co.collection(collectionName);

			ApiFuture<QuerySnapshot> future = usuario.whereEqualTo("Email", email).get();
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();

			if (documents.isEmpty()) {

				Map<String, Object> nuevoUsuario = new HashMap<>();

				nuevoUsuario.put("Nombre", nombre);
				nuevoUsuario.put("Apellido", apellido);
				nuevoUsuario.put("Email", email);
				nuevoUsuario.put("Contrasenya", contrasena);
				nuevoUsuario.put("FechaNac", fechaNac);

				usuario.add(nuevoUsuario).get();

				JOptionPane.showMessageDialog(null, "Usuario creado con éxito.");
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

	// METODO PARA MODIFICAR LOS DATOS DEL PERFIL DE USUARIO
	public static String mModificarDatos(Usuario usuario, String nombre, String apellido, String nuevoEmail,
			String contrasena, Date fechaNac) {
		Firestore co = null;

		try {
			co = Conexion.conectar();

			String email = usuario.getEmail();

			ApiFuture<QuerySnapshot> future = co.collection(collectionName).whereEqualTo("Email", email).get();
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();

			if (!documents.isEmpty()) {
				DocumentReference docRef = documents.get(0).getReference();

				Map<String, Object> updates = new HashMap<>();
				updates.put(fieldNombre, nombre);
				updates.put(fieldApellido, apellido);
				updates.put(fieldEmail, nuevoEmail);
				if (contrasena.isEmpty()) {
					contrasena = usuario.getContrasena();
				}
				updates.put(fieldContrasena, contrasena);
				updates.put(fieldFechaNac, usuario.getFechaNac());

				docRef.update(updates);

			} else {
				System.out.println("No existe un usuario con ese email");
			}

			co.close();

		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Usuario, metodo modificarDatos");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nuevoEmail;
	}

	public ArrayList<Usuario> mObtenerTodosLosUsuarios() {
		Firestore co = null;

		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

		try {
			co = Conexion.conectar();

			ApiFuture<QuerySnapshot> query = co.collection(collectionName).get();

			QuerySnapshot querySnapshot = query.get();
			List<QueryDocumentSnapshot> usuariosFireBase = querySnapshot.getDocuments();
			for (QueryDocumentSnapshot usuarioFireBase : usuariosFireBase) {

				Usuario usuario = new Usuario(usuarioFireBase.getString(fieldNombre),
						usuarioFireBase.getString(fieldApellido), usuarioFireBase.getId(),
						usuarioFireBase.getString(fieldContrasena), usuarioFireBase.getDate(fieldFechaNac));

				listaUsuarios.add(usuario);
			}
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Contacto, metodo mObtenerContactos");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

}