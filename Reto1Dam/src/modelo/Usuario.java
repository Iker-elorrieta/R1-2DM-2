package modelo;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.Date;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

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
	public Usuario mObtenerUsuario() {
		Firestore co =null;

		try {			
			co= Conexion.conectar();
			//tiene que ser el ID del cliente no el nombre********************************
			DocumentSnapshot usuario = co.collection(collectionName).document(nombre).get().get();

			setNombre(usuario.getString(fieldNombre));
			setApellido(usuario.getString(fieldApellido));
			setContrasena(usuario.getString(fieldContrasena));
			setEmail(usuario.getString(fieldEmail));
			setFechanac(usuario.getDate(fieldFechaNac));
			setTipoUsuario(usuario.getString(fieldTipoUsuario));



		} catch ( InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Usuario, metodo mObtenerUsuario");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this;
	}

}
