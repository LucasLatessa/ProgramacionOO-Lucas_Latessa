package modelo;

public enum Carta {		
		UNODEESPADA(Palo.ESPADA,Valor.UNO),
		UNODEBASTO(Palo.BASTO,Valor.UNO),
		SIETEDEESPADA(Palo.ESPADA,Valor.SIETE),
		SIETEDEORO(Palo.ORO,Valor.SIETE),
		TRESDEESPADA(Palo.ESPADA,Valor.TRES),
		TRESDEBASTO(Palo.BASTO,Valor.TRES),
		TRESDEORO(Palo.ORO,Valor.TRES),
		TRESDECOPA(Palo.COPA,Valor.TRES),
		DOSDEESPADA(Palo.ESPADA,Valor.DOS),
		DOSDEBASTO(Palo.BASTO,Valor.DOS),
		DOSDEORO(Palo.ORO,Valor.DOS),
		DOSDECOPA(Palo.COPA,Valor.DOS),
		UNODEORO(Palo.ORO,Valor.UNO),
		UNODECOPA(Palo.COPA,Valor.UNO),
		DOCEDEESPADA(Palo.ESPADA,Valor.DOCE),
		DOCEDEBASTO(Palo.BASTO,Valor.DOCE),
		DOCEDEORO(Palo.ORO,Valor.DOCE),
		DOCEDECOPA(Palo.COPA,Valor.DOCE),
		ONCEDEESPADA(Palo.ESPADA,Valor.ONCE),
		ONCEDEBASTO(Palo.BASTO,Valor.ONCE),
		ONCEDEORO(Palo.ORO,Valor.ONCE),
		ONCEDECOPA(Palo.COPA,Valor.ONCE),
		DIEZDEESPADA(Palo.ESPADA,Valor.DIEZ),
		DIEZDEBASTO(Palo.BASTO,Valor.DIEZ),
		DIEZDEORO(Palo.ORO,Valor.DIEZ),
		DIEZDECOPA(Palo.COPA,Valor.DIEZ),
		SIETEDEBASTO(Palo.BASTO,Valor.SIETE),
		SIETEDECOPA(Palo.COPA,Valor.SIETE),
		SEISDEESPADA(Palo.ESPADA,Valor.SEIS),
		SEISDEBASTO(Palo.BASTO,Valor.SEIS),
		SEISDEORO(Palo.ORO,Valor.SEIS),
		SEISDECOPA(Palo.COPA,Valor.SEIS),
		CINCODEESPADA(Palo.ESPADA,Valor.CINCO),
		CINCODEBASTO(Palo.BASTO,Valor.CINCO),
		CINCODEORO(Palo.ORO,Valor.CINCO),
		CINCODECOPA(Palo.COPA,Valor.CINCO),
		CUATRODEESPADA(Palo.ESPADA,Valor.CUATRO),
		CUATRODEBASTO(Palo.BASTO,Valor.CUATRO),
		CUATRODEORO(Palo.ORO,Valor.CUATRO),
		CUATRODECOPA(Palo.COPA,Valor.CUATRO);
	private Palo palo;
	private Valor valor;
	private Carta (Palo palo,Valor valor){
		this.palo = palo;
		this.valor=valor;
	}

	public String getPalo() {
		return palo.toString();
	}
	public String getValor() {
		return valor.toString();
	}
	public int getValoracion() {
		return valor.gatValoracion();
	}
}
