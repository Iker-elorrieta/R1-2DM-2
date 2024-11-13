package modelo;

import javax.swing.JLabel;

public class HiloCronometro extends Thread{


	JLabel mostrarCronometro;
	private int minutos = 0;
	private int segundos = 0;

	private boolean terminar=false;
	private boolean pausado = false;


	//constructores
	public HiloCronometro() {

	}

	public HiloCronometro(JLabel txt) {
		this.mostrarCronometro = txt;
	}

	public HiloCronometro(int min, int seg, JLabel txt) {
		this.minutos = min;
		this.segundos = seg;
		this.mostrarCronometro = txt;
	}


	public void terminar() {
		terminar=true;

	}

	//resetear los valores
	public void reset() {
		minutos = 0;
		segundos = 0;
		mostrarCronometro.setText("0:00");
	}


	public void pausar() {
		pausado = true;
	}

	public void reanudar() {
		pausado = false;

		synchronized (this) {
			notify();  //notify al hilo para que continue donde se ha quedado
		}
	}

	public void run() {
		while (!terminar) {

			if (pausado) {
				try {
					synchronized (this) {
						wait();  // Wait until the thread is resumed
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				//actualiza el jlabel con los minutos y segundos actuales
				if (segundos < 10) {
					mostrarCronometro.setText(minutos + ":0" + segundos);
				} else {
					mostrarCronometro.setText(minutos + ":" + segundos);
				}

				Thread.sleep(1000);

				segundos++;

				if (segundos == 60) {  //convierte 60 segundos en 1 minuto
					segundos = 0;
					minutos++;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
	
	

	//getters y setters
	public JLabel getMostrarCronometro() {
		return mostrarCronometro;
	}

	public void setMostrarCronometro(JLabel mostrarCronometro) {
		this.mostrarCronometro = mostrarCronometro;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public boolean isTerminar() {
		return terminar;
	}

	public void setTerminar(boolean terminar) {
		this.terminar = terminar;
	}

	public boolean isPausado() {
		return pausado;
	}

	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}
	
	
	




}


