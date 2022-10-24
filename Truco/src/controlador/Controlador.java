package controlador;

import java.util.ArrayList;

import modelo.Eventos;
import modelo.IJugador;
import modelo.Juego;
import modelo.Carta;
import observer.Observable;
import observer.Observador;
import vista.VistaConsola;

public class Controlador implements Observador{
	private Juego modelo;
	private VistaConsola vista;

public Controlador(Juego modelo, VistaConsola vista) {
	this.modelo = modelo;
	this.vista = vista;
	this.vista.setControlador(this);
	this.modelo.agregarObservador(this);
}
public void agregarJugador(String jugador) {
	modelo.agregarJugador(jugador);
}
@Override
public void actualizar(Object evento, Observable observado) {
	if(evento instanceof Eventos) {
		switch((Eventos) evento) {
			case JUEGO_INICIADO:
				ArrayList<IJugador> jugadores = this.modelo.listarJugadores();
				modelo.nuevaRonda();
				this.vista.mostrarJugadores(jugadores);
				break;
			case ENVIDO_CANTADO:
				preguntar((Eventos)evento);
			case REALENVIDO_CANTADO:
				preguntar((Eventos)evento);
			case FALTAENVIDO_CANTADO:
				preguntar((Eventos)evento);
			case TRUCO_CANTADO:
				preguntar((Eventos)evento);
			case JUEGO_TERMINADO:
				preguntar((Eventos)evento);
			default:
			break;
		}
}}
public IJugador getTurno() {
	return modelo.getTurno();
}
public String mostrarCartas() {
	String ss=modelo.getTurno().getNombre()+": ";
	for (Carta carta:modelo.getTurno().getCartas()) {
		ss+=carta.toString()+", ";
	}
	return ss ;
	
}
/**
 * @return devuelve false si el ganador es nulo, de haber un ganador devuelve true.
 */
public boolean termino() {
	return modelo.preguntarGanador()==null?false:true;
}
public void cantar(Eventos evento) {
	modelo.cantado(evento);
}
public Carta tirar(int carta) {
	return modelo.getTurno().tirarCarta(carta);
	
}
public void preguntar(Eventos evento) {
	modelo.changeTurno();
	this.vista.quererNoQuerer(modelo.getTurno().getNombre(), (Eventos)evento); 
	
}
public void respuesta(Eventos evento, String string) {
	if (string=="si"){
		switch (evento){
		case ENVIDO_QUERIDO:
			modelo.agregarEvento(evento);
			}
	}
}
public Eventos queSeEstaJugando() {
	return modelo.getEventos().get(modelo.getEventos().size());
}
}