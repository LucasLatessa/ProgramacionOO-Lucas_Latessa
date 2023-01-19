package modelo;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unlu.rmimvc.observer.ObservableRemoto;
import observer.Observador;
import observer.Observable;
public class Juego extends ObservableRemoto implements IJuego, Serializable{
		private static final int puntosFinales = 15;
		private Jugador jugador1;
		private Jugador jugador2;
		private Mazo mazo;
		private ArrayList<Ronda> rondas;//<1-3>
		private EstadoTruco estadoTruco=EstadoTruco.NADA;
		private Carta cartaTirada=null;
		protected Envido envido;
		private static Juego instancia;
		
	@Override
	public Carta getCartaTirada()  throws RemoteException {
			return cartaTirada;
		}
	@Override
	public void trucos() throws RemoteException  {
		estadoTruco=estadoTruco.aumentar();
	}
	public static Juego getInstancia() {
		if (instancia==null) {
			instancia=new Juego();
		}
		return instancia;
	}
	public Juego() {
		rondas=new ArrayList<Ronda>();
	}
	@Override
	public void agregarJugador(String jugador,int puerto) throws RemoteException{
		if (this.jugador1==null) {
			this.jugador1=new Jugador(jugador,puerto);
			notificarObservadores(Eventos.ESPERANDO_JUGADORES);
		}else if (this.jugador2==null){
			this.jugador2=new Jugador(jugador,puerto);
			this.nuevaMano();
			notificarObservadores(Eventos.JUEGO_COMENZADO);
		}
	}
	/**tira carta y ya cambia el turno(si no es nula)
	 * @param carta<1-3>
	 * @return carta tirada(si no la encuentra devuelve nulo)
	 * @throws RemoteException 
	 */
	@Override
	public void tirarCarta(int carta) throws RemoteException {
		Carta cartatirada=getTurno().tirarCarta(carta);
		cartaTirada=cartatirada;
		Ronda ronda=rondas.get(rondas.size()-1);
		ronda.jugar(getTurno(), cartatirada); //juego en la ronda la carta con respectivo jugador
		changeTurno();
		
		if (ronda.isTerminada()){
			notificarObservadores(Eventos.RONDA_TERMINADA);
		}
	}
	/**
	 * Cambia el turno del juego, en caso de que ninguno de los dos haya sido el turno anterior
	    es turno del mano(caso primera ronda).
	 * @throws RemoteException 
	 */
	@Override
	public void changeTurno() throws RemoteException {
		Ronda ronda=rondas.get(getNroRonda()-1);
		if (ronda.isTerminada()) {
			Jugador jugGana=ronda.getGanador();
			if (siFinManoYSumoPuntos()) {
				this.nuevaMano();
				notificarObservadores(Eventos.MANO_TERMINADA);
			}else if (jugGana!=null){
				jugGana.setTurno(true);
				contra(jugGana).setTurno(false);
				newRonda();
			}
			else {
				jugador2.changeTurno();
				jugador1.changeTurno();
				newRonda();
				notificarObservadores(Eventos.PARDA);
			}
		}else if (jugador1.isTurno()||jugador2.isTurno()) {//mientras transcurre la ronda
			jugador2.changeTurno();
			jugador1.changeTurno();
		}else if (jugador2.isMano()){
			jugador2.setTurno(true);}
		else {
			jugador1.setTurno(true);;
				}
			}
	/**
	 * Le suma el/los punto/s obtenidos al jugador que no es el turno(ya que en el turno el jugador dijo no quiero)
	 * @throws RemoteException 
	 */
	@Override
	public void calcularEnvidoNQ() throws RemoteException {
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
			notificarObservadores(Eventos.JUEGO_TERMINADO);
		}else {
			notificarObservadores(Eventos.SEGUIR_JUEGO);
		}
	}
	/**le suma los puntos obtenidos al jugador que gana el envido
	 * @return devuelve el ganador
	 * @throws RemoteException 
	 */
	@Override
	public void calcularEnvidoQ() throws RemoteException {
		if (envido.envidoPreguntado!=null) {
			envido.queridoElPreguntado();}
		int puntos=envido.getPuntos()==-1?puntosFinales-jugador2.getPuntos():envido.getPuntos();//si los puntos es -1 es porque fue falta envido
		Jugador ganador=envido.calcularGanador(jugador1, jugador2);
		ganador.incPuntos(puntos);
		envido.setGanadorEnvido(ganador);
		turnoLuegoEnvido();
		notificarObservadores(Eventos.ENVIDO_JUGADO);
		if(this.preguntarGanador()!=null) {
		notificarObservadores(Eventos.JUEGO_TERMINADO);
		}}
	@Override
	public void newRonda() throws RemoteException {
		cartaTirada=null;
		if (rondas.size()==2) {
			Ronda ronda1=rondas.get(getNroRonda()-2);
			Ronda ronda2=rondas.get(getNroRonda()-1);
			if (ronda1.getGanador()==ronda2.getGanador()) {
				siFinManoYSumoPuntos();
				this.nuevaMano();
				notificarObservadores(Eventos.MANO_TERMINADA);
			}
		}
		Ronda ronda=new Ronda();
		rondas.add(ronda);
	}
	@Override
	public void cantado(EstadoEnvido estado) throws RemoteException {
		changeTurno();
		Envido envid=addPreguntado(estado);//lo agrega 
		notificarObservadores(envid);
	}
	@Override
	public void cantado(EstadoTruco estado) throws RemoteException {
		changeTurno();
		notificarObservadores(estado);
	}
	@Override
	public void quiero(EstadoTruco estado) throws RemoteException {
		estadoTruco=estado;
		changeTurno();
		getTurno().setCantoUltimo(true);
		contra(getTurno()).setCantoUltimo(false);
		notificarObservadores(Eventos.SEGUIR_JUEGO);
}
	@Override
	public void nuevaMano() throws RemoteException {
		if(this.preguntarGanador()!=null) {
			notificarObservadores(Eventos.JUEGO_TERMINADO);
			}
		rondas=new ArrayList<Ronda>();
		estadoTruco=EstadoTruco.NADA;
		jugador1.setCantoUltimo(false);
		jugador2.setCantoUltimo(false);
		repartir();
		if (!jugador1.isMano()&&!jugador2.isMano()) {
			jugador1.invertirMano();//la primer mano del juego es MANO el jugador1
		}else {
			jugador1.invertirMano();
			jugador2.invertirMano();
		}
		newRonda();
		changeTurno();
		}
	@Override
	public void repartir() throws RemoteException  {
		mazo=new Mazo();
		vaciarCartas();
		for(int i = 0;i < 3;i++) {
			jugador1.setCarta(mazo.dar());
			jugador2.setCarta(mazo.dar());
		};
	}
	@Override
	public void vaciarCartas() throws RemoteException {
			jugador1.limpiarCartas();
			jugador2.limpiarCartas();
		}
	@Override
	public ArrayList<IJugador> listarJugadores() throws RemoteException {
		ArrayList<IJugador> jugadores=new ArrayList<>() ;
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		return jugadores;
	}
	/**
	 * @return devuelve el ganador del juego, en caso de no haberlo devuelve nulo
	 */
	@Override
	public IJugador preguntarGanador()  throws RemoteException {
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
	@Override
	public IJugador getITurno() throws RemoteException  {
		return jugador1.isTurno()?jugador1:jugador2;
	}
	@Override
	public EstadoTruco getEstadoTruco() throws RemoteException  {
		return estadoTruco;
	}
	/**
	 * @return si termina la mano le suma los puntos al ganador 
	 */
	@Override
	public boolean siFinManoYSumoPuntos() throws RemoteException  {
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
	@Override
	public void sumarPuntosAlMazo() throws RemoteException {
		EstadoTruco truco=getEstadoTruco();
		int puntos=(rondas.size()==1&&envido==null&&!rondas.get(0).unJugadorYaTiro())?2:truco.getPuntaje();//si es la ronda 1 y el envido no se canto son dos puntos al contra
		contra(getTurno()).incPuntos(puntos);
		changeTurno();
		nuevaMano();
		notificarObservadores(Eventos.MANO_TERMINADA);
	}
	@Override
	public void turnoLuegoEnvido() throws RemoteException {
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
	public int getNroRonda()  throws RemoteException {
		return rondas.size();
	}
	@Override
	public IJugador obtenerGanadorDeRonda()  throws RemoteException {
		return rondas.get(rondas.size()-2).getGanador();
	}
	@Override
	public ArrayList<Integer> obtenerTantosEnvido() throws RemoteException {
		ArrayList<Integer> tantos=new ArrayList();
		tantos.add(envido.getSumatoriajug1());
		tantos.add(envido.getSumatoriajug2());
		return	tantos;
	}
	@Override
	public IJugador quienCantoUltimo() throws RemoteException {
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
	@Override
	public IEnvido addQuerido(EstadoEnvido estado) throws RemoteException  {
		envido.addQuerido(estado);
		return envido;
	}
	@Override
	public Envido addPreguntado(EstadoEnvido estado) throws RemoteException  {
		if (envido==null) {
			envido=new Envido();}
		envido.addPreguntado(estado);
		return envido;
	}
	/**
	 * @return devuelve el ganador del envido en esta mano, devuelve nulo si no hubo
	 */
	@Override
	public IJugador getGanadorEnvido()  throws RemoteException {
		IJugador retorno=null;
		if (envido!=null){
			retorno= envido.getGanadorEnvido();
		}
		return retorno;
	}
}
	
