package controlador;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Metodos {
	
	//METODO PARA COMPROBAR EL LOGIN
	public static boolean comprobarLogin(String usuario, String contrasena) {
		//*
		//comprobar campos vacios y datos correctos respecto a la BD
		return false;
		
	}
	
	//METODO PARA COMPROBAR EL REGISTRO
	public static boolean comprobarRegistro() {
		//*
		//comprobar datatype de los inputs que sean correctos
		return false;
		
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
