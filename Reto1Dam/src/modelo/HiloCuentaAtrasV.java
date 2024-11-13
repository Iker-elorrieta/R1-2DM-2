package modelo;

import javax.swing.JLabel;

public class HiloCuentaAtrasV extends Thread{

	JLabel txt;
	private boolean terminado = true;
	int segundos = 5;

	//constructores
	public HiloCuentaAtrasV() {

	}

	public HiloCuentaAtrasV(JLabel txt) {
		this.txt = txt;
	}

	public void terminado() {
		setTerminado(true);
	}

	//resetear los valores
	public void reset() {
		segundos = 0;
		txt.setText("-");
	}

	@Override
	public void run() {
		
		terminado = false;
		
		try {
			while (segundos > 0) {

				txt.setText(String.valueOf(segundos));

				segundos--;


				Thread.sleep(1000);
			}




		} catch (InterruptedException e) {
			System.out.println("Cuentra atrás interrumpida");
			Thread.currentThread().interrupt();
		}

		setTerminado(true);
	}

	//getters y setters
	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}


}
