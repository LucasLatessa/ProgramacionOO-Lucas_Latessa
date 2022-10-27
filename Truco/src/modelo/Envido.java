package modelo;

import java.util.ArrayList;

public class Envido {
	private ArrayList<EstadoEnvido> envidosCantados;
	public Envido() {
		envidosCantados=new ArrayList<EstadoEnvido>();
		
	}
	public Jugador getGanador(Jugador jugador1,Jugador jugador2) {
		int sumatoriajug1=calcularTantos(jugador1);
		int sumatoriajug2=calcularTantos(jugador2);
		if (sumatoriajug1==sumatoriajug2){
			return  jugador1.isMano()? jugador1:jugador2;//si los tantos son iguales, gana el mano
		}else {
			return (sumatoriajug1>sumatoriajug2)?jugador1:jugador2;
		}
	}
	/**
	 * @return Retorna la sumatoria de puntos que se le tienen que sumar a quien gana el envido, o a quien lo canto y no le dieron
	 */
	public int getPuntos() {
		int sumatoria=0;
		for(EstadoEnvido estado:envidosCantados) {
			//si hay mas de 1 canto y el ultimo no se quiso, el puntaje es la sumatoria de sus anteriores queridos
			sumatoria+= (estado.ordinal()>3&&envidosCantados.size()>1)?0:estado.getPuntaje();
			if (estado==EstadoEnvido.FALTAENVIDOQ) {//si se quiere falta envido la calcula el juego
				sumatoria=0;
				}
			}
		return sumatoria;
	}
	private int calcularTantos(Jugador jugador) {
		ArrayList<Carta> cartas=jugador.getCartas();
		return Math.max(
				Math.max(calcularEntreDos(cartas.get(0), cartas.get(1)),
				 calcularEntreDos(cartas.get(0), cartas.get(2))),
				 calcularEntreDos(cartas.get(1), cartas.get(2)));}
	
	public static int calcularTantos(Carta c1,Carta c2,Carta c3) {//solo para pruebas
		return Math.max(
				Math.max(calcularEntreDos(c1, c2),
				 calcularEntreDos(c1, c3)),
				 calcularEntreDos(c1, c3));
}
	public static int calcularEntreDos(Carta c1, Carta c2){
        if (c1.getPalo() == c2.getPalo())
            return c1.getPuntajeEnvido()+ c2.getPuntajeEnvido() + 20;
        else
            return Math.max(c1.getPuntajeEnvido(),c2.getPuntajeEnvido());
    }
	public void agregar(EstadoEnvido estado) {
		envidosCantados.add(estado);
		
	}
}
