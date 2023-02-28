package vista;
import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;
import modelo.Carta;
import modelo.Eventos;
import modelo.IJugador;
public class VistaConsola implements IVista {
	private Controlador controlador;
	private Scanner entrada;
	public VistaConsola() {
		this.entrada = new Scanner(System.in);
	}
	public void iniciar() {
		System.out.println("########################");
		System.out.println("###### INTERMEDIO ######");
		System.out.println("########################");
		System.out.println();
		System.out.println("A- Agregar jugador \nV- Ver jugadores\nS- Salir ");
		if(controlador.puedeEmpezarJuego()) {
			System.out.println("E- Empezar");
		}
		System.out.println("Ingrese su opcion");
		String opcion = this.entrada.nextLine().toUpperCase();
		while(!opcion.equals("A")&&!opcion.equals("S")&&!opcion.equals("E")&&!opcion.equals("V")) {
			System.out.println("Opcion invalida \nIngrese su opcion");
			opcion = this.entrada.nextLine().toUpperCase();
		}
		switch(opcion) {
		case "A":
			System.out.println("Ingrese nombre de jugador:");
			String nameJ1 = this.entrada.nextLine();
			this.controlador.agregarJugador(nameJ1);
			break;
		case "V":
			mostrarJugadores();
			iniciar();
			break;
		case "E":
			controlador.empezarJuego();
			break;
		case "S":
			System.exit(0);
		}
	}
	public void noEntranMasJugadores() {
		System.out.println("########################");
		System.out.println("###### INTERMEDIO ######");
		System.out.println("########################");
		System.out.println();
		System.out.println("Selecciona una opcion:");
		System.out.println("V - Ver jugadores");
		System.out.println("E - Empezar");
		System.out.println("S - Salir");
		String opcion = this.entrada.nextLine().toUpperCase();
		while(!opcion.equals("V")&&!opcion.equals("E")&&!opcion.equals("S")) {
			System.out.println("Opcion invalida \nIngrese su opcion");
			opcion = this.entrada.nextLine().toUpperCase();
		}
		switch(opcion) {
		case "V":
			mostrarJugadores();
			noEntranMasJugadores();
			break;
		case "E":
			controlador.empezarJuego();
			break;
		case "S":
			System.exit(0);
			break;
		}
		
		
	}
	public void mostrarJugadores() {
		ArrayList<IJugador> jugadores=controlador.getJugadores();
		if (jugadores.size()!=0) {
			System.out.println("Los jugadores actuales son: ");
			for (IJugador jugador:jugadores) {
				System.out.println(jugador.getNombre());
			}
		}else {
			System.out.println("No hay jugadores agregados");
		}
		
	}

	public void jugar() {
		mostrarPuntajes();
		mostrarCartasEnMano();
		System.out.println("Opciones");
		System.out.println("D-Dame la carta intermedia \nP-Paso");
		System.out.println("Ingrese opcion");
		String opcion = entrada.nextLine().toUpperCase();
		while(!opcion.equals("D")&&!opcion.equals("P")) {
			System.out.println("Opcion invalida \nIngrese opcion nuevamente");
			opcion = entrada.nextLine().toUpperCase();
		}
		switch(opcion) {
		case"D":
			controlador.quiero();
			break;
		};}
	
	
	/**
	 * muestra las cartas del jugador que le toca jugar
	 */
	public void mostrarCartasEnMano() {
		String ss="Cartas en mano: ";
		int cont=1;
		System.out.println("TURNO DE "+ controlador.turnoActual().getNombre().toUpperCase());
		for (String sCarta : controlador.listarCartas()) {
			ss+="["+(cont++)+"] "+sCarta+", ";
		}
		System.out.println(ss);
	}@Override
	/**
	 * muestra la carta intermedia en caso de que haya
	 */
	public void mostrarCartaIntermedia() {
		if (controlador.getCartaIntermedio()!=null){
		System.out.println("Tu carta intermedia es: "+controlador.getCartaIntermedio().toString()); }
	}
	@Override
	public void manoTerminada() {
		System.out.println("La mano termino");
		mostrarPuntajes();
		System.out.println("Presione enter para repartir la siguiente mano");
		this.entrada.nextLine();
	}
	@Override
	public void juegoTerminado() {
		mostrarPuntajes();
		System.out.println("El juego termino, el ganador es "+controlador.termino().getNombre());
		System.out.println("Presione enter para salir");
		this.entrada.nextLine();
		System.exit(0);
	}
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	@Override
	public void mostrarPuntajes() {
		String ss="";
		ArrayList<IJugador> jugadores=controlador.darJugadores();
		for (IJugador jugador : jugadores) {
			ss+="Puntos " + jugador.getNombre()+": "+ jugador.getPuntos()+"\n";
		}
		System.out.println(ss);
	}
	@Override
	public void esperandoJugadores() {
		
		System.out.println("Esperando otros jugadores...");
	}
	@Override
	public void esperarJugandoOponente() {
		System.out.println("Esperando que juegue oponente...");
		
	}
}
