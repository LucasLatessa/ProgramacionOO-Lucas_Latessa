package modelo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import observer.Observador;
import observer.Observable;
public class Juego implements Observable{
		private static final int puntosFinales = 15;
		private Jugador jugador1;
		private Jugador jugador2;
		private Mazo mazo;
		private ArrayList<Ronda> rondas;//<1-3>
		private ArrayList<Observador> observadores;
		private EstadoTruco estadoTruco=EstadoTruco.NADA;
		private Carta cartaTirada=null;
		protected Envido envido;
		
	public Carta getCartaTirada() {
			return cartaTirada;
		}
	public void trucos() {
		estadoTruco=estadoTruco.aumentar();
	}
	public Juego() {
		observadores=new ArrayList<>();
		rondas=new ArrayList<Ronda>();
	}
	public void agregarJugador(String jugador){
		if (this.jugador1==null) {
			this.jugador1=new Jugador(jugador);
			notificar(Eventos.ESPERANDO_JUGADORES);
		}else if (this.jugador2==null){
			this.jugador2=new Jugador(jugador);
			this.nuevaMano();
			notificar(Eventos.JUEGO_COMENZADO);
		}
	}
	/**tira carta y ya cambia el turno(si no es nula)
	 * @param carta<1-3>
	 * @return carta tirada(si no la encuentra devuelve nulo)
	 */
	public void tirarCarta(int carta) {
		Carta cartatirada=getTurno().tirarCarta(carta);
		cartaTirada=cartatirada;
		Ronda ronda=rondas.get(rondas.size()-1);
		ronda.jugar(getTurno(), cartatirada); //juego en la ronda la carta con respectivo jugador
		changeTurno();
		
		if (ronda.isTerminada()){
			notificar(Eventos.RONDA_TERMINADA);
		}
	}
	/**
	 * Cambia el turno del juego, en caso de que ninguno de los dos haya sido el turno anterior
	    es turno del mano(caso primera ronda).
	 */
	public void changeTurno() {
		Ronda ronda=rondas.get(getNroRonda()-1);
		if (ronda.isTerminada()) {
			Jugador jugGana=ronda.getGanador();
			if (siFinManoYSumoPuntos()) {
				this.nuevaMano();
				notificar(Eventos.MANO_TERMINADA);
			}else if (jugGana!=null){
				jugGana.setTurno(true);
				contra(jugGana).setTurno(false);
				newRonda();
			}
			else {
				jugador2.changeTurno();
				jugador1.changeTurno();
				newRonda();
				notificar(Eventos.PARDA);
			}
		}else if (jugador1.isTurno()||jugador2.isTurno()) {//mientras transcurre la ronda
			jugador2.changeTurno();
			jugador1.changeTurno();
		}else if (jugador1.isMano()){
			jugador1.setTurno(true);}
		else {
			jugador2.setTurno(true);;
				}
			}
	/**
	 * Le suma el/los punto/s obtenidos al jugador que no es el turno(ya que en el turno el jugador dijo no quiero)
	 */
	public void calcularEnvidoNQ() {
		int puntos=envido.getPuntos()==1?1:envido.getPuntos();
		if (jugador1.isTurno()) {
			jugador2.incPuntos(puntos);
			envido.setGanadorEnvido(jugador2);
		}
		else if (jugador2.isTurno()) {
				jugador1.incPuntos(puntos);
				envido.setGanadorEnvido(jugador1);
			}
		turnoLuegoEnvido();
		if(this.preguntarGanador()!=null) {
			notificar(Eventos.JUEGO_TERMINADO);
		}else {
			notificar(Eventos.SEGUIR_JUEGO);
		}
	}
	/**le suma los puntos obtenidos al jugador que gana el envido
	 * @return devuelve el ganador
	 */
	public void calcularEnvidoQ() {
		if (envido.envidoPreguntado!=null) {
			envido.queridoElPreguntado();}
		int puntos=envido.getPuntos()==-1?puntosFinales-jugador2.getPuntos():envido.getPuntos();//si los puntos es -1 es porque fue falta envido
		Jugador ganador=envido.calcularGanador(jugador1, jugador2);
		ganador.incPuntos(puntos);
		envido.setGanadorEnvido(ganador);
		turnoLuegoEnvido();
		notificar(Eventos.ENVIDO_JUGADO);
		if(this.preguntarGanador()!=null) {
		notificar(Eventos.JUEGO_TERMINADO);
		}}
	public ArrayList<Observador> getObservadores() {
		return observadores;
	}
	public void newRonda() {
		cartaTirada=null;
		if (rondas.size()==2) {
			Ronda ronda1=rondas.get(getNroRonda()-2);
			Ronda ronda2=rondas.get(getNroRonda()-1);
			if (ronda1.getGanador()==ronda2.getGanador()) {
				siFinManoYSumoPuntos();
				this.nuevaMano();
				notificar(Eventos.MANO_TERMINADA);
			}
		}
		Ronda ronda=new Ronda();
		rondas.add(ronda);
	}
	public void cantado(EstadoEnvido estado) {
		changeTurno();
		IEnvido envid=addPreguntado(estado);//lo agrega 
		notificar(envid);
	}
	public void cantado(EstadoTruco estado) {
		changeTurno();
		notificar(estado);
	}
	public void quiero(EstadoTruco estado) {
		estadoTruco=estado;
		changeTurno();
		getTurno().setCantoUltimo(true);
		contra(getTurno()).setCantoUltimo(false);
		notificar(Eventos.SEGUIR_JUEGO);
}
	public void nuevaMano() {
		if(this.preguntarGanador()!=null) {
			notificar(Eventos.JUEGO_TERMINADO);
			}
		rondas=new ArrayList<Ronda>();
		estadoTruco=EstadoTruco.NADA;
		jugador1.setCantoUltimo(false);
		jugador2.setCantoUltimo(false);
		repartir();
		if (!jugador1.isMano()&&!jugador2.isMano()) {
			jugador2.invertirMano();//la primer mano del juego es MANO el jugador2
		}else {
			jugador1.invertirMano();
			jugador2.invertirMano();
		}
		newRonda();
		changeTurno();
		}
	public void repartir() {
		mazo=new Mazo();
		vaciarCartas();
		for(int i = 0;i < 3;i++) {
			jugador1.setCarta(mazo.dar());
			jugador2.setCarta(mazo.dar());
		};
	}
	public void vaciarCartas( ) {
			jugador1.limpiarCartas();
			jugador2.limpiarCartas();
		}
	public ArrayList<IJugador> listarJugadores(){
		ArrayList<IJugador> jugadores=new ArrayList<>() ;
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		return jugadores;
	}
	/**
	 * @return devuelve el ganador del juego, en caso de no haberlo devuelve nulo
	 */
	public IJugador preguntarGanador() {
		IJugador ganador=null;
		if (jugador1.getPuntos()>=puntosFinales) {
			ganador=jugador1;
		}else if (jugador2.getPuntos()>=puntosFinales){
			ganador=jugador2;
		}
		return ganador;
	}
	private Jugador getJugador1() {
		return jugador1;
	}
	private Jugador getJugador2() {
		return jugador2;
	}
	private Jugador getTurno() {
		return jugador1.isTurno()?jugador1:jugador2;
	}
	public IJugador getITurno() {
		return jugador1.isTurno()?jugador1:jugador2;
	}
	public EstadoTruco getEstadoTruco() {
		return estadoTruco;
	}
	/**
	 * @return si termina la mano le suma los puntos al ganador 
	 */
	public boolean siFinManoYSumoPuntos() {
		boolean retorno=false;
		int cont1=0;
		int parda=0;
		int cont2=0;
		ArrayList<Jugador> ganadores=new ArrayList<Jugador>();
		for (int i=0;i<rondas.size();i++) {//sumo los ganadores de las rondas
			ganadores.add(rondas.get(i).getGanador());}
		for (Jugador jug:ganadores) {
			cont1+=(jug==jugador1)?1:0;
			cont2+=(jug==jugador2)?1:0;
			parda+=(jug==null)?1:0;
		}
		int puntos=getEstadoTruco().getPuntaje();
		if (cont1>cont2&&(cont1==2||parda==1)) {
			jugador1.incPuntos(puntos);
			retorno=true;
		}else if (cont2>cont1&&(cont2==2||parda==1)) {
			jugador2.incPuntos(puntos);
			retorno=true;
		}else if (parda==3){
			if (jugador1.isMano()) {
				jugador1.incPuntos(puntos);
			} else {
				jugador2.incPuntos(puntos);
			}
		}
		return retorno;
	}
	public void sumarPuntosAlMazo() {
		EstadoTruco truco=getEstadoTruco();
		int puntos=(rondas.size()==1&&envido==null&&!rondas.get(0).unJugadorYaTiro())?2:truco.getPuntaje();//si es la ronda 1 y el envido no se canto son dos puntos al contra
		contra(getTurno()).incPuntos(puntos);
		changeTurno();
		nuevaMano();
		notificar(Eventos.MANO_TERMINADA);
	}
	public void turnoLuegoEnvido() {
		Jugador yaTiro=rondas.get(0).jugadorYaTiro();
		if (yaTiro!=null){
			yaTiro.setTurno(false);
			contra(yaTiro).setTurno(true);//si un jugador ya tiro es turno del otro jugador	
		}else{
			jugador1.setTurno(false);jugador2.setTurno(false);
			changeTurno();//si no tiro nadie es turno del mano
		}
	}
	/**
	 * @param jugador
	 * @return devuelve el jugador contrario de un jugador
	 */
	private Jugador contra(Jugador jugador) {
		Jugador contra = null;
		if (jugador==jugador1){
			contra= jugador2;
		}else if (jugador==jugador2){
			contra= jugador1;
		}
		return contra;
	}
	@Override
	public void notificar(Object evento) {
		for (Observador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}
	@Override
	public void agregarObservador(Observador observador) {
		this.observadores.add(observador);
	}
	public int getNroRonda() {
		return rondas.size();
	}
	public IJugador obtenerGanadorDeRonda() {
		return rondas.get(rondas.size()-2).getGanador();
	}
	public ArrayList<Integer> obtenerTantosEnvido(){
		ArrayList<Integer> tantos=new ArrayList();
		tantos.add(envido.getSumatoriajug1());
		tantos.add(envido.getSumatoriajug2());
		return	tantos;
	}
	public IJugador quienCantoUltimo(){
		IJugador ret=null;
		if (jugador1.isCantoUltimo()){
			ret=jugador1;
		} else if (jugador2.isCantoUltimo()) {
			ret=jugador2;
		}
		return ret;
	}
	//PASO EL ENVIDO DE RONDA AL JUEGO
	//
	/**no devuelve el puntaje porque se pueden seguir agregando.
	 * @param envido querido
	 */
	public IEnvido addQuerido(EstadoEnvido estado) {
		envido.addQuerido(estado);
		return envido;
	}
	public IEnvido addPreguntado(EstadoEnvido estado) {
		if (envido==null) {
			envido=new Envido();}
		envido.addPreguntado(estado);
		return envido;
	}
	/**
	 * @return devuelve el ganador del envido en esta mano, devuelve nulo si no hubo
	 */
	public IJugador getGanadorEnvido() {
		IJugador retorno=null;
		if (envido!=null){
			retorno= envido.getGanadorEnvido();
		}
		return retorno;
	}
}
	
