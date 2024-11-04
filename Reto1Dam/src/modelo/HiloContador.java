package modelo;

import javax.swing.JLabel;

public class HiloContador extends Thread {

	JLabel mostrar;
	boolean terminar = false;


	public HiloContador(JLabel txt) {
		this.mostrar = txt;
	}


	public void terminar() {
		terminar=true;
	}

	public void run() {
		while(!terminar) {
			for(int i=0;!terminar;i++) {
				int x=0;
				if(i==59) {
					i=0;
					mostrar.setText(x+":0"+i);
				}else{
					if(i<10) {
						mostrar.setText(x+":0"+i);
					}else{
						mostrar.setText(x+":"+i);
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				x++;				
			}
		}
	}

}
