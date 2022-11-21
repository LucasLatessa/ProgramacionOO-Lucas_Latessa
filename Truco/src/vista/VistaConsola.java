package vista;
import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;
import modelo.Carta;
import modelo.EstadoEnvido;
import modelo.EstadoTruco;
import modelo.Eventos;
import modelo.IEnvido;
import modelo.IJugador;
public class VistaConsola implements IVista {
	private Controlador controlador;
	private Scanner entrada;
	public VistaConsola() {
		this.entrada = new Scanner(System.in);
	}
	private boolean valido(int min ,int op,int max) {
		return op>=min&&op<=max;
	}
	public void iniciar() {
		System.out.println("########################");
		System.out.println("######### TRUCO ########");
		System.out.println("########################");
		System.out.println();
		System.out.println("1-Agregar jugador \n2-Salir \nIngrese su opcion");
		
		int opcion = Integer.valueOf(this.entrada.nextLine());
		while(!valido(1,opcion,2)) {
			System.out.println("Opcion invalida \nIngrese su opcion");
			opcion = Integer.valueOf(this.entrada.nextLine());
		}
		switch(opcion) {
		case 1:
			System.out.println("Ingrese nombre de jugador:");
			String nameJ1 = this.entrada.nextLine();
			controlador.agregarJugador(nameJ1);
			break;
		case 2:
			System.exit(0);
			break;
		}
		}
	public void menuRondas() {
		separacionJug();
		mostrarPuntajes();
		this.mostrarCartaTirada();
		mostrarCartasEnMano();
		System.out.println("Opciones");
		System.out.println("1-Tirar carta \n2-Irme al mazo");
		EstadoTruco jugando=controlador.queSeEstaJugando();
		if (controlador.obtenerGanadorEnvido()==null&&controlador.rondaAcutual()==1&&jugando==EstadoTruco.NADA) {
			System.out.println("3-Cantar envido \n4-Cantar real envido \n5-Cantar falta envido");
		}
		if (controlador.quienCantoUltimo()!= controlador.turnoActual()) {
			switch(jugando) {
			case NADA:
				System.out.println("6-Cantar truco");
				break;
			case TRUCO:
				System.out.println("6-Cantar retruco");
				break;
			case RETRUCO:
				System.out.println("6-Cantar vale cuatro");
			}}
		System.out.println("Ingrese opcion");
		int opcion = Integer.valueOf(entrada.nextLine());
		while(!valido(1,opcion,6)) {
			System.out.println("Opcion invalida \nIngrese su opcion");
			opcion = Integer.valueOf(this.entrada.nextLine());
		}
		switch(Integer.valueOf(opcion)) {
		case 1:
			pedirCarta();
			break;
		case 2:
			controlador.alMazo();
			break;
		case 3:
		case 4:
		case 5:
			this.menuEnvido(opcion);
			break;
		case 6:
			controlador.cantar(jugando.aumentar());
		}}
	
