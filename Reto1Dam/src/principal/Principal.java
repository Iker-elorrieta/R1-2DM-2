package principal;

import com.google.cloud.firestore.Firestore;

import conexion.Conexion;
import controlador.Metodos;
import vista.FrameLogin;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//FRAME INICIAL
		FrameLogin login = new FrameLogin();
        
        login.setVisible(true);
        
        try {
            // Inicializar Firestore
            Firestore db = Conexion.conectar();

            Metodos loginService = new Metodos(db);

            boolean loginExitoso = loginService.comprobarLogin("jon@gmail.com", "123");

            if (loginExitoso) {
                System.out.println("Bienvenido a la aplicación.");
            } else {
                System.out.println("Fallo al iniciar sesión.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
