package modelo;

public enum EstadoEnvido {
	ENVIDOQ(2,QuerNoQuer.QUERIDO),
	REALENVIDOQ(3,QuerNoQuer.QUERIDO),
	FALTAENVIDOQ(0,QuerNoQuer.QUERIDO),//se calcula con los puntos que le faltan al contincante para llegar a 15
	ENVIDONQ(1,QuerNoQuer.NOQUERIDO),
	REALENVIDONQ(1,QuerNoQuer.NOQUERIDO),
	FALTAENVIDONQ(1,QuerNoQuer.NOQUERIDO);
	private int puntaje;
	private QuerNoQuer qnq;
	private EstadoEnvido(int puntaje,QuerNoQuer qnq){
		this.puntaje= puntaje;
		this.qnq= qnq;
	}
	public boolean isquerido() {
		return qnq==QuerNoQuer.QUERIDO?true:false;
	}
	public int getPuntaje() {
		return puntaje;
	}
}
