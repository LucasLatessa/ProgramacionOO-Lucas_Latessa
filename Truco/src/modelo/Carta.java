package modelo;

public enum Carta {	
	UNODEESPADA(Palo.ESPADA,1),
	UNODEBASTO(Palo.BASTO,2),
	SIETEDEESPADA(Palo.ESPADA,7),
	SIETEDEORO(Palo.ORO,7),
	TRESDEESPADA(Palo.ESPADA,3),
	TRESDEBASTO(Palo.BASTO,3),
	TRESDEORO(Palo.ORO,3),
	TRESDECOPA(Palo.COPA,3),
	DOSDEESPADA(Palo.ESPADA,2),
	DOSDEBASTO(Palo.BASTO,2),
	DOSDEORO(Palo.ORO,2),
	DOSDECOPA(Palo.COPA,2),
	UNODEORO(Palo.ORO,1),
	UNODECOPA(Palo.COPA,1),
	DOCEDEESPADA(Palo.ESPADA,12),
	DOCEDEBASTO(Palo.BASTO,12),
	DOCEDEORO(Palo.ORO,12),
	DOCEDECOPA(Palo.COPA,12),
	ONCEDEESPADA(Palo.ESPADA,12),
	ONCEDEBASTO(Palo.BASTO,11),
	ONCEDEORO(Palo.ORO,11),
	ONCEDECOPA(Palo.COPA,11),
	DIEZDEESPADA(Palo.ESPADA,10),
	DIEZDEBASTO(Palo.BASTO,10),
	DIEZDEORO(Palo.ORO,10),
	DIEZDECOPA(Palo.COPA,10),
	SIETEDEBASTO(Palo.BASTO,7),
	SIETEDECOPA(Palo.COPA,7),
	SEISDEESPADA(Palo.ESPADA,6),
	SEISDEBASTO(Palo.BASTO,6),
	SEISDEORO(Palo.ORO,6),
	SEISDECOPA(Palo.COPA,6),
	CINCODEESPADA(Palo.ESPADA,5),
	CINCODEBASTO(Palo.BASTO,5),
	CINCODEORO(Palo.ORO,5),
	CINCODECOPA(Palo.COPA,5),
	CUATRODEESPADA(Palo.ESPADA,4),
	CUATRODEBASTO(Palo.BASTO,4),
	CUATRODEORO(Palo.ORO,4),
	CUATRODECOPA(Palo.COPA,4);
	
	private Palo palo;
	private int valor;
	private Carta (Palo palo,int valor){
		this.palo = palo;
		this.valor=valor;
	}

	public String getPalo() {
		return palo.toString().toLowerCase();
	}
	public int getValor() {
		return valor;
	}
	public String toString() {
		return getValor()+" de "+getPalo();
	}
}
