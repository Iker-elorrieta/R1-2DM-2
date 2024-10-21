package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vista.FrameWorkoutsPrincipal;
import vista.FramePerfilUsuario;

public class ControladorFrames implements ActionListener, ListSelectionListener {
    private FrameWorkoutsPrincipal workoutsPrincipal;
    private FramePerfilUsuario perfilUsuario;

    public ControladorFrames(FrameWorkoutsPrincipal workoutsPrincipal, FramePerfilUsuario perfilUsuario) {
        this.workoutsPrincipal = workoutsPrincipal;
        this.perfilUsuario = perfilUsuario;

        // Initialize the action listeners for the buttons using this class as the listener
        addListeners();
    }

    private void addListeners() {
        // Attach this controller as the listener for the buttons in FrameWorkoutsPrincipal
        workoutsPrincipal.getBtnPerfil().addActionListener(this);
        workoutsPrincipal.getBtnHistorial().addActionListener(this);
        workoutsPrincipal.getBtnSeleccionar().addActionListener(this);

        // Attach this controller as the listener for the 'Atrás' button in FramePerfilUsuario
        perfilUsuario.getBtnAtras().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button events using a switch or if-else structure
        if (e.getSource() == workoutsPrincipal.getBtnPerfil()) {
            // Open FramePerfilUsuario and close FrameWorkoutsPrincipal
            perfilUsuario.setVisible(true);
            workoutsPrincipal.dispose();
        } else if (e.getSource() == perfilUsuario.getBtnAtras()) {
            // Go back to FrameWorkoutsPrincipal and close FramePerfilUsuario
            workoutsPrincipal.setVisible(true);
            perfilUsuario.dispose();
        }
        // Handle other button actions (like Historial or Seleccionar) here if needed
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Handle table selection events here if needed
        // This is only triggered if you set up a ListSelectionListener for your table
    }
}