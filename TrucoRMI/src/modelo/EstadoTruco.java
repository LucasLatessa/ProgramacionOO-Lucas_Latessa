package modelo;

import java.io.Serializable;

public enum EstadoTruco implements Serializable{
	NADA(1),
	TRUCO(2),
	RETRUCO(3),
	VALECUATRO(4);
	private static final long serialVersionUID = 1L;
	private int puntaje;
	private EstadoTruco(int puntaje) {
		this.puntaje=puntaje;
	}
	/**
	 * @return el siguiente(truco-retruco-vale4)
	 */
	public EstadoTruco aumentar() {
		EstadoTruco ret=null;
		switch(this) {
		case NADA:
			ret= TRUCO;
			break;
		case TRUCO:
			ret= RETRUCO;
			break;
		case RETRUCO:
			ret= VALECUATRO;
		};
		return ret;
	}
	public int getPuntaje() {
		return puntaje;
	}
}
