package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import modelo.Usuario;
import vista.FrameLogin;



public class Metodos{
	private static vista.FrameLogin login;
	private static vista.FrameRegistro registro;

	static Usuario usuario;

	public Metodos(vista.FrameLogin login, vista.FrameRegistro registro) {
		this.login = login;
		this.registro= registro;

	}

	public void comprobarRegistro2() {
		String nombre = registro.getTextFieldNombre().getText().trim();
		String apellido = registro.getTextFieldApellido().getText().trim();
		String email = registro.getTextFieldEmail().getText().trim();
		String pasString = new String (registro.getPasswordFieldContrasena().getPassword()).trim();
		Date fechanac = registro.getDateChooserFechaNac().getDate();
		Usuario nuevoUsuairo = new Usuario(nombre, apellido,email, pasString, fechanac);

		nuevoUsuairo.mRegistrarUsuario();


	}


	public boolean comprobarLogin2() {
		String email = login.getTextFieldEmail().getText().trim();
		String pasString = new String (login.getPasswordFieldContrasena().getPassword()).trim();
		if(!email.isEmpty() && !pasString.isEmpty()) {
			if(new Usuario ().mObtenerUsuario(email, pasString) !=null) {
				usuario = new Usuario ().mObtenerUsuario(email, pasString);
			}else {
				System.out.println("Aviso");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Algun campo vacio");	

		}

		return false;

	}

	//METODO PARA COMPROBAR EL REGISTRO
	public static boolean comprobarRegistro(String nombre, String apellido, String email, String contrasena, Date fechaNac) {
		if(nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasena.isEmpty() || fechaNac == null) {
			JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error de Registro", JOptionPane.ERROR_MESSAGE);
			return false;
			//comprobar datatype de los inputs que sean correctos
		}else if(nombreContieneNumeros(nombre) || apellidoContieneNumeros(apellido)) {
			JOptionPane.showMessageDialog(null, "El nombre o apellido contiene digitos.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			
			return true;

		}
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

	//METODO PARA COMPROBAR EL REGISTRO
	public static boolean comprobarRegistro() {
		//*
		//comprobar datatype de los inputs que sean correctos
		return false;

	}

	public String registro(String email, String contrasena) {
		try {
			UserRecord userRecord = FirebaseAuth.getInstance().createUser(
					new CreateRequest().setEmail(email).setPassword(contrasena)
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
