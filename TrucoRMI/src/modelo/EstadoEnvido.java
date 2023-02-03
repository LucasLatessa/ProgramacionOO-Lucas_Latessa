package modelo;

import java.io.Serializable;

public enum EstadoEnvido implements Serializable {
	
	ENVIDO(2),
	REALENVIDO(3),
	FALTAENVIDO(0);//se calcula con los puntos que le faltan al contincante para llegar a 15
	private static final long serialVersionUID = 1L;
	private int puntaje;
	private EstadoEnvido(int puntaje){
		this.puntaje= puntaje;
	}
	public int getPuntaje() {
		return puntaje;
	}
	@Override
	public String toString() {
		switch(puntaje) {
		case 2:
			return "envido";
		case 3:
			return "real envido";
		case 0:
			return "falta envido";
		}
		return null;
	}
}
