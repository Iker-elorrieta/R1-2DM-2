package conexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

public class Conexion {
	
	//BD Firestore archivo
	//private static String nombreJSON = "bdgimnasio.json";
	
	//local clase
	//private static String nombreJSON = "C:\\Users\\in2dm3-a\\Desktop\\bdgimnasio.json";
	
	//local casa*
	private static String nombreJSON = "C:\\Users\\Ayla\\Desktop\\bdgimnasio.json";
	
	//ID de la base de datos
	private static String projectID = "bdgimnasio-20c0b";
	
	
	public static Firestore conectar() throws IOException {
		FileInputStream serviceAccount;
		Firestore fs = null;
		try {
			serviceAccount = new FileInputStream(nombreJSON);
		

		FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
				.setProjectId(projectID).setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
		fs = firestoreOptions.getService();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  fs;
	}

}
