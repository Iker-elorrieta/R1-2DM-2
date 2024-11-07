package modelo;

import javax.swing.JLabel;

public class HiloCuentaAtrasSerie extends Thread{

	JLabel txt;
	private boolean terminado = false;
	private boolean pausado = false;
	private double dTiempoSerie;


	//constructores
	public HiloCuentaAtrasSerie() {

	}

	public HiloCuentaAtrasSerie(JLabel txt, double dTiempoSerie) {
		this.txt = txt;
		this.dTiempoSerie = dTiempoSerie;
	}

	//parar la cuenta atras
	public void terminar() {
		terminado = true;
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

		try {
			while (dTiempoSerie > 0 && !terminado) {
				
				if(pausado) {
					synchronized (this) {
						wait();
					}
				}

				int tiempoSerie = (int) dTiempoSerie;

				txt.setText(String.valueOf(formatoTiempo(tiempoSerie)));
				
				Thread.sleep(1000);

				tiempoSerie--;
			}
			
			setTerminado(true);


		} catch (InterruptedException e) {
			System.out.println("Cuentra atrás interrumpida");
			Thread.currentThread().interrupt();
		}

		setTerminado(true);
	}

	//formato en mins secs
	private String formatoTiempo(int tiempoSerie) {
		int mins = tiempoSerie / 60;
		int secs = tiempoSerie % 60;
		return String.format("%02d:%02d", mins, secs);
	}


	//getters y setters
	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public JLabel getTxt() {
		return txt;
	}

	public void setTxt(JLabel txt) {
		this.txt = txt;
	}

	public double getdTiempoSerie() {
		return dTiempoSerie;
	}

	public void setdTiempoSerie(double dTiempoSerie) {
		this.dTiempoSerie = dTiempoSerie;
	}







}
