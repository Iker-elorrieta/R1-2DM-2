package modelo;

import javax.swing.JLabel;

public class HiloContadorEjercicio extends Thread{

	private int minutos = 0;
	private int segundos = 0;
	JLabel mostrarCronometro;
	private boolean terminar=false;
	private boolean pausado = false;


	//constructores
	public HiloContadorEjercicio() {

	}

	public HiloContadorEjercicio(JLabel txt) {
		this.mostrarCronometro = txt;
	}

	public HiloContadorEjercicio(int min, int seg, JLabel txt) {
		this.minutos = min;
		this.segundos = seg;
		this.mostrarCronometro = txt;
	}

	//parar el contador
	public void terminar() {
		terminar=true;

	}

	//pausar el contador
	public void pausar() {
		pausado = true;
	}

	//reanudar despues de la pausa
	public void reanudar() {
		pausado = false;

		synchronized (this) {
			notify();  //notify al hilo para que continue donde se ha quedado
		}
	}

	//run
	public void run() {
		while (!terminar) {

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




}


