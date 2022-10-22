package modelo;

public enum Valor {
	UNO(1),
	DOS(2),
	TRES(3),
	CUATRO(4),
	CINCO(5),
	SEIS(6),
	SIETE(7),
	DIEZ(10),
	ONCE(11),
	DOCE(12);
	private int valoracion;
	private Valor (int valoracion){
		this.valoracion=valoracion;
	}
	public int gatValoracion() {
		return this.valoracion;
	}
}
