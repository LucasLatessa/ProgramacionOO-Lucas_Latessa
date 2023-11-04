package vista;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;
import modelo.IJugador;
public class VistaConsola  {
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
		System.out.println("Ingrese su opcion");
		String opcion = this.entrada.nextLine().toUpperCase();
		while(!opcion.equals("A")&&!opcion.equals("S")&&!opcion.equals("V")) {
			System.out.println("Opcion invalida \nIngrese su opcion");
			opcion = this.entrada.nextLine().toUpperCase();
		}
		switch(opcion) {
		case "A":
			System.out.println("Ingrese nombre de jugador:");
			String nameJ1 = this.entrada.nextLine();
			try {
				while(!controlador.noNombreRepetido(nameJ1)) {
					System.out.println("El nombre de usuario ya esta usado, ingrese otro");
					nameJ1 = this.entrada.nextLine();
				}
				this.controlador.agregarJugador(nameJ1);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "V":
			mostrarJugadores();
			iniciar();
			break;
		case "S":
			System.exit(0);
		}
	}

	public void preguntaEmpezar() {
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
			preguntaEmpezar();
			break;
		case "E":
			try {
				controlador.repartir();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "S":
			System.exit(0);
			break;
		}
		
		
	}
	public void mostrarJugadores() {
		ArrayList<IJugador> jugadores = null;
		try {
			jugadores = controlador.getJugadores();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			try {
				controlador.quiero();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		};}
	
	
	/**
	 * muestra las cartas del jugador que le toca jugar
	 */
	public void mostrarCartasEnMano() {
		String ss="Cartas en mano: ";
		int cont=1;
		try {
			System.out.println("TURNO DE "+ controlador.turnoActual().getNombre().toUpperCase());
			for (String sCarta : controlador.listarCartas()) {
				ss+="["+(cont++)+"] "+sCarta+", ";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(ss);
	}
	/**
	 * muestra la carta intermedia en caso de que haya
	 */
	public void mostrarCartaIntermedia() {
		try {
			if (controlador.getCartaIntermedio()!=null){
			System.out.println("Tu carta intermedia es: "+controlador.getCartaIntermedio().toString()); }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void manoTerminada() {
		System.out.println("La mano termino");
		mostrarPuntajes();
		System.out.println("Presione enter para repartir la siguiente mano");
		this.entrada.nextLine();
	}
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	public void mostrarPuntajes() {
		String ss="";
		ArrayList<IJugador> jugadores = null;
		try {
			jugadores = controlador.darJugadores();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (IJugador jugador : jugadores) {
			ss+="Puntos " + jugador.getNombre()+": "+ jugador.getDinero()+"\n";
		}
		System.out.println(ss);
	}
	public void esperandoJugadores() {
		
		System.out.println("Esperando otros jugadores...");
	}
	public void esperarJugandoOponente() {
		System.out.println("Esperando que juegue oponente...");
		
	}
	public void mostrarCartaIntermediaContras() {
		// TODO Auto-generated method stub
		
	}
	public void mostrarCartaTirada() {
		// TODO Auto-generated method stub
		
	}
}
