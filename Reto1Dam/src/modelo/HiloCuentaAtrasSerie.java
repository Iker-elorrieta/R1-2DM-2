package modelo;

import javax.swing.JLabel;

import vista.FrameEjercicios;

public class HiloCuentaAtrasSerie extends Thread{

	private FrameEjercicios ejercicios;
	private Serie serie;
	
	JLabel mostrarContador;
	private boolean terminado = true;
	private boolean pausado = false;
	private Serie dTiempoSerie;

	private double tiempoSerie;
	private int tiempoSegundos;
	

	int segundosRestantes;

	int mins;
	int secs;


	//constructores
	public HiloCuentaAtrasSerie() {

	}

	public HiloCuentaAtrasSerie(JLabel txt, double tiempoSerie) {
		this.mostrarContador = txt;
		this.tiempoSegundos = (int) tiempoSerie;
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

		segundosRestantes = tiempoSegundos;
		
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
				
				if (!terminado) {
					mins = segundosRestantes / 60;
					secs = segundosRestantes % 60;

					mostrarContador.setText(String.format("%02d:%02d", mins, secs));

					segundosRestantes--;

					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println("Countdown interrupted");
				Thread.currentThread().interrupt();
			}
		}

		setTerminado(true);
	}

	public void resetearHilo(JLabel mostrarContador, Double serie) {
		this.terminar();
		this.reset();
		//hiloCuentaAtrasSerie = null;
		new HiloCuentaAtrasSerie(mostrarContador, serie);
	}

	//getters y setters
	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public JLabel getMostrarContador() {
		return mostrarContador;
	}

	public void setMostrarContador(JLabel mostrarContador) {
		this.mostrarContador = mostrarContador;
	}

	public boolean isPausado() {
		return pausado;
	}

	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}

	public double getTiempoSerie() {
		return tiempoSerie;
	}

	public void setTiempoSerie(double tiempoSerie) {
		this.tiempoSerie = tiempoSerie;
	}

	public Serie getdTiempoSerie() {
		return dTiempoSerie;
	}

	public void setdTiempoSerie(Serie dTiempoSerie) {
		this.dTiempoSerie = dTiempoSerie;
	}







}
