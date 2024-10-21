package modelo;

public class Serie {
	private String nombreS;
	private Double numRepeticiones;
	private String foto;
	private Double tiempoSerie;
	private Ejercicio nombreE;
	
	//constructores
	public Serie() {
	
	}
	
	public Serie(String nombreS, Double numRepeticiones, String foto, Double tiempoSerie, Ejercicio nombreE) {
		this.nombreS = nombreS;
		this.numRepeticiones = numRepeticiones;
		this.foto = foto;
		this.tiempoSerie = tiempoSerie;
		this.nombreE = nombreE;
	}

	//getters y setters
	public String getNombreS() {
		return nombreS;
	}
	public void setNombreS(String nombreS) {
		this.nombreS = nombreS;
	}
	public Double getNumRepeticiones() {
		return numRepeticiones;
	}
	public void setNumRepeticiones(Double numRepeticiones) {
		this.numRepeticiones = numRepeticiones;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Double getTiempoSerie() {
		return tiempoSerie;
	}
	public void setTiempoSerie(Double tiempoSerie) {
		this.tiempoSerie = tiempoSerie;
	}
	public Ejercicio getNombreE() {
		return nombreE;
	}
	public void setNombreE(Ejercicio nombreE) {
		this.nombreE = nombreE;
	}
	
	
}
