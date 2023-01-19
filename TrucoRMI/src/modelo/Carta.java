package modelo;

import java.io.Serializable;

public class  Carta implements Serializable {
	private int valor;
	private int orden;
	private int puntajeEnvido;
	private Palo palo;
	public Carta(int valor,Palo palo) {
		this.valor=valor;
		this.puntajeEnvido=valor<10?valor:0;//si el valor es menor a 10 ese es su puntaje de envido, sino el puntaje es 0
		this.palo=palo;
		switch (valor){
		case 1:
			orden= palo==Palo.BASTO?2:0;
			orden= palo==Palo.ESPADA?1:7;//si el palo es espada el orden es 1, si es basto es 2 y si no es nunguno(copa, oro) es orden 7
			break;
		case 7:
			orden= palo==Palo.ESPADA?4:0;
			orden= palo==Palo.ORO?3:11;//si el palo es espada el orden es 4, si es oro es 2 y si no es nunguno(copa, basto) es orden 11
			break;
		case 3:
			orden=5;
			break;
		case 2:
			orden=6;
			break;
		case 12:
			orden=8;
			break;
		case 11:
			orden=9;
			break;
		case 10:
			orden=10;
			break;
		case 6:
			orden=12;
			break;
		case 5:
			orden=13;
			break;
		case 4:
			orden=14;
		}
	}
	public int getValor() {
		return valor;
	}
	public int getOrden() {
		return orden;
	}
	/**
	 * @param c Una carta
	 * @return Retorna la carta mayor, de ser iguales devuelve null
	 */
	public Carta mayor(Carta c) {
		Carta cMayor;
		cMayor=getOrden()<c.getOrden()?this:c;
		cMayor=getOrden()==c.getOrden()?null:cMayor;
		return cMayor;
	}
	public int getPuntajeEnvido() {
		return puntajeEnvido;
	}
	public Palo getPalo() {
		return palo;
	}
	public String toString() {
		return valor+" de "+palo;
	}

}
