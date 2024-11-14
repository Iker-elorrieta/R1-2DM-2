package modelo;

import javax.swing.JLabel;

import vista.FrameEjercicios;

public class HiloCuentaAtrasV extends Thread{

	private FrameEjercicios ejercicios;
	
	JLabel mostrarContador;
	private boolean terminado = true;
	int segundos = 5;

	//constructores
	public HiloCuentaAtrasV() {

	}

	public HiloCuentaAtrasV(JLabel mostrarContador) {
		this.mostrarContador = mostrarContador;
	}

	public void terminado() {
		setTerminado(true);
	}

	//resetear los valores
	public void reset() {
		segundos = 0;
		mostrarContador.setText("-");
	}

	@Override
	public void run() {
		
		terminado = false;
		
		try {
			while (segundos > 0 && !terminado) {

				mostrarContador.setText(String.valueOf(segundos));

				segundos--;


				Thread.sleep(1000);
			}




		} catch (InterruptedException e) {
			System.out.println("Cuentra atrás interrumpida");
			Thread.currentThread().interrupt();
		}
		
		synchronized (this) {
			terminado = true;
			
            notify(); //notify a los hilos que ha terminado
        }

		
	}
	
	
	public void resetearHilo(JLabel mostrarCronometro) {
		this.terminado();
		this.reset();
		//hiloCuentaAtras = null;
		new HiloCuentaAtrasV(mostrarCronometro);
	}

	//getters y setters
	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}


}
