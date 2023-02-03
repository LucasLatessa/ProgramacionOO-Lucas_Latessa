package modelo;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unlu.rmimvc.observer.ObservableRemoto;
import observer.Observador;
import observer.Observable;
public class Juego  extends ObservableRemoto implements IJuego{
		private static final int puntosFinales = 15;
		private Jugador jugador1;
		private Jugador jugador2;
		private Mazo mazo;
		private ArrayList<Ronda> rondas;//<1-3>
		private ArrayList<Observador> observadores;
		private EstadoTruco estadoTruco=EstadoTruco.NADA;
		private Carta cartaTirada=null;
		protected Envido envido;
		
	public Carta getCartaTirada() throws RemoteException{
			return cartaTirada;
		}
	public void trucos() throws RemoteException{
		estadoTruco=estadoTruco.aumentar();
	}
	public Juego() {
		observadores=new ArrayList<>();
		rondas=new ArrayList<Ronda>();
	}
	public void agregarJugador(String jugador)throws RemoteException{
		if (this.jugador1==null) {
			this.jugador1=new Jugador(jugador);
			notificarObservadores(Eventos.ESPERANDO_JUGADORES);
		}else if (this.jugador2==null){
			this.jugador2=new Jugador(jugador);
			this.nuevaMano();
			notificarObservadores(Eventos.JUEGO_COMENZADO);
		}
	}
	
	/**tira carta y ya cambia el turno(si no es nula)
	 * @param carta<1-3>
	 * @return carta tirada(si no la encuentra devuelve nulo)
	 */
	public void tirarCarta(int carta) throws RemoteException{
		cartaTirada=getTurno().tirarCarta(carta);
		Ronda ronda=rondas.get(rondas.size()-1);
		if (ronda.isTerminada()){
			newRonda();
			ronda=rondas.get(rondas.size()-1);
		}
		ronda.jugar(getTurno(), cartaTirada); //juego en la ronda la carta con respectivo jugador
		changeTurno();
		if (ronda.isTerminada()){
			if (isFinManoYSumaPuntos()) {
				this.nuevaMano();
				notificarObservadores(Eventos.MANO_TERMINADA);}
			else {
				notificarObservadores(Eventos.RONDA_TERMINADA);}}
		else {
			notificarObservadores(Eventos.SEGUIR_JUEGO);
		}
	}
	
