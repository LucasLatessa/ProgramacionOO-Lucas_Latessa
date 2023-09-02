package modelo;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.observer.ObservableRemoto;
import observer.Observador;
import observer.Observable;
public class Juego extends ObservableRemoto implements  IJuego,Serializable{
	private Jugador jugadorTurno;
	private Mazo mazo;
	private ArrayList<Jugador>jugadores;
	private ArrayList<Observador> observadores;
	private int pozo=0;
	public Juego(){
		this.jugadores = new ArrayList<>();
		this.observadores=new ArrayList<>();
		this.mazo=new Mazo();
	}
	@Override
	public void agregarJugador(String id) throws RemoteException {
		
		Jugador jugador=new Jugador(id);
		jugadores.add(jugador);
		if (jugadores.size()==5) {//VALIDO HASTA 5 JUGADORES
			this.notificarObservadores(Eventos.NO_ENTRAN_MAS_JUGADORES);
		}else if (jugadores.size()>=2) {
			this.notificarObservadores(Eventos.PUEDE_EMPEZAR_JUEGO);
		}else {
			this.notificarObservadores(Eventos.JUGADOR_AGREGADO);	
		}
	}
	@Override
	public void jugar() throws RemoteException {
		if (jugadorTurno==null) {//solo para la primera mano
			jugadorTurno=jugadores.get(0);
		}
		if (jugadorTurno.getDinero()!=0) {//porque cuando llega a 0 no juega mas
			for(int x = 0;x < 2;x++) {
				jugadorTurno.setCarta(mazo.dar());
			}
			this.notificarObservadores(Eventos.REPARTIDO);}
	}
	@Override
	public void proximoTurno() throws RemoteException {
		jugadorTurno=siguiente(jugadorTurno);
		if (jugadorTurno.yaJugoEstaMano()) {
			this.notificarObservadores(Eventos.MANO_TERMINADA);
		}else {
		jugar();}
		
	}
	@Override
	public void nuevaMano() throws RemoteException {
			//jugadorTurno=siguiente(jugadorTurno);
			for (Jugador jugador:jugadores) {
				jugador.limpiarCartas();}
			this.mazo=new Mazo();
			jugar();
		}
	private Jugador siguiente(Jugador JugadorTurno){
		Jugador retorno=null;
		for (int i = 0;i < jugadores.size();i++) {
			if (JugadorTurno==jugadores.get(i)) {
				if(jugadores.size()==i+1) {
					retorno=jugadores.get(0);
				}else {
				retorno=jugadores.get(i+1);
				}
				break;
			}
		}
		return retorno;
	}
	@Override
	public IJugador getITurno()throws RemoteException   {
		return jugadorTurno;
	}
	public void incPozo(int cant) throws RemoteException {
		pozo+=cant;
	}
	public void decPozo(int cant) throws RemoteException {
		pozo-=cant;
	}
	public int getPozo()throws RemoteException  {
		return pozo;
	}
	@Override
	public boolean puedeEmpezarJuego() throws RemoteException {
		return jugadores.size()>=2;
	}
	@Override
	public ArrayList<IJugador> listarJugadores() throws RemoteException {
			ArrayList<IJugador> listJugadores=new ArrayList<>() ;
			for (Jugador jugador:this.jugadores) {
				listJugadores.add(jugador);}
			return listJugadores;
	}
	@Override
	public void darTercerCarta() throws RemoteException {
		jugadorTurno.setCartaIntermedia(mazo.dar());
		if(jugadorTurno.isGano(pozo)) {
			pozo=0;
			notificarObservadores(Eventos.INTERMEDIO_GANADO);
		}else {
			pozo+=pozo;
			notificarObservadores(Eventos.INTERMEDIO_PERDIDO);
		}
		proximoTurno();
	}
	@Override
	public Carta getCartaIntermedio() throws RemoteException {
		return jugadorTurno.getCartaIntermedia();
	}
	@Override
	public boolean verificarNombre(String nombre) throws RemoteException {
		boolean puedeUsarEsteNombre=true;
		for (Jugador jugador:this.jugadores) {
			if(nombre.equals(jugador.getNombre())) {
				puedeUsarEsteNombre=false;
			}}
		return puedeUsarEsteNombre;
	}
	@Override
	public void introducirDinero(String nombre, int dinero) throws RemoteException {
		for (Jugador jugador:this.jugadores) {
			if(nombre.equals(jugador.getNombre())) {
				jugador.incDinero(dinero-100);
				this.incPozo(100);
			}
			this.notificarObservadores(Eventos.DINERO_INGRESADO);
	}}
	

}
