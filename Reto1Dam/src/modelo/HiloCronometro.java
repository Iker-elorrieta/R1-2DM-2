package modelo;

import javax.swing.JLabel;

public class HiloCronometro extends Thread{

	int minutos;
	int segundos;
	JLabel mostrarCronometro;
	boolean terminar=false;


	//constructores
	public HiloCronometro() {
		
	}
	
	public HiloCronometro(int min, int seg, JLabel txt) {
		this.minutos = min;
		this.segundos = seg;
		this.mostrarCronometro = txt;
	}


	public void terminar() {
		terminar=true;
	}

	public void run() {
		while(!terminar) {
			for(int i = minutos; i >= 0;i--) {
				mostrarCronometro.setText(i + ":" + segundos);
				for(int x = this.segundos; x >= 0; x--) {
					if(x < 10) {
						mostrarCronometro.setText(i + ":0" + x);
					}else {
						mostrarCronometro.setText(i + ":" + x);
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				segundos = 59;
				if(i==0) {
					this.terminar();
				}
			}
		}
	}

}