	/**
	 * Le suma el/los punto/s obtenidos al jugador que no es el turno(ya que en el turno el jugador dijo no quiero)
	 */
	public void calcularEnvidoNQ() throws RemoteException{
		int puntos=envido.getPuntos()==1?1:envido.getPuntos();
		Jugador jSumarPuntos=this.getJugadorContra(getTurno());
		jSumarPuntos.incPuntos(puntos);
		envido.setGanadorEnvido(jSumarPuntos);
		turnoLuegoEnvido();
		this.preguntarGanador();
		notificarObservadores(Eventos.SEGUIR_JUEGO);
		}
	/**le suma los puntos obtenidos al jugador que gana el envido
	 * @return devuelve el ganador
	 */
	public void calcularEnvidoQ() throws RemoteException{
		if (envido.envidoPreguntado!=null) {
			envido.queridoElPreguntado();}
		int puntos=envido.getPuntos()==-1?puntosFinales-jugador2.getPuntos():envido.getPuntos();//si los puntos es -1 es porque fue falta envido
		Jugador ganador=envido.calcularGanador(jugador1, jugador2);
		ganador.incPuntos(puntos);
		envido.setGanadorEnvido(ganador);
		turnoLuegoEnvido();
		notificarObservadores(Eventos.ENVIDO_JUGADO);
		}
	public void newRonda() throws RemoteException{
		if (rondas.size()==2) {
			Ronda ronda1=rondas.get(getNroRonda()-2);
			Ronda ronda2=rondas.get(getNroRonda()-1);
			if (ronda1.getGanador()==ronda2.getGanador()) {
				isFinManoYSumaPuntos();
				this.nuevaMano();
				notificarObservadores(Eventos.MANO_TERMINADA);
			}
		}
		Ronda ronda=new Ronda();
		rondas.add(ronda);
	}
	public void cantado(EstadoEnvido estado) throws RemoteException{
		changeTurno();
		IEnvido envid=addPreguntado(estado);//lo agrega 
		notificarObservadores(envid);
	}
	public void cantado(EstadoTruco estado) throws RemoteException {
		turnoPregTruco();
		notificarObservadores(estado);
	}
	public void quiero(EstadoTruco estado) throws RemoteException{
		estadoTruco=estado;
		changeTurno();
		getTurno().setCantoUltimo(true);
		getJugadorContra(getTurno()).setCantoUltimo(false);
		notificarObservadores(Eventos.SEGUIR_JUEGO);
}
	public void nuevaMano() throws RemoteException{
		this.preguntarGanador();
		this.cartaTirada=null;
		rondas=new ArrayList<Ronda>();
		estadoTruco=EstadoTruco.NADA;
		envido=null;
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
	public void repartir() throws RemoteException{
		mazo=new Mazo();
		vaciarCartas();
		for(int i = 0;i < 3;i++) {
			jugador1.setCarta(mazo.dar());
			jugador2.setCarta(mazo.dar());
		};
	}
	public void vaciarCartas( ) throws RemoteException{
			jugador1.limpiarCartas();
			jugador2.limpiarCartas();
		}
	public ArrayList<IJugador> listarJugadores()throws RemoteException{
		ArrayList<IJugador> jugadores=new ArrayList<>() ;
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		return jugadores;
	}
	/**
	 * @return devuelve el ganador del juego, en caso de no haberlo devuelve nulo
	 */
	public void preguntarGanador() throws RemoteException{
		if (jugador1.getPuntos()>=puntosFinales) {
			notificarObservadores(Eventos.JUEGO_TERMINADO);
		}else if (jugador2.getPuntos()>=puntosFinales){
			notificarObservadores(Eventos.JUEGO_TERMINADO);
		}
	}
	/**
	 * Cambia el turno del juego, en caso de que ninguno de los dos haya sido el turno anterior
	    es turno del mano(caso primera ronda).
	 * @throws RemoteException 
	 */
	public void changeTurno() throws RemoteException {
		Ronda ronda=rondas.get(getNroRonda()-1);
		if (ronda.isTerminada()) {
			Jugador jugGana=ronda.getGanador();
			if (jugGana!=null){
				jugGana.setTurno(true);
				getJugadorContra(jugGana).setTurno(false);
			}
			else {
				jugador2.changeTurno();
				jugador1.changeTurno();
				notificarObservadores(Eventos.PARDA);
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
	@Override
	public void turnoPregTruco() throws RemoteException {
		jugador2.changeTurno();
		jugador1.changeTurno();
	}
	public void turnoLuegoEnvido()throws RemoteException {
		Jugador yaTiro=rondas.get(0).jugadorYaTiro();
		if (yaTiro!=null){
			yaTiro.setTurno(false);
			getJugadorContra(yaTiro).setTurno(true);//si un jugador ya tiro es turno del otro jugador	
		}else{
			jugador1.setTurno(false);jugador2.setTurno(false);
			changeTurno();//si no tiro nadie es turno del mano
		}
	}
	/**
	 * @return si termina la mano le suma los puntos al ganador 
	 */
	public boolean isFinManoYSumaPuntos()throws RemoteException {
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
	public void sumarPuntosAlMazo() throws RemoteException{
		EstadoTruco truco=getEstadoTruco();
		int puntos=(rondas.size()==1&&envido==null&&!rondas.get(0).unJugadorYaTiro())?2:truco.getPuntaje();//si es la ronda 1 y el envido no se canto son dos puntos al contra
		getJugadorContra(getTurno()).incPuntos(puntos);
		changeTurno();
		nuevaMano();
		notificarObservadores(Eventos.MANO_TERMINADA);
	}
	public IJugador quienCantoUltimo()throws RemoteException{
		IJugador ret=null;
		if (jugador1.isCantoUltimo()){
			ret=jugador1;
		} else if (jugador2.isCantoUltimo()) {
			ret=jugador2;
		}
		return ret;
	}
	/**no devuelve el puntaje porque se pueden seguir agregando.
	 * @param envido querido
	 */
	public IEnvido addQuerido(EstadoEnvido estado) throws RemoteException{
		envido.addQuerido(estado);
		return envido;
	}
	public IEnvido addPreguntado(EstadoEnvido estado) throws RemoteException{
		if (envido==null) {
			envido=new Envido();}
		envido.addPreguntado(estado);
		return envido;
	}
	/**
	 * @param jugador
	 * @return devuelve el jugador contrario de un jugador
	 */
	private Jugador getJugadorContra(Jugador jugador) {
		Jugador contra = null;
		if (jugador==jugador1){
			contra= jugador2;
		}else if (jugador==jugador2){
			contra= jugador1;
		}
		return contra;
	}
	/**
	 * @return devuelve el ganador del envido en esta mano, devuelve nulo si no hubo
	 */
	public IJugador getGanadorEnvido()throws RemoteException {
		IJugador retorno=null;
		if (envido!=null){
			retorno= envido.getGanadorEnvido();
		}
		return retorno;
	}
	public int getNroRonda() throws RemoteException{
		return rondas.size();
	}
	public IJugador getGanadorDeRonda() throws RemoteException{
		return rondas.get(rondas.size()-1).getGanador();
	}
	public ArrayList<String> getCartasDeRonda() throws RemoteException{
		ArrayList<String> retornar=new ArrayList<String>();
		for(Carta carta: rondas.get(rondas.size()-1).getCartas()) {
			retornar.add(carta.toString());
		}
		return retornar;
	}
	public ArrayList<Integer> getTantosEnvido()throws RemoteException{
		ArrayList<Integer> tantos=new ArrayList();
		tantos.add(envido.getSumatoriajug1());
		tantos.add(envido.getSumatoriajug2());
		return	tantos;
	}
	private Jugador getTurno() {
		return jugador1.isTurno()?jugador1:jugador2;
	}
	public IJugador getITurno() throws RemoteException{
		return jugador1.isTurno()?jugador1:jugador2;
	}
	public EstadoTruco getEstadoTruco() throws RemoteException{
		return estadoTruco;
	}
	public ArrayList<Observador> getObservadores() {
		return observadores;
	}
	public boolean isJugadoresCompletos() throws RemoteException{
		return (this.jugador1!=null &&this.jugador2!=null);
	}
	public String getJugadorUltAgregado() throws RemoteException {
		if (jugador2==null) {
			return jugador1.getNombre();
		}else {
		return jugador2.getNombre();}
	}
	@Override
	public boolean verificarNombre(String nombre)  throws RemoteException{
		boolean puedeUsarEsteNombre=true;
		if (jugador1!=null) {
			puedeUsarEsteNombre=!nombre.equals(jugador1.getNombre());
		}
		if (jugador2!=null) {
			puedeUsarEsteNombre=!nombre.equals(jugador2.getNombre());
		}
		return puedeUsarEsteNombre;
	}
	@Override
	public boolean rondaActualTerminada()  throws RemoteException{
		Ronda ronda=rondas.get(rondas.size()-1);
		return ronda.isTerminada();
	}
	
}