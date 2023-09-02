package vista;
import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;
import modelo.Carta;
import modelo.IJugador;
public class VistaConsola{
	private Controlador controlador;
	private Scanner entrada;
	public VistaConsola() {
		this.entrada = new Scanner(System.in);
	}
//	private boolean valido(int min ,int op,int max) {
//		return op>=min&&op<=max;
//	}
	public void iniciar() {
		System.out.println("########################");
		System.out.println("######### RAYA #########");
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
			while(!controlador.verificarNombre(nameJ1)) {
				System.out.println("El nombre de usuario ya esta usado, ingrese otro");
				nameJ1 = this.entrada.nextLine();
			}
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
			System.out.println("######### RAYA #########");
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
	public void jugar() {
		System.out.println("TURNO DE "+ controlador.nombreTurno().toUpperCase());
		mostrarPuntajes();
		mostrarcartasTodos();
		//mostrarCartasEnMano();
		System.out.println("Opciones");
		System.out.println("1-Quiero otra carta \n2-Me planto");
		System.out.println("Ingrese opcion");
		String opcion = entrada.nextLine().toUpperCase();
		while(!opcion.equals("1")&&!opcion.equals("2")) {
			System.out.println("Opcion invalida \nIngrese opcion nuevamente");
			opcion = entrada.nextLine().toUpperCase();
		}
		switch(opcion) {
		case"1":
			controlador.quiero();
			break;
		case"2":
			controlador.noQuiero();
			break;
		}
		}
	
	
	public void mostrarcartasTodos(){
		ArrayList<IJugador> jug=controlador.darJugadores();
		
		for (IJugador jugador : jug) {
			String ss="Cartas de "+jugador.getNombre()+": ";
			ArrayList<Carta> cartas =jugador.getCartas();
			for (int i=0;i<cartas.size();i++) {
				ss+=cartas.get(i).toString();
			if (i!=jugador.getCartas().size()-1) {
				ss+=", ";
			}}
			System.out.println(ss);
	}}
	public void manoTerminada() {
		System.out.println("La mano termino");
		mostrarPuntajes();
		
	}
	public void juegoTerminado() {
		mostrarPuntajes();
		System.out.println("El juego termino, el ganador es "+controlador.termino().getNombre());
		System.out.println("Presione enter para salir");
		this.entrada.nextLine();
		System.exit(0);
	}
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	public void mostrarPuntajes() {
		String ss="";
		ArrayList<IJugador> jugadores=controlador.darJugadores();
		for (IJugador jugador : jugadores) {
			ss+="Puntos " + jugador.getNombre()+": "+ jugador.getPuntos()+"\n";
		}
		System.out.println(ss);
	}
	public void mostrarJugadores() {
		ArrayList<IJugador> jugadores=controlador.darJugadores();
		if (jugadores.size()!=0) {
			System.out.println("Los jugadores actuales son: ");
			for (IJugador jugador:jugadores) {
				System.out.println(jugador.getNombre());
			}
		}else {
			System.out.println("No hay jugadores agregados");
		}
	}
	public void mostrarRaya() {
			mostrarcartasTodos(); 
			System.out.println(controlador.nombreTurno()+" TE SALIO UNA RAYA :( espera a la siguiente ronda");}
	public void mostrarRepartir() {
		System.out.println(controlador.nombreTurno().toUpperCase()+" presione enter para repartir la siguiente mano");
		this.entrada.nextLine();
		controlador.empezarJuego();
	}
}
