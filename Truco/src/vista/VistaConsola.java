package vista;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Carta;
import modelo.Eventos;
import controlador.Controlador;
import modelo.IJugador;
import observer.Observable;
public class VistaConsola implements IVista {
	private Controlador controlador;
	private Scanner entrada;
	public VistaConsola() {
		this.entrada = new Scanner(System.in);
	}
	public void quererNoQuerer(String nombre,Eventos evento) {
		System.out.println(nombre+": el contrario "+evento.getCantadoQuerido()+" "+evento.getEvento());
		System.out.println("Opciones");
		System.out.println("1-Quiero");
		System.out.println("2-No quiero");
		String opcion = this.entrada.nextLine();
		switch(Integer.valueOf(opcion)) {
		case 1:
			controlador.quise(evento);
			break;
		case 2:
			controlador.noQuise(evento);}
	}
	public void menuPMano() {
		String opcion="0";
		while(opcion=="0") {
		System.out.println("Opciones");
		System.out.println("1-Cantar envido");
		System.out.println("2-Cantar real envido");
		System.out.println("3-Cantar falta envido");
		System.out.println("4-Cantar truco");
		System.out.println("5-Tirar carta");
		System.out.println("6-Irme al mazo");
		opcion = this.entrada.nextLine();
		switch(Integer.valueOf(opcion)) {
		case 1:
			controlador.cantar(Eventos.ENVIDO_CANTADO);
			controlador.preguntar(Eventos.ENVIDO_CANTADO);
			break;
		case 2:
			controlador.cantar(Eventos.REALENVIDO_CANTADO);
			controlador.preguntar(Eventos.REALENVIDO_CANTADO);
			break;
		case 3:
			controlador.cantar(Eventos.FALTAENVIDO_CANTADO);
			controlador.preguntar(Eventos.FALTAENVIDO_CANTADO);
			break;
		case 4:
			controlador.cantar(Eventos.TRUCO_CANTADO);
			controlador.preguntar(Eventos.TRUCO_CANTADO);
			break;
		case 5:
			Carta cartaTirada=null;
			while (cartaTirada==null) {
			System.out.println("Ingrese numero de carta<1-3>");
			int carta =Integer.valueOf(new Scanner(System.in).nextLine()) ;
			cartaTirada=controlador.tirar(carta);
			}
			System.out.print("\033[H\033[2J");  
			System.out.flush(); 
			System.out.println("Se tiro el "+cartaTirada.toString()); 
			break;
		case 6:
			
		default:
			System.out.println("Opcion invalida");
			opcion="0";
		}}
	}
	public void iniciar() {
		System.out.println("########################");
		System.out.println("######### TRUCO ########");
		System.out.println("########################");
		System.out.println();
		System.out.println("Presione enter para empezar el juego");
		this.entrada.nextLine();
		System.out.println("Ingrese nombre de jugador 1:");
		String nameJ1 = this.entrada.nextLine();
		System.out.println("Ingrese nombre de jugador 2:");
		String nameJ2 = this.entrada.nextLine();
		controlador.agregarJugador(nameJ1);
		controlador.agregarJugador(nameJ2);
		System.out.println("Comienza tirando:"+this.controlador.getTurno().getNombre());
		System.out.println("Cartas:"+controlador.mostrarCartas());
		menuPMano();
		while (!controlador.termino()) {
			System.out.println("a");
		}
		}
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	@Override
	public void mostrarJugadores(ArrayList<IJugador> jugadores) {
		for (IJugador jugador : jugadores) {
			System.out.println("Nombre:" + jugador.getNombre());
			System.out.println("Puntos:" + jugador.getPuntos());
		}
	}
	}
