package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Usuario;

public class EscrituraUsuario {

	/**
	 * Escribe los usuarios en el fichero usuarios.txt
	 * 
	 * @param usuarios ArrayList de usuarios
	 */
	public static void escrituraUsuario(ArrayList<Usuario> usuarios)  {
try {
	BufferedWriter escriturafichero = new BufferedWriter(new FileWriter("Ficheros/usuarios.txt",false));
	for (int j = 0; j < usuarios.size(); j++) {
		// Recorremos el array de usuarios y los escribimos en el fichero
		escriturafichero.write("nombre:" + usuarios.get(j).getNombre());
		escriturafichero.newLine();
		escriturafichero.write("apellido:" + usuarios.get(j).getApellido());
		escriturafichero.newLine();
		escriturafichero.write("email:" +usuarios.get(j).getEmail());
		escriturafichero.newLine();
		escriturafichero.write("contrasena:" +usuarios.get(j).getContrasena());
		escriturafichero.newLine();
		escriturafichero.write("fechanac:" +usuarios.get(j).getFechaNac());
		escriturafichero.newLine();
		
	}
	// Cerramos el método para que se escriban los datos
	escriturafichero.close();
	
	
} catch ( IOException e ) {
	e.printStackTrace();
	
}
		
		
		
		
	}
}
