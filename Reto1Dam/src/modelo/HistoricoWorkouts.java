package modelo;

import com.google.cloud.Date;

public class HistoricoWorkouts {
	private Workout nombreW;
	private Workout nivel;
	private Double tiempoTotal;
	private Double tiempoPrevisto;
	private Date fecha;
	private Double ejerciciosCompletados;
	
	
	//constructores
	public HistoricoWorkouts() {

	}
	
	public HistoricoWorkouts(Workout nombreW, Workout nivel, Double tiempoTotal, Double tiempoPrevisto, Date fecha,
			Double ejerciciosCompletados) {
		this.nombreW = nombreW;
		this.nivel = nivel;
		this.tiempoTotal = tiempoTotal;
		this.tiempoPrevisto = tiempoPrevisto;
		this.fecha = fecha;
		this.ejerciciosCompletados = ejerciciosCompletados;
	}
	
	
	//getters y setters
	public Workout getNombreW() {
		return nombreW;
	}
	public void setNombreW(Workout nombreW) {
		this.nombreW = nombreW;
	}
	public Workout getNivel() {
		return nivel;
	}
	public void setNivel(Workout nivel) {
		this.nivel = nivel;
	}
	public Double getTiempoTotal() {
		return tiempoTotal;
	}
	public void setTiempoTotal(Double tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}
	public Double getTiempoPrevisto() {
		return tiempoPrevisto;
	}
	public void setTiempoPrevisto(Double tiempoPrevisto) {
		this.tiempoPrevisto = tiempoPrevisto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getEjerciciosCompletados() {
		return ejerciciosCompletados;
	}
	public void setEjerciciosCompletados(Double ejerciciosCompletados) {
		this.ejerciciosCompletados = ejerciciosCompletados;
	}
	
	
}
