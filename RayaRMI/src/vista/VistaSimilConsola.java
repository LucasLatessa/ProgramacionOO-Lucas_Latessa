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
import modelo.Carta;
import modelo.IJugador;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VistaSimilConsola extends JFrame implements IVista{
	private static final long serialVersionUID = 1L;
	private JTextField entrada;
	private JButton btnOpcionInicio;
	private Controlador controlador;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private String opcion;
	private JButton btnAddJugador;
	private JButton btnOpcionEnJuego;
	public VistaSimilConsola() {
		setVisible(true);
		setTitle("Raya");
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
		
		btnOpcionEnJuego = new JButton("Leer opcion");
		btnOpcionEnJuego.setHorizontalAlignment(SwingConstants.LEADING);
		panel_1.add(btnOpcionEnJuego);
		btnOpcionEnJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 opcion = entrada.getText().toUpperCase();
				 textArea.append("\n"+entrada.getText());
				 boolean valido=opcion.equals("1")||opcion.equals("2")||opcion.equals("R");
				 entrada.setText(null);
					if(!valido) {
							textArea.append("\nOpcion invalida \nIngrese opcion nuevamente");
						}else {
							switch(opcion) {
							case"1":
								try {
									controlador.quiero();
								} catch (RemoteException e1) {
									e1.printStackTrace();
								}
								break;
							case"2":
								try {
									controlador.noQuiero();
								} catch (RemoteException e1) {
									e1.printStackTrace();
								}
								break;
							case"R":
								try {
									controlador.empezarJuego();
								} catch (RemoteException e1) {
									e1.printStackTrace();
								}
								break;
							}}
	}});
		btnAddJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameJ1 = entrada.getText();
				entrada.setText(null);
				textArea.append("\n"+nameJ1);
				try {
					if(controlador.verificarNombre(nameJ1)) {
						textArea.setText(null);
						controlador.agregarJugador(nameJ1);
						}
						else {
							textArea.append("\nEl nombre de usuario ya esta usado, ingrese otro");
						}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}});
		btnOpcionInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcion = entrada.getText().toUpperCase();
				textArea.append("\n"+opcion);
				entrada.setText(null);
				if(!opcion.equals("A")&&!opcion.equals("S")&&!opcion.equals("E")&&!opcion.equals("V")) {
					textArea.setText("Opcion invalida \nIngrese su opcion");}
				else {
				switch(opcion) {
				case "A":
					textArea.append("\nIngrese nombre de jugador");
					btnOpcionInicio.setVisible(false);
					btnAddJugador.setVisible(true);
					SwingUtilities.getRootPane(btnAddJugador).setDefaultButton(btnAddJugador);
					break;
				case "V":
					mostrarJugadores();
					iniciar();
					break;
				case "E":
					try {
						controlador.empezarJuego();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					break;
				case "S":
					System.exit(0);}
					}}});
	}
	@Override
	public void iniciar() {
		textArea.append("\n########################\n######### RAYA ########\n########################\n"
				+ "\nA- Agregar jugador  \nV- Ver jugadores \nS- Salir  \nIngrese su opcion");
		try {
			if(controlador.puedeEmpezarJuego()) {
				textArea.append("\nE- Empezar");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnOpcionInicio.setVisible(true);
		btnAddJugador.setVisible(false);
		btnOpcionEnJuego.setVisible(false);
	}
		public void mostrarJugadores() {
		ArrayList<IJugador> jugadores = null;
		try {
			jugadores = controlador.darJugadores();
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
		if (jugadores.size()!=0) {
			textArea.append("\nLos jugadores actuales son: ");
			for (IJugador jugador:jugadores) {
				textArea.append(jugador.getNombre());
			}
		}else {
			textArea.append("No hay jugadores agregados");
		}}
	
	
//
//	@Override
//	public void serializar(String ganador) {
//		if (serializador!=null) {
//		AdministradorDeGanadores lista=(AdministradorDeGanadores) serializador.readFirstObject();
//		lista.addGanador(ganador);
//		serializador.writeOneObject(lista);
//		serializador=null;}
//	}


	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}
	@Override
	public void jugar() {
		try {
			textArea.append("\nTURNO DE "+ controlador.nombreTurno().toUpperCase());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
			mostrarPuntajes();
			mostrarCartasTodos();
			//mostrarCartasEnMano();
			textArea.append("\nOpciones");
			textArea.append("\n1-Quiero otra carta \n2-Me planto");
			textArea.append("\nIngrese opcion");
			btnOpcionInicio.setVisible(false);
			btnAddJugador.setVisible(false);
			btnOpcionEnJuego.setVisible(true);
			}
	@Override
		public void mostrarPuntajes() {
			String ss="";
			ArrayList<IJugador> jugadores = null;
			try {
				jugadores = controlador.darJugadores();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			for (IJugador jugador : jugadores) {
				ss+="\nPuntos " + jugador.getNombre()+": "+ jugador.getPuntos();
			}
			textArea.append(ss);
		}
	@Override
	public void juegoTerminado() {
		mostrarPuntajes();
		try {
			textArea.append("\nEl juego termino, el ganador es "+controlador.termino().getNombre());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void esperandoJugadores() {
		textArea.append("\nEsperando otros jugadores...");
		btnOpcionInicio.setVisible(false);
		btnAddJugador.setVisible(false);
		btnOpcionEnJuego.setVisible(false);
	}
	@Override
	public void mostrarCartasTodos(){
		ArrayList<IJugador> jug = null;
		try {
			jug = controlador.darJugadores();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		for (IJugador jugador : jug) {
			String ss="\nCartas de "+jugador.getNombre()+": ";
			ArrayList<Carta> cartas =jugador.getCartas();
			for (int i=0;i<cartas.size();i++) {
				ss+=cartas.get(i).toString();
			if (i!=jugador.getCartas().size()-1) {
				ss+=", ";
			}}
			textArea.append(ss);
	}}
	@Override
	public void esperarJugandoOponente() {
		this.mostrarPuntajes();
		mostrarCartasTodos();
		textArea.append("\n Esperando que juegue oponente...");
		btnOpcionInicio.setVisible(false);
		btnAddJugador.setVisible(false);
		btnOpcionEnJuego.setVisible(false);
	}
	@Override
	public void mostrarRepartir() {
		try {
			textArea.append("\n"+controlador.nombreTurno().toUpperCase()+" R-Repartir");
		} catch (RemoteException e) {
			e.printStackTrace();
		}	}
	@Override
	public void noEntranMasJugadores() {
			textArea.append("\n########################\n######### RAYA ########\n########################\n"
					+ "V-Ver jugadores \nE-Empezar \nS-Salir \nIngrese su opcion");
			btnOpcionInicio.setVisible(true);
			btnAddJugador.setVisible(false);
			btnOpcionEnJuego.setVisible(false);
		}
	@Override
	public void mostrarRaya() {
		mostrarCartasTodos(); 
		try {
			textArea.append("\n"+controlador.nombreTurno()+" TE SALIO UNA RAYA :( espera a la siguiente ronda");
		} catch (RemoteException e) {
			e.printStackTrace();
		}}

	@Override
	public void reparteOponente() {
		manoTerminada();
	}

	
	@Override
	public void manoTerminada() {
		textArea.append("\nLa mano termino");
		mostrarPuntajes();
	}}
