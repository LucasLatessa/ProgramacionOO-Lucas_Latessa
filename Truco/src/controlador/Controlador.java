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
				modelo.nuevaMano();
				modelo.newRonda();
				break;
			case JUEGO_TERMINADO:
				vista.fin();
				vista.mostrarJugadores(modelo.listarJugadores());
			default:
			break;
		}
}}
public IJugador getTurno() {
	return modelo.getTurno();
}
public String mostrarCartas() {
	String ss="("+modelo.getTurno().getNombre()+") ";
	for (Carta carta:modelo.getTurno().getCartas()) {
		ss+=carta.toString()+", ";
	}
	return ss ;
	
}
/**
 * @return devuelve false si el ganador es nulo, de haber un ganador devuelve el jugador.
 */
public IJugador termino() {
	return modelo.preguntarGanador();
}
public void cantar(Eventos evento) {
	modelo.cantado(evento);
}
public Carta tirar(int carta) {
	return modelo.getTurno().tirarCarta(carta);
	
}
public void preguntar(Eventos evento) {
	modelo.changeTurno();
	
}
}