package modelo;

import java.util.ArrayList;

/** Solo instanciar si por lo menos un envido se quiere
 * @author lucas
 *
 */
public class Envido implements IEnvido {
	private ArrayList<EstadoEnvido> envidosQueridos;
	protected EstadoEnvido envidoPreguntado;
	private int sumatoriajug1;
	private int sumatoriajug2;
	private Jugador ganadorEnvido;
	public void setGanadorEnvido(Jugador ganadorEnvido) {
		this.ganadorEnvido = ganadorEnvido;
	}
	public Jugador getGanadorEnvido() {
		return ganadorEnvido;
	}
	public int getSumatoriajug1() {
		return sumatoriajug1;
	}
	public int getSumatoriajug2() {
		return sumatoriajug2;
	}
	public EstadoEnvido getEnvidoPreguntado() {
		return envidoPreguntado;
	}
	public Envido() {
		envidosQueridos=new ArrayList<EstadoEnvido>();
	}
	public Jugador calcularGanador(Jugador jugador1,Jugador jugador2) {
		sumatoriajug1=calcularTantos(jugador1);
		sumatoriajug2=calcularTantos(jugador2);
		if (sumatoriajug1==sumatoriajug2){
			return  jugador1.isMano()? jugador1:jugador2;//si los tantos son iguales, gana el mano
		}else {
			return (sumatoriajug1>sumatoriajug2)?jugador1:jugador2;
		}
	}
	
	private int calcularTantos(Jugador jugador) {
		ArrayList<Carta> cartas=jugador.getCartas();
		Carta carta3=cartas.size()==3?cartas.get(2):jugador.getCartaTirada();
		return Math.max(
				Math.max(calcularEntreDos(cartas.get(0), cartas.get(1)),
				 calcularEntreDos(cartas.get(0), carta3)),
				 calcularEntreDos(cartas.get(1), carta3));}
	
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
	/**
	 * @return Retorna la sumatoria de puntos que se le tienen que sumar a quien gana el envido, o a quien lo canto y no le dieron
	 */
	public int getPuntos() {
		int sumatoria=0;
		for(EstadoEnvido estado:envidosQueridos) {
			// el puntaje es la sumatoria de los queridos
			sumatoria+= estado.getPuntaje();
			if (estado==EstadoEnvido.FALTAENVIDO) {//si se quiere falta envido la calcula el juego
				sumatoria=-1;
				}
			}
		sumatoria+= sumatoria==0?1:0;//cuando cantaron uno y no se quiso
		return sumatoria;
	}
	public void addPreguntado(EstadoEnvido envido) {
		if (envidoPreguntado!=null) {
			queridoElPreguntado();
		}
		envidoPreguntado=envido;
	}
	public ArrayList<EstadoEnvido> addQuerido(EstadoEnvido estado) {
		envidosQueridos.add(estado);
		return envidosQueridos;
	}
	public ArrayList<EstadoEnvido> queridoElPreguntado() {
		if (envidoPreguntado!=null) {
			envidosQueridos.add(envidoPreguntado);
			envidoPreguntado=null;
		}
		return envidosQueridos;
	}
	public ArrayList<EstadoEnvido> getEnvidosQueridos() {
		return envidosQueridos;
	}
	@Override
	public boolean hayQueridos() {
		return this.envidosQueridos.size()!=0;
	}
	public ArrayList<String> puedeCantar() {
		ArrayList<String> puedeCantar=new ArrayList<String>();
		switch (envidoPreguntado) {
		case ENVIDO:
			if (envidosQueridos.size()==0) {
			puedeCantar.add("envido");}
			puedeCantar.add("real envido");
		case REALENVIDO:
			puedeCantar.add("falta envido");
		}
		return puedeCantar;
	}
}
