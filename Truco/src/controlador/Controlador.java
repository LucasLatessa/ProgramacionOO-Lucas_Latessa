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
				this.vista.mostrarJugadores(jugadores);
				break;
			default:
			break;
		}
}}
public String newjuego() {
	return this.modelo.nuevaRonda().getNombre();
	
}
public String mostrarJugadores() {
	String ss="";
	for (IJugador jugador: modelo.listarJugadores()) {
		ss+=jugador.getNombre()+", ";
	}
	return ss;
}
public String mostrarCartas() {
	return (modelo.getTurno().getNombre()+": "+ modelo.getTurno().getCartas());
	
}
public void cantar(Eventos evento) {
	
}
public Carta tirar(int carta) {
	return modelo.getTurno().tirarCarta(carta);
	
}
public String preguntar(Eventos evento) {
	modelo.changeTurno();
	return modelo.getTurno().getNombre()+": el contrario "+evento.getCantadoQuerido()+" "+evento.getEvento();
	
}
}