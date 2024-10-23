package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import modelo.Usuario;

public class LecturaUsuario {
	
	 public static ArrayList<Usuario> leerUsuario() {
	    	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	        // Declaramos el fichero
	    	File fichero = new File("Ficheros/usuarios.txt");
	        try (//Creamos el lector del fichero y le ponemos la ruta
			BufferedReader lecturaFichero = new BufferedReader(new FileReader(fichero))) {
	        	//Variable donde se guarda la linea
	        	String linea;
	        	//Creacion de objetos
	        	Usuario usuario = new Usuario();
	        	//Parte donde se leen y crean los objetos para guardar en la ArrayList
	        	while ((linea = lecturaFichero.readLine()) != null) {
	                if (!linea.startsWith("-")) {
	                    String[] partes = linea.split(":");
	                    switch (partes[0]) {
	                    case "nombre":
	                        usuario.setNombre(partes[1]);
	                        break;
	                    case "apellido":
	                        usuario.setApellido(partes[1]);
	                        break;
	                    case "nickname":
	                        usuario.setEmail(partes[1]);
	                        break;
	                    case "contrasena":
	                        usuario.setContrasena(partes[1]);
	                        break;
	                    case "fechanac":
	                        //(usuario.setFechanac(partes[1]));
	                        break;
	                    default:
	                        break;
	                    }

	                } else {
	                	// mete el objeto en la ArrayList
	                	usuarios.add(usuario);
	                	// Crea un nuevo usuario
	                	usuario = new Usuario();
	                }
	            }
	        } catch (Exception e) {
	            System.err.println("No se ha podido leer la informacion");
	        }
	        System.out.println(usuarios);
	        return usuarios;
	    }

}
