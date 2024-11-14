package modelo;

import javax.swing.JLabel;

import vista.FrameEjercicios;

public class HiloDescanso extends Thread{
	
	private FrameEjercicios ejercicios;
	private Ejercicio ejercicio;

	JLabel mostrarContador;
	private boolean terminado = true;
	private boolean pausado = false;
	private Ejercicio tiempoDescansoEjer;

	private int tiempoSegundos;
	
	int mins;
	int secs;


	//constructores
	public HiloDescanso() {

	}

	public HiloDescanso(JLabel txt, double tiempoDescansoEjer) {
		this.mostrarContador = txt;
		this.tiempoSegundos = (int) tiempoDescansoEjer;
	}

	//parar la cuenta atras
	public void terminar() {
		terminado = true;
	}

	//resetear los valores
	public void reset() {
		mins = 0;
		secs = 0;
		mostrarContador.setText("0:00");
	} 

	//pausar la cuenta atras
	public void pausar() {
		pausado = true;
	}

	//reanudar despues del pausa
	public void reanudar() {
		pausado = false;
		synchronized (this) {
			notify(); //notify que siga
		}
	}

	//run
	@Override
	public void run() {

		int segundosRestantes = tiempoSegundos;
		
		terminado = false;

		while(segundosRestantes > 0 && !terminado) {

			if (pausado) {
				try {
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {

				mins = segundosRestantes / 60;
				secs = segundosRestantes % 60;

				mostrarContador.setText(String.format("%02d:%02d", mins, secs));				

				segundosRestantes--;

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				System.out.println("Cuentra atrás interrumpida");
				Thread.currentThread().interrupt();
			}	
		}
		setTerminado(true);
	}

	
	public void resetearHilo() {
		this.terminar();
		this.reset();
		//hiloDescansoEjer = null;
		new HiloDescanso(ejercicios.getLblTiempoDescanso(), ejercicio.getTiempoDescanso());
	}

	//getters y setters
	public JLabel getMostrarContador() {
		return mostrarContador;
	}

	public void setMostrarContador(JLabel mostrarContador) {
		this.mostrarContador = mostrarContador;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public boolean isPausado() {
		return pausado;
	}

	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}

	public Ejercicio getTiempoDescansoEjer() {
		return tiempoDescansoEjer;
	}

	public void setTiempoDescansoEjer(Ejercicio tiempoDescansoEjer) {
		this.tiempoDescansoEjer = tiempoDescansoEjer;
	}

	public int getTiempoSegundos() {
		return tiempoSegundos;
	}

	public void setTiempoSegundos(int tiempoSegundos) {
		this.tiempoSegundos = tiempoSegundos;
	}


}
