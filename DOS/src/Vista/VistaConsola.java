package Vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controlador.Controlador;
import Modelo.Carta;
import Modelo.Ijugador;


public class VistaConsola implements Ivista{

	private Scanner entrada;
	private Controlador controlador;
	
	public VistaConsola() {
		this.entrada = new Scanner(System.in);
	}
	
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}
	
	public void mostrarMenuPrincipal() {
		System.out.println("########################");
		System.out.println("####### JUEGO DOS #######");
		System.out.println("########################");
		System.out.println();
		System.out.println("Selecciona una opcion:");
		System.out.println("1 - Agregar jugador");
		System.out.println("2 - Ver jugadores");
		System.out.println();
		System.out.println("99 - Salir");
	}
	
	@Override
	public void iniciar() {
		boolean salir = false;
		while(!salir ) {
			this.mostrarMenuPrincipal();
			String opcion = this.entrada.nextLine();
			switch (opcion) {
				case "1":
//					System.out.println("Ingrese el nombre del nuevo jugador");
//					String nombre = this.entrada.nextLine();
//					this.controlador.agregarJugador(nombre);
					this.agregarJugadorCast();
					break;
				case "2":
					this.controlador.verJugadores();
					break;
				case "99":
					salir = true;
					System.out.println("Recuerde volver!");
					break;
				default:
					System.out.println("Opcion no valida.");
			}
		}
	}
	public void mostrarMenuEmpezar() {
		System.out.println("########################");
		System.out.println("####### JUEGO DOS #######");
		System.out.println("########################");
		System.out.println();
		System.out.println("Selecciona una opcion:");
		System.out.println("1 - Agregar jugador");
		System.out.println("2 - Ver jugadores");
		System.out.println("3 - Empezar");
		System.out.println();
		System.out.println("99 - Salir");
		
	}
	public void empezar() {
		boolean salir=false;
		this.mostrarMenuEmpezar();
		String opcion = this.entrada.nextLine();
		while (!salir) {
		switch (opcion) {
				case "1":
					System.out.println("Ingrese el nombre del nuevo jugador");
					String nombre = this.entrada.nextLine();
					this.controlador.agregarJugador(nombre);
					break;
				case "2":
					this.controlador.verJugadores();
					break;
				case "3":
					this.controlador.iniciarJuego();
					break;
				case "99":
					salir=true;
					System.out.println("Recuerde volver!");
					break;
				default:
					System.out.println("Opcion no valida.");
			}
		}
	}
	
	
	
	public void iniciarJuego() {
		String opcion = this.entrada.nextLine();
		switch (opcion) {
			case "1":
				System.out.println("Ingrese la posicion de la carta que quiere jugar");
				String posCartaJugada = this.entrada.nextLine();
				System.out.println("Ingrese la posicion de la carta en mesa con la que quiere jugar");
				String posCartaEnMesa = this.entrada.nextLine();
				this.controlador.jugarSimple(posCartaJugada,posCartaEnMesa);
				break;
			case "2":
				this.controlador.verJugadores();
				break;
			case "99":
				this.controlador.robarCartaJugadorActual();
				break;
			default:
				System.out.println("Opcion no valida.");
		}
}
	
	

	public void mostrarJugadores(List<Ijugador> jugadores) {
		System.out.println("Los jugadores actuales son: ");
		for (Ijugador jugador:jugadores) {
			System.out.println(jugador.getId());
		}
	}

	public void mostrarCartaJugadorActual(Ijugador jugadorActual) {
		System.out.println("Es el turno de: "+ jugadorActual.getId());
		System.out.println("Sus cartas son: ");
		int i=0;
		for (Carta carta: jugadorActual.getCartas()) {
			i++;
			System.out.print(i+".    "+carta.toString()+",");
		}
		
	}

	public void mostrarCartasEnMesa(ArrayList<Carta> cartasEnMesa) {
		System.out.println("Las cartas en mesa son:");
		int i =0;
		for (Carta carta: cartasEnMesa) {
			i++;
			System.out.print(i+".    "+carta.toString()+",");
		}
		
	}
	public void mostrarMenuJuego() {
		System.out.println("Desea jugar un juego simple o doble?");
		System.out.println("1 - Simple");
		System.out.println("2 - Doble");
		System.out.println();
		System.out.println("99 - RobarCarta");
	}
	


	public void mostrarCartasDespuesDeJugar(Ijugador jugadorActual) {
		System.out.println("Jugador: "+ jugadorActual.getId() );
		System.out.println("Sus cartas son: ");
		int i=0;
		for (Carta carta: jugadorActual.getCartas()) {
			i++;
			System.out.print(i+".    "+carta.toString()+",");
		}
		
	}



	public void terminado() {
		System.out.println("####################El juego termino##################");
		Ijugador ganador=this.controlador.obtenerGanador();
		System.out.println("El ganador fue: "+ ganador.getId());
	}
	
	
	
	public void agregarJugadorCast() {
		this.controlador.agregarJugador("Lucas");
		this.controlador.agregarJugador("Magali");
	}
}


