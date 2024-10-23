package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vista.FrameWorkoutsPrincipal;
import vista.FrameLogin;
import vista.FrameModificarDatos;
import vista.FramePerfilUsuario;
import vista.FrameRegistro;

public class ControladorFrames implements ActionListener, ListSelectionListener {
	private FrameLogin login;
	private FrameRegistro registro;
    private FrameWorkoutsPrincipal workoutsPrincipal;
    private FramePerfilUsuario perfilUsuario;
    private FrameModificarDatos modificarDatos;

    public ControladorFrames(FrameLogin login, FrameRegistro registro, FrameWorkoutsPrincipal workoutsPrincipal, FramePerfilUsuario perfilUsuario,FrameModificarDatos modificarDatos) {
        this.login = login;
        this.registro = registro;
    	this.workoutsPrincipal = workoutsPrincipal;
        this.perfilUsuario = perfilUsuario;
        this.modificarDatos = modificarDatos;
        
        addListeners();
    }

    private void addListeners() {
    	
    	//frame login
    	
    	//frame registro
    	registro.getBtnAtras().addActionListener(this);
    	registro.getBtnRegistrarse().addActionListener(this);    	
        
    	//frame principal de workouts
        workoutsPrincipal.getBtnPerfil().addActionListener(this);
        workoutsPrincipal.getBtnHistorial().addActionListener(this);
        workoutsPrincipal.getBtnSeleccionar().addActionListener(this);

        //frame perfil de usuario
        perfilUsuario.getBtnAtras().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == workoutsPrincipal.getBtnPerfil()) {
           
            perfilUsuario.setVisible(true);
            workoutsPrincipal.dispose();
        } else if (e.getSource() == perfilUsuario.getBtnAtras()) {
            
            workoutsPrincipal.setVisible(true);
            perfilUsuario.dispose();
        }
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
    }
}