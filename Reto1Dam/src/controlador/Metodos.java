package controlador;

import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Usuario;



public class Metodos{

	static Usuario usuario;



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



	//METODO PARA MODIFICAR LOS DATOS DEL PERFIL DE USUARIO
	public static boolean modificarDatos() {
		//*
		//comprobar la datatype correcta
		//modificar los datos en la bd

		return false;
	}


}