	public void quererNoQuererEnvido(String jugador,IEnvido envido) {
		separacionJug();
		 EstadoEnvido ultCantado=envido.getEnvidoPreguntado();
		 mostrar3Cartas();
		System.out.println(jugador+": el contrario canto " +ultCantado.toString());
		System.out.println("Opciones");
		System.out.println("1-Quiero");
		System.out.println("2-No quiero");
		switch (ultCantado) {
		case ENVIDO:
			if (envido.getEnvidosQueridos().size()<=0) {
			System.out.println("3-Cantar envido");}
			System.out.println("4-Cantar real envido");
		case REALENVIDO:
			System.out.println("5-Cantar falta envido");
		}
		System.out.println("Ingrese opcion");
		int opcion = Integer.valueOf(entrada.nextLine());
		while(!valido(1,opcion,5)) {
			System.out.println("Opcion invalida \nIngrese su opcion");
			opcion = Integer.valueOf(this.entrada.nextLine());
		}
		switch(opcion) {
		case 1:
			controlador.quiero();
			mostrarPuntajes();
			break;
		case 2:
			controlador.noQuiero();
			break;
		case 3:
		case 4:
		case 5:
			menuEnvido(opcion);
			}
	}
	public void quererNoQuererTruco(String jugador,EstadoTruco truco) {
		separacionJug();
		mostrar3Cartas();
		System.out.println(jugador+": el contrario canto " +truco.toString());
		System.out.println("Opciones");
		System.out.println("1-Quiero");
		System.out.println("2-No quiero");
		if (truco==EstadoTruco.TRUCO&&controlador.obtenerGanadorEnvido()==null&&controlador.rondaAcutual()==1) {
			System.out.println("3-Cantar envido \n4-Cantar real envido \n5-Cantar falta envido");
		}
		System.out.println("Ingrese opcion");
		int opcion = Integer.valueOf(entrada.nextLine());
		while(!valido(1,opcion,5)) {
			System.out.println("Opcion invalida \nIngrese su opcion");
			opcion = Integer.valueOf(this.entrada.nextLine());
		}
		switch(Integer.valueOf(opcion)) {
		case 1:
			controlador.quiero(truco);
			break;
		case 2:
			controlador.alMazo();//da 2 puntos MAL
			break;
		case 3:
		case 4:
		case 5:
			menuEnvido(opcion);
		}
	}
	public void separacionJug() {
		insertLineas(30);
		System.out.println("("+controlador.nombreTurno()+") presiona enter");
		this.entrada.nextLine();
		
	}
	public void menuEnvido(int opcion) {
		switch(opcion) {
		case 3:
			controlador.cantar(EstadoEnvido.ENVIDO);
			break;
		case 4:
			controlador.cantar(EstadoEnvido.REALENVIDO);
			break;
		case 5:
			controlador.cantar(EstadoEnvido.FALTAENVIDO);}
	}
	public void pedirCarta() {
		Carta cartaTirada=null;
		int carta=4;
		int cantCartasJugActual=controlador.obtenerCantCartasJugActual();
		while (cantCartasJugActual<(Integer.valueOf(carta))) {
			System.out.println("Ingrese indice de carta<1-"+cantCartasJugActual+">");
			carta =Integer.valueOf(new Scanner(System.in).nextLine()) ;
		}
		controlador.tirar(carta);
		insertLineas(2);
	}
	public void insertLineas(int lineas){
	 for (int i=0; i < lineas; i++){
	  System.out.println();}
	}
	/**
	 * muestra las cartas del jugador que le toca jugar
	 */
	public void mostrarCartasEnMano() {
		String ss="Cartas en mano: ";
		int cont=1;
		System.out.println("TURNO DE "+ controlador.nombreTurno().toUpperCase());
		for (String sCarta : controlador.listarCartas()) {
			ss+="["+(cont++)+"] "+sCarta+", ";
		}
		System.out.println(ss);
	}
	public void mostrar3Cartas() {
		String ss="Todas tus cartas: ";
		int cont=1;
		System.out.println("TURNO DE "+ controlador.nombreTurno().toUpperCase());
		int i;
		for ( i=0;i<controlador.listarCartas().size(); i++) {
			String sCarta=controlador.listarCartas().get(i);
			ss+="["+(cont++)+"] "+sCarta+", ";
		}
		if (i==2) {
			ss+="["+(cont++)+"] "+controlador.turnoActual().getCartaTirada().toString();
		}
		System.out.println(ss);
	}
	/**
	 * muestra la carta tirada en caso de que haya
	 */
	public void mostrarCartaTirada() {
		if (controlador.getCartaTirada()!=null){
		System.out.println("Se tiro el "+controlador.getCartaTirada()); }
	}
	public void mostrarEnvido(String nombre) {
		Integer p1= controlador.obtenerTantosEnvido().get(0);
		Integer p2=controlador.obtenerTantosEnvido().get(1);
		this.insertLineas(20);
		System.out.println("Los tantos fueron :"+p1+", "+p2);
		System.out.println( "El ganador del tanto es:"+nombre);
		System.out.println("Presione enter");
		this.entrada.nextLine();
		
	}
	public void rondaTerminada(String nombre) {
		this.insertLineas(20);
		System.out.println("\n\nLa ronda termino \nEl ganador de la ronda "+controlador.rondaAnterior()+" es "+ nombre);
		System.out.println("Presione enter");
		this.entrada.nextLine();
	}
	public void avisarParda() {
		this.insertLineas(20);
		System.out.println("La ronda fue parda, la segunda ronda define");
		System.out.println("Presione enter");
		this.entrada.nextLine();
	}
	public void manoTerminada() {
		this.insertLineas(20);
		System.out.println("La mano termino");
		mostrarPuntajes();
		System.out.println("Presione enter para repartir la siguiente mano");
		this.entrada.nextLine();
	}
	public void juegoTerminado() {
		this.insertLineas(20);
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
	
}
