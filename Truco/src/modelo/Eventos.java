package modelo;

public enum Eventos {
	JUEGO_INICIADO(0,"",""),
	JUEGO_TERMINADO(0,"",""),
	TRUCO_CANTADO(1,"canto","truco"),
	RETRUCO_CANTADO(2,"canto","retruco"),
	VALECUATRO_CANTADO(3,"canto","vale cuatro"),
	ENVIDO_CANTADO(1,"canto", "envido"),
	REALENVIDO_CANTADO(2,"canto","real envido"),
	FALTAENVIDO_CANTADO(1,"canto","falta envido"),
	TRUCO_QUERIDO(2,"quiso","truco"),
	RETRUCO_QUERIDO(3,"quiso","retruco"),
	VALECUATRO_QUERIDO(4,"quiso","vale cuatro"),
	ENVIDO_QUERIDO(2,"quiso", "envido"),
	REALENVIDO_QUERIDO(3,"quiso","real envido"),
	FALTAENVIDO_QUERIDO(0,"quiso","falta envido");//se calcula con los puntos que le faltan al contincante para llegar a 15
	private int puntaje;
	private String cantadoQuerido;
	private String evento;
	/**
	 * @param puntaje: en caso de que el evento genere algun puntaje, sino es 0
	 */
	private Eventos (int puntaje,String cq,String evento){
		this.puntaje = puntaje;
		this.cantadoQuerido = cq;
		this.evento=evento;
	}
	public String getCantadoQuerido() {
		return this.cantadoQuerido;
	}
	public String getEvento() {
		return this.evento;
	}
	public int getPuntaje() {
		return this.puntaje;
	}


}
