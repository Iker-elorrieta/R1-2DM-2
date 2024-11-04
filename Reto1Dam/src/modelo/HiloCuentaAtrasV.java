package modelo;

public class HiloCuentaAtrasV extends Thread{
	
	 @Override
	    public void run() {
	        int segundos = 5;
	        
	        try {
	            while (segundos > 0) {
	                
	                segundos--;

	                
	                Thread.sleep(1000);
	            }

	            
	        } catch (InterruptedException e) {
	            System.out.println("Cuentra atrás interrumpida");
	            Thread.currentThread().interrupt();
	        }
	    }
}
