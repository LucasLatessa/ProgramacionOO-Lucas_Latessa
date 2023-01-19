package modelo;

public enum EstadoEnvido {
	ENVIDO(2),
	REALENVIDO(3),
	FALTAENVIDO(0);//se calcula con los puntos que le faltan al contincante para llegar a 15
	private int puntaje;
	private EstadoEnvido(int puntaje){
		this.puntaje= puntaje;
	}
	public int getPuntaje() {
		return puntaje;
	}
}
