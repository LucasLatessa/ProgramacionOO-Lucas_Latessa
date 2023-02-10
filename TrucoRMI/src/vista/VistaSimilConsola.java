package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import controlador.Controlador;
import modelo.EstadoEnvido;
import modelo.EstadoTruco;
import modelo.IEnvido;
import modelo.IJugador;
import serializacion.AdministradorDeGanadores;
import serializacion.Serializador;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VistaSimilConsola extends JFrame implements IVista{
	private JTextField entrada;
	private JButton btnOpcionInicio;
	private static Serializador serializador=new Serializador("src/datos.dat");
	private Controlador controlador;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private String opcion;
	private JButton btnAddJugador;
	private JButton btnTirarCarta;
	private JButton btnOpcionEnJuego;
	private EstadoTruco truco;
	private ArrayList<String> listaOp;
	public VistaSimilConsola() {
		setVisible(true);
		setTitle("Truco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 390);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		textArea = new JTextArea();
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		textArea.setAutoscrolls(true);
		textArea.setEditable(false);
		scrollPane.setAutoscrolls(true);
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		entrada = new JTextField();
		panel_1.add(entrada);
		entrada.setColumns(10);
		
		btnOpcionInicio = new JButton("Leer opcion");
		
		btnOpcionInicio.setHorizontalAlignment(SwingConstants.LEADING);
		panel_1.add(btnOpcionInicio);
		
		btnAddJugador = new JButton("Agregar jugador");
		panel_1.add(btnAddJugador);
		SwingUtilities.getRootPane(btnOpcionInicio).setDefaultButton(btnOpcionInicio);
		
		btnTirarCarta = new JButton("Tirar Carta");
		panel_1.add(btnTirarCarta);
		
		btnOpcionEnJuego = new JButton("Leer opcion");
		btnOpcionEnJuego.setHorizontalAlignment(SwingConstants.LEADING);
		panel_1.add(btnOpcionEnJuego);
		listaOp=new ArrayList<String>();
		 listaOp.add("QT");listaOp.add("NT");listaOp.add("QE");
		 listaOp.add("NE");listaOp.add("E");listaOp.add("F");
		 listaOp.add("C");listaOp.add("M");listaOp.add("R");
		 listaOp.add("T");listaOp.add("V");
		btnOpcionInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcion = entrada.getText();
				entrada.setText(null);
				if(!valido(1,Integer.valueOf(opcion),3)) {
					textArea.setText("Opcion invalida \nIngrese su opcion");}
				else {
				switch(Integer.valueOf(opcion)) {
				case 1:
					textArea.append("\nIngrese nombre de jugador");
					btnOpcionInicio.setVisible(false);
					btnAddJugador.setVisible(true);
					SwingUtilities.getRootPane(btnAddJugador).setDefaultButton(btnAddJugador);
					break;
				case 2:
					verRanking();
					break;
				case 3:
					System.exit(0);
					break;}
					}}});
		btnAddJugador.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String nameJ1 = entrada.getText();
			entrada.setText(null);
			try {
				if(controlador.noNombreRepetido(nameJ1)) {
					textArea.setText(null);
					controlador.agregarJugador(nameJ1);
					}
					else {
						textArea.append("\nEl nombre de usuario ya esta usado, ingrese otro");
					}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}});
		btnOpcionEnJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 opcion = entrada.getText().toUpperCase();
				 textArea.append("\n"+entrada.getText());
				 boolean valido=false;
				 int cont=0;
				 while ((valido==false)&&(listaOp.size()>cont)) {
					 if(opcion.equals( listaOp.get(cont))){
						 valido=true;
					 }cont++;
				 }
				 entrada.setText(null);
					if(!valido) {
							textArea.append("\nOpcion invalida \nIngrese opcion nuevamente");
						}else {
							switch(opcion){
							case "QT":
								controlador.quiero(truco);
								break;
							case "NT":
								controlador.alMazo();
								break;
							case "QE":
								controlador.quiero();
								break;
							case "NE":
								controlador.noQuiero();
								break;
							case "E":
								controlador.cantar(EstadoEnvido.ENVIDO);
								break;
							case "F":
								controlador.cantar(EstadoEnvido.FALTAENVIDO);
								break;
							case "C":
								pedirCarta();
								break;
							case "M":
								controlador.alMazo();
								break;
							case "R":
								if (controlador.queTrucoPuedeCantar().equals("Re truco")) {
									controlador.cantar(EstadoTruco.RETRUCO);
								}else {
									controlador.cantar(EstadoEnvido.REALENVIDO);
								}
								break;
							case "T":
								controlador.cantar(EstadoTruco.TRUCO);
								break;
							case "V":
								controlador.cantar(EstadoTruco.VALECUATRO);}}
	}});
		btnTirarCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantCartasJugActual=controlador.obtenerCantCartasJugActual();
				int carta =Integer.valueOf( entrada.getText());
				textArea.append("\n"+carta);
				entrada.setText(null);
				if (cantCartasJugActual<(Integer.valueOf(carta))) {
					textArea.append("\nOpcion invalida \nIngrese indice de carta<1-"+cantCartasJugActual+">");
				}else {
				controlador.tirar(carta);}
			}});}
	private boolean valido(int min ,int op,int max) {
		return op>=min&&op<=max;
	}
	public void iniciar() {
		textArea.append("\n########################\n######### TRUCO ########\n########################\n"
				+ "1-Agregar jugador \n2-Ver ranking \n3-Salir \nIngrese su opcion");
		btnOpcionInicio.setVisible(true);
		btnAddJugador.setVisible(false);
		btnOpcionEnJuego.setVisible(false);
		btnTirarCarta.setVisible(false);
	}
	private void verRanking() {
		AdministradorDeGanadores lista=(AdministradorDeGanadores) serializador.readFirstObject();
		 ArrayList<String> nombres=lista.getNombresGanadores();
		 ArrayList<Integer> cant=lista.getCantGanadas();
		 textArea.append("\nRANKING:");
		 String ss=("Nombre"+"    "+"Partidas ganadas");
		for(int x=0;x<nombres.size();x++) {
			ss+=("\n"+nombres.get(x)+"        "+cant.get(x));
		}
		textArea.append("\n"+ss);
		
		iniciar();
	}

	public void jugar() {
			mostrarPuntajes();
			this.mostrarCartaTirada();
			mostrarCartasEnMano();
			textArea.append("\nOpciones\nC-Tirar carta \nM-Irme al mazo");
			String canto=controlador.queTrucoPuedeCantar();
			try {
				if (controlador.puedeCantarEnvidos()) {
					textArea.append("\nE-Cantar envido \nR-Cantar real envido \nF-Cantar falta envido");
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (controlador.quienCantoUltimo()!= controlador.turnoActual()) {
				switch(canto) {
				case "Truco":
					textArea.append("\nT-Cantar truco");
					break;
				case "Re truco":
					textArea.append("\nR-Cantar retruco");
					break;
				case "Vale cuatro":
					textArea.append("\nV-Cantar vale cuatro");
				}}
			textArea.append("\nIngrese opcion");
			btnOpcionInicio.setVisible(false);
			btnAddJugador.setVisible(false);
			btnTirarCarta.setVisible(false);
			SwingUtilities.getRootPane(btnOpcionEnJuego).setDefaultButton(btnOpcionEnJuego);
			btnOpcionEnJuego.setVisible(true);
			
			}
	public void pedirCarta() {
		int cantCartasJugActual=controlador.obtenerCantCartasJugActual();
	SwingUtilities.getRootPane(btnAddJugador).setDefaultButton(btnAddJugador);
	textArea.append("\nIngrese indice de carta<1-"+cantCartasJugActual+">");
	btnOpcionInicio.setVisible(false);
	btnAddJugador.setVisible(false);
	btnOpcionEnJuego.setVisible(false);
	SwingUtilities.getRootPane(btnTirarCarta).setDefaultButton(btnTirarCarta);
	btnTirarCarta.setVisible(true);
	
	
}
	
	public void quererNoQuererEnvido(String jugador,IEnvido envido) {
		mostrarCartasEnMano();
		EstadoEnvido ultCantado=envido.getEnvidoPreguntado();
		textArea.append("\n"+jugador+": el contrario canto " +ultCantado.toString());
		textArea.append("\nOpciones");
		textArea.append("\nQE-Quiero");
		textArea.append("\nNE-No quiero");
		for(String canto :envido.puedeCantar()) {
			textArea.append("\n"+canto.substring(0,1).toUpperCase()+"-Cantar "+canto);
		}
		textArea.append("\nIngrese opcion");
		btnOpcionInicio.setVisible(false);
		btnAddJugador.setVisible(false);
		btnTirarCarta.setVisible(false);
		SwingUtilities.getRootPane(btnOpcionEnJuego).setDefaultButton(btnOpcionEnJuego);
		btnOpcionEnJuego.setVisible(true);
	}
	
	public void quererNoQuererTruco(String jugador,EstadoTruco truco) {
	mostrarCartasEnMano();
	textArea.append("\n"+jugador+": el contrario canto " +truco.toString());
	textArea.append("\nOpciones");
	textArea.append("\nQT-Quiero");
	textArea.append("\nNT-No quiero");
	boolean puedeCantarEnvidos = false;
	this.truco=truco;
	try {
		puedeCantarEnvidos = controlador.puedeCantarEnvidos();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (puedeCantarEnvidos) {
		textArea.append("\nE-Cantar envido \nR-Cantar real envido \nF-Cantar falta envido");
	}
	textArea.append("\nIngrese opcion");
	btnOpcionInicio.setVisible(false);
	btnAddJugador.setVisible(false);
	btnTirarCarta.setVisible(false);
	SwingUtilities.getRootPane(btnOpcionEnJuego).setDefaultButton(btnOpcionEnJuego);
	btnOpcionEnJuego.setVisible(true);
}


	@Override
	public void mostrarEnvido(String nombre) {
		Integer p1= controlador.obtenerTantosEnvido().get(0);
		Integer p2=controlador.obtenerTantosEnvido().get(1);
		textArea.append("\nLos tantos fueron :"+p1+", "+p2);
		textArea.append("\nEl ganador del tanto es "+nombre+"\n");

		
	}
	@Override
	public void rondaTerminada(boolean ganador) {
		String mostrar="";
		ArrayList<String> cartas=controlador.obtenerCartasRonda();
		for(int i=0;i<cartas.size();i++) {
			mostrar+=cartas.get(i);
			mostrar+=cartas.size()-1!=i?", ":"";
			}
		textArea.append("\n\nLa ronda termino "
				+"\nCartas de la ronda:"+mostrar
				+ "\nEl ganador de la ronda "+controlador.rondaActual()+" es "+ controlador.obtenerGanadorDeRonda());

	}
	@Override
	public void avisarParda() {
		textArea.append("\nLa ronda fue parda, la segunda ronda define");
	}
	@Override
	public void manoTerminada() {
		textArea.append("\nLa mano termino");
		mostrarPuntajes();
	}
	@Override
	public void juegoTerminado() {
		mostrarPuntajes();
		textArea.append("\nEl juego termino, el ganador es "+controlador.termino().getNombre());
	}
	@Override
	public void mostrarPuntajes() {
		String ss="";
		ArrayList<IJugador> jugadores=controlador.darJugadores();
		for (IJugador jugador : jugadores) {
			ss+="Puntos " + jugador.getNombre()+": "+ jugador.getPuntos()+"\n";
		}
		textArea.append("\n"+ss);
	}
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}

	@Override
	public void esperandoJugadores() {
		textArea.append("\nEsperando otros jugadores...");
		btnOpcionInicio.setVisible(false);
		btnAddJugador.setVisible(false);
		btnTirarCarta.setVisible(false);
		btnOpcionEnJuego.setVisible(false);
	}
	/**
	 * muestra las cartas del jugador que le toca jugar
	 */
	public void mostrarCartasEnMano() {
		String ss="Cartas en mano: ";
		int cont=1;
		textArea.append("\nTURNO DE "+ controlador.nombreTurno().toUpperCase());
		for (String sCarta : controlador.listarCartas()) {
			ss+="["+(cont++)+"] "+sCarta+", ";
		}
		textArea.append("\n"+ss);}
	@Override
	public void esperarJugandoOponente() {
		this.textArea.append("\nEsperando que juegue oponente...");
		btnOpcionInicio.setVisible(false);
		btnAddJugador.setVisible(false);
		btnTirarCarta.setVisible(false);
		btnOpcionEnJuego.setVisible(false);
	}
	public void mostrarCartaTirada() {
	try {
		if (controlador.getCartaTirada()!=null&&!controlador.rondaTerminada()){
			this.textArea.append("\nSe tiro el "+controlador.getCartaTirada()); }
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	@Override
	public void serializar(String ganador) {
		if (serializador!=null) {
		AdministradorDeGanadores lista=(AdministradorDeGanadores) serializador.readFirstObject();
		lista.addGanador(ganador);
		serializador.writeOneObject(lista);
		serializador=null;}
	}

}
