package modelo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.observer.ObservableRemoto;
import serializacion.AdministradorDeDineros;
import serializacion.Serializador;
public class Juego extends ObservableRemoto implements  IJuego,Serializable{
	private static final String rutaSerializ="src/datos.dat";
	private static Serializador serializador=new Serializador(rutaSerializ);
	private Jugador jugadorTurno;
	private Mazo mazo;
	private ArrayList<Jugador>jugadores;
	private int pozo=0;
	private static final int pozoInicial = 100;
	public Juego(){
		this.jugadores = new ArrayList<>();
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
			jugadorTurno=siguiente(jugadorTurno);
			for (Jugador jugador:jugadores) {
				jugador.limpiarCartas();}
			this.mazo=new Mazo();
			this.notificarObservadores(Eventos.LIMPIAR_CARTAS);
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
			serializar(jugadorTurno.getNombre(),pozo);//si gano incrementamos el saldo en historial
			notificarObservadores(Eventos.INTERMEDIO_GANADO);
		}else {
			pozo+=pozo;
			serializar(jugadorTurno.getNombre(),-pozo);//si perdio derementamos el saldo en historial
			notificarObservadores(Eventos.INTERMEDIO_PERDIDO);
			proximoTurno();
		}
		
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
	/**
	 *Ingresa dinero en el usuario sin decrementarle la cuota de ingreso
	 */
	@Override
	public void ingresarDineroSinDec(String nombre, int dinero) throws RemoteException {
		serializar(nombre,-dinero);//porque debe esa cantidad
		for (Jugador jugador:this.jugadores) {
			if(nombre.equals(jugador.getNombre())) {
				jugador.incDinero(dinero);
			}}
		this.notificarObservadores(Eventos.DINERO_INGRESADO);}
	/**
	 *Ingresa dinero y resta la cuota de ingreso(pozoInicial)
	 *TIENE QUE DECREMENTAR CADA VEZ QUE ALGUIEN SE UNE A LA SESION o el pozo se queda en 0
	 */
	@Override
	public void introducirDineroYInizPozo(String nombre, int dinero) throws RemoteException {
		serializar(nombre,-dinero);//porque debe esa cantidad
		for (Jugador jugador:this.jugadores) {
			if(nombre.equals(jugador.getNombre())) {
				jugador.incDinero(dinero);
				jugador.decDinero(pozoInicial);
				pozo+=pozoInicial;
			}}
		this.notificarObservadores(Eventos.DINERO_INGRESADO);}
	@Override
	public void retirarse(String nombre)  throws RemoteException{
		Jugador aEliminar=null;
		for (Jugador jugador:this.jugadores) {
			if(nombre.equals(jugador.getNombre())) {
				serializar(nombre,jugador.getDinero());
				aEliminar=jugador;
			}}
		jugadores.remove(aEliminar);
		
	}
	@Override
	public void serializar(String nombre,int dinero)throws RemoteException {
		AdministradorDeDineros lista=null;
		File archivo = new File(rutaSerializ);
		if (!(archivo.exists())) {
			try {
				archivo.createNewFile();//crea el archivo
			} catch (IOException e) {
				e.printStackTrace();
			}
			lista= new AdministradorDeDineros();//para primera serializacion del archivo
		} else {
			lista=(AdministradorDeDineros) serializador.readFirstObject();
			}
		lista.addJugador(nombre,dinero);
		serializador.writeOneObject(lista);
	}
	@Override
	public AdministradorDeDineros traerHistorial() throws RemoteException {
		File archivo = new File(rutaSerializ);
		if (!(archivo.exists())) {
			return null;
		}else {
			return (AdministradorDeDineros) serializador.readFirstObject();
		}
		
	}
	
}
