package vista;
import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;
import modelo.Carta;
import modelo.EstadoEnvido;
import modelo.Eventos;
import modelo.IJugador;
public class VistaConsola implements IVista {
	private Controlador controlador;
	private Scanner entrada;
	public VistaConsola() {
		this.entrada = new Scanner(System.in);
	}
	public void quererNoQuererEnvido(String nombre,EstadoEnvido estado) {
		System.out.println(nombre+": el contrario canto " +estado.toString());
		System.out.println("Opciones");
		System.out.println("1-Quiero");
		System.out.println("2-No quiero");
		String opcion = this.entrada.nextLine();
		switch(Integer.valueOf(opcion)) {
		case 1:
			//controlador.quiero(evento);
			break;
		case 2:
			//controlador.noQuiero(evento);
			}
			
	}
	public void menuSTRonda() {
		String opcion="0";
		while(opcion=="0") {
		System.out.println("Opciones");
		//Eventos jugando=controlador.queSeEstaJugando();
		//switch(jugando) {
		//case null:
		//	System.out.println("4-Cantar retruco");
		}
		System.out.println("5-Tirar carta");
		System.out.println("6-Irme al mazo");
	//}
}
	public void menuPRonda() {
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
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			Carta cartaTirada=null;
			while (cartaTirada==null) {
			System.out.println("Ingrese numero de carta<1-3>");
			int carta =Integer.valueOf(new Scanner(System.in).nextLine()) ;
			cartaTirada=controlador.tirar(carta);
			}
			insertLineas(25);
			System.out.println("Se tiro el "+cartaTirada.toString()); 
			break;
		case 6:
			
		default:
			System.out.println("Opcion invalida");
			opcion="0";
		}}
	}
	public void fin() {
		System.out.println("El juego termino, el ganador es"+controlador.termino().getNombre());
		System.out.println("Presione enter para salir");
		this.entrada.nextLine();
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
		while (controlador.termino()==null) {
			System.out.println("Cartas:"+controlador.mostrarCartas());
			menuPRonda();
			menuSTRonda();
		}
		
		}
	public void insertLineas(int lineas)
	{
	 for (int i=0; i < lineas; i++)
	 {
	  System.out.println();
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
