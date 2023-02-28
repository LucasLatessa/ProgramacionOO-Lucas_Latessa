package vista.grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnPedirCarta;
	private JButton btnPaso;
	private ButtonGroup grupo;
	private JLabel cartaTiradaJ1_1;
	private JLabel cartaTiradaJ1_2;
	private JLabel cartaTiradaJ1_3;
	private JLabel lblPlataDispo;
	private JLabel lblNotificaciones;
	private JLabel lblNotificacionFinal;
	private JPanel panelIzq;
	private JPanel panel_Separador;
	private JPanel panelJug1;
	private JLabel jugador1;
	private JLabel lblResultadoRonda1;
	private JPanel panelJug2;
	private JLabel jugador2;
	private JLabel lblResultadoRonda2;
	private JPanel panelJug3;
	private JLabel jugador3;
	private JLabel lblResultadoRonda3;
	private JLabel cartaTiradaJ1;
	private JLabel cartaTiradaJ1_4;
	private JPanel panelCartaIntermedia;
	private JPanel panelCartasIntermedias;
	private JLabel cartasTiradasJ1_1;
	private JPanel panelCartaIntermediaJ1;
	private JLabel cartaTiradaJ1_5;
	private JPanel panelCartaIntermediaJ2;
	private JLabel cartaTiradaJ1_6;
	private JPanel panelCartaIntermediaJ3;
	private JLabel cartaTiradaJ1_7;
	private JPanel panelCartaIntermediaJ4;
	private JLabel cartaTiradaJ1_8;
	private JPanel panelCartaIntermediaJ5;
	private JLabel cartaTiradaJ1_9;
	private JPanel panelJug4;
	private JLabel jugador4;
	private JLabel lblResultadoRonda3_1;
	private JPanel panelJug5;
	private JLabel jugador5;
	private JLabel lblResultadoRonda3_2;
	private JPanel panelApuestasArriba;
	private JLabel lblPozo;
	private JLabel lblPlataDispoCant;
	private JLabel lblPozoCant;
	private JPanel panelCartaTiradaJ1;
	private JPanel panelCartaTiradaJ2;
	private JPanel panelCartaTiradaJ3;
	private JPanel panelCartaTiradaJ4;
	private JPanel panelCartaTiradaJ5;
	public VentanaPrincipal(){
		Image imagenVerde = null;
		Image imagenMarron = null;
		try {
			imagenVerde = ImageIO.read(new File("src/Imagenes/FondoVerde.png"));
			imagenMarron = ImageIO.read(new File("src/Imagenes/FondoMarron.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle("Intermedio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panelDer = new JPanel();
		contentPane.add(panelDer, BorderLayout.EAST);
		panelDer.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelApuestas = new JPanel();
		panelDer.add(panelApuestas);
		panelApuestas.setLayout(new BorderLayout(0, 0));
    	
		JPanel panelApuestasAbajo = new JPanel();
		panelApuestas.add(panelApuestasAbajo, BorderLayout.CENTER);
		panelApuestasAbajo.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panelApuestasAbajo.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelPlataDispo = new JPanel();
		panel_3.add(panelPlataDispo);
		panelPlataDispo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblPlataDispo = new JLabel("Dinero disponible:");
		lblPlataDispo.setVerticalAlignment(SwingConstants.TOP);
		lblPlataDispo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPlataDispo.setAlignmentY(0.0f);
		panelPlataDispo.add(lblPlataDispo);
		
		lblPlataDispoCant = new JLabel("0");
		lblPlataDispoCant.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlataDispoCant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPlataDispo.add(lblPlataDispoCant);
		
		panelApuestasArriba = new JPanel();
		panelApuestas.add(panelApuestasArriba, BorderLayout.NORTH);
		
		lblPozo = new JLabel("Pozo:");
		lblPozo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPozo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPozo.setAlignmentY(2.0f);
		lblPozo.setAlignmentX(0.5f);
		panelApuestasArriba.add(lblPozo);
		
		lblPozoCant = new JLabel("0");
		lblPozoCant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelApuestasArriba.add(lblPozoCant);
		
		JPanel panelAbajo_Cantos = new JPanel();
		panelDer.add(panelAbajo_Cantos);
		panelAbajo_Cantos.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnPedirCarta = new JButton("Pedir carta");
		panelAbajo_Cantos.add(btnPedirCarta);
		
		btnPaso = new JButton("Paso");
		panelAbajo_Cantos.add(btnPaso);
		grupo= new ButtonGroup();
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelCartasTiradasIzq = new JPanel();
		panelCentro.add(panelCartasTiradasIzq);
		panelCartasTiradasIzq.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelCartasTiradas = new JPanel();
		panelCartasTiradasIzq.add(panelCartasTiradas);
		panelCartasTiradas.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel cartasTiradasJ1 = new JLabel("Cartas tiradas");
		cartasTiradasJ1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		cartasTiradasJ1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartasTiradas.add(cartasTiradasJ1);
		
		JPanel panelCartaTiradaJ1 = new JPanel();
		panelCartasTiradasIzq.add(panelCartaTiradaJ1);
		panelCartaTiradaJ1.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1_1 = new JLabel("");
		cartaTiradaJ1_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		cartaTiradaJ1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ1.add(cartaTiradaJ1_1);
		
		JPanel panelCartaTiradaJ2 = new JPanel();
		panelCartasTiradasIzq.add(panelCartaTiradaJ2);
		panelCartaTiradaJ2.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1_2 = new JLabel("");
		cartaTiradaJ1_2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		cartaTiradaJ1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ2.add(cartaTiradaJ1_2);
		
		JPanel panelCartaTiradaJ3 = new JPanel();
		panelCartasTiradasIzq.add(panelCartaTiradaJ3);
		panelCartaTiradaJ3.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1_3 = new JLabel("");
		cartaTiradaJ1_3.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		cartaTiradaJ1_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ3.add(cartaTiradaJ1_3);
		
		panelCartaTiradaJ4 = new JPanel();
		panelCartasTiradasIzq.add(panelCartaTiradaJ4);
		panelCartaTiradaJ4.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1 = new JLabel("");
		cartaTiradaJ1.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaTiradaJ4.add(cartaTiradaJ1);
		
		panelCartaTiradaJ5 = new JPanel();
		panelCartasTiradasIzq.add(panelCartaTiradaJ5);
		panelCartaTiradaJ5.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1_4 = new JLabel("");
		cartaTiradaJ1_4.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ1_4.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaTiradaJ5.add(cartaTiradaJ1_4);
		
		panelCartaIntermedia = new JPanel();
		panelCentro.add(panelCartaIntermedia);
		panelCartaIntermedia.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelCartasIntermedias = new JPanel();
		panelCartaIntermedia.add(panelCartasIntermedias);
		panelCartasIntermedias.setLayout(new GridLayout(0, 1, 0, 0));
		
		cartasTiradasJ1_1 = new JLabel("Cartas intermedias");
		cartasTiradasJ1_1.setHorizontalAlignment(SwingConstants.CENTER);
		cartasTiradasJ1_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartasIntermedias.add(cartasTiradasJ1_1);
		
		panelCartaIntermediaJ1 = new JPanel();
		panelCartaIntermedia.add(panelCartaIntermediaJ1);
		panelCartaIntermediaJ1.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1_5 = new JLabel("");
		cartaTiradaJ1_5.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ1_5.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaIntermediaJ1.add(cartaTiradaJ1_5);
		
		panelCartaIntermediaJ2 = new JPanel();
		panelCartaIntermedia.add(panelCartaIntermediaJ2);
		panelCartaIntermediaJ2.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1_6 = new JLabel("");
		cartaTiradaJ1_6.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ1_6.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaIntermediaJ2.add(cartaTiradaJ1_6);
		
		panelCartaIntermediaJ3 = new JPanel();
		panelCartaIntermedia.add(panelCartaIntermediaJ3);
		panelCartaIntermediaJ3.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1_7 = new JLabel("");
		cartaTiradaJ1_7.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ1_7.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaIntermediaJ3.add(cartaTiradaJ1_7);
		
		panelCartaIntermediaJ4 = new JPanel();
		panelCartaIntermedia.add(panelCartaIntermediaJ4);
		panelCartaIntermediaJ4.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1_8 = new JLabel("");
		cartaTiradaJ1_8.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ1_8.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaIntermediaJ4.add(cartaTiradaJ1_8);
		
		panelCartaIntermediaJ5 = new JPanel();
		panelCartaIntermedia.add(panelCartaIntermediaJ5);
		panelCartaIntermediaJ5.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1_9 = new JLabel("");
		cartaTiradaJ1_9.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ1_9.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaIntermediaJ5.add(cartaTiradaJ1_9);
		
		JPanel panelNorte = new JPanel();
		FlowLayout fl_panelNorte = (FlowLayout) panelNorte.getLayout();
		fl_panelNorte.setVgap(0);
		fl_panelNorte.setHgap(0);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		lblNotificaciones = new JLabel("");
		lblNotificaciones.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelNorte.add(lblNotificaciones);
		
		lblNotificacionFinal = new JLabel("");
		lblNotificacionFinal.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelNorte.add(lblNotificacionFinal);
		
		panelIzq = new JPanel();
		contentPane.add(panelIzq, BorderLayout.WEST);
		panelIzq.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_Separador = new JPanel();
		panelIzq.add(panel_Separador);
		
		panelJug1 = new JPanel();
		panelIzq.add(panelJug1);
		panelJug1.setLayout(new GridLayout(0, 1, 0, 0));
		
		jugador1 = new JLabel("");
		jugador1.setVerticalAlignment(SwingConstants.TOP);
		jugador1.setHorizontalAlignment(SwingConstants.LEFT);
		jugador1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelJug1.add(jugador1);
		
		lblResultadoRonda1 = new JLabel("");
		lblResultadoRonda1.setHorizontalAlignment(SwingConstants.CENTER);
		panelJug1.add(lblResultadoRonda1);
		
		panelJug2 = new JPanel();
		panelIzq.add(panelJug2);
		panelJug2.setLayout(new GridLayout(0, 1, 0, 0));
		
		jugador2 = new JLabel("");
		jugador2.setVerticalAlignment(SwingConstants.TOP);
		jugador2.setHorizontalAlignment(SwingConstants.LEFT);
		jugador2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelJug2.add(jugador2);
		
		lblResultadoRonda2 = new JLabel("");
		lblResultadoRonda2.setHorizontalAlignment(SwingConstants.CENTER);
		panelJug2.add(lblResultadoRonda2);
		
		panelJug3 = new JPanel();
		panelIzq.add(panelJug3);
		panelJug3.setLayout(new GridLayout(0, 1, 0, 0));
		
		jugador3 = new JLabel("");
		jugador3.setVerticalAlignment(SwingConstants.TOP);
		jugador3.setHorizontalAlignment(SwingConstants.LEFT);
		jugador3.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelJug3.add(jugador3);
		
		lblResultadoRonda3 = new JLabel("");
		lblResultadoRonda3.setHorizontalAlignment(SwingConstants.CENTER);
		panelJug3.add(lblResultadoRonda3);
		
		panelJug4 = new JPanel();
		panelIzq.add(panelJug4);
		panelJug4.setLayout(new GridLayout(0, 1, 0, 0));
		
		jugador4 = new JLabel("");
		jugador4.setVerticalAlignment(SwingConstants.TOP);
		jugador4.setHorizontalAlignment(SwingConstants.LEFT);
		jugador4.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelJug4.add(jugador4);
		
		lblResultadoRonda3_1 = new JLabel("");
		lblResultadoRonda3_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelJug4.add(lblResultadoRonda3_1);
		
		panelJug5 = new JPanel();
		panelIzq.add(panelJug5);
		panelJug5.setLayout(new GridLayout(0, 1, 0, 0));
		
		jugador5 = new JLabel("");
		jugador5.setVerticalAlignment(SwingConstants.TOP);
		jugador5.setHorizontalAlignment(SwingConstants.LEFT);
		jugador5.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelJug5.add(jugador5);
		
		lblResultadoRonda3_2 = new JLabel("");
		lblResultadoRonda3_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelJug5.add(lblResultadoRonda3_2);
	}
	public void onClickPedirCarta(ActionListener listener) {
		this.btnPedirCarta.addActionListener(listener);
	}
	public void onClickPaso(ActionListener listener) {
		this.btnPaso.addActionListener(listener);
	}
	public static JRadioButton getSelection(ButtonGroup group)
	{
	        for (Enumeration e=group.getElements(); e.hasMoreElements(); )
	        {
	            JRadioButton b = (JRadioButton)e.nextElement();
	            if (b.getModel() == group.getSelection())
	            {
	                return b;
	            }
	        }
	        return null;
	}
	public void setJugadores(ArrayList<String> jugadores) {
		this.esconderTodosJug();
		for (int x=0;jugadores.size()<x;x++) {
			switch(x) {
			case 0:
				jugador1.setText(jugadores.get(x));
				panelCartaTiradaJ1.setVisible(true);
				panelJug1.setVisible(true);
				panelCartaIntermediaJ1.setVisible(true);
				break;
			case 1:
				jugador2.setText(jugadores.get(x));
				panelCartaTiradaJ2.setVisible(true);
				panelJug2.setVisible(true);
				panelCartaIntermediaJ2.setVisible(true);
			case 2:
				jugador3.setText(jugadores.get(x));
				panelCartaTiradaJ3.setVisible(true);
				panelJug3.setVisible(true);
				panelCartaIntermediaJ3.setVisible(true);
			case 3:
				jugador4.setText(jugadores.get(x));
				panelCartaTiradaJ4.setVisible(true);
				panelJug4.setVisible(true);
				panelCartaIntermediaJ4.setVisible(true);
			case 4:
				jugador5.setText(jugadores.get(x));
				panelCartaTiradaJ5.setVisible(true);
				panelJug5.setVisible(true);
				panelCartaIntermediaJ5.setVisible(true);
			}
		}
	}
	private void esconderTodosJug() {
		panelCartaTiradaJ1.setVisible(false);
		panelCartaTiradaJ2.setVisible(false);
		panelCartaTiradaJ3.setVisible(false);
		panelCartaTiradaJ4.setVisible(false);
		panelCartaTiradaJ5.setVisible(false);
		
		panelJug1.setVisible(false);
		panelJug2.setVisible(false);
		panelJug3.setVisible(false);
		panelJug4.setVisible(false);
		panelJug5.setVisible(false);
		
		panelCartaIntermediaJ1.setVisible(false);
		panelCartaIntermediaJ2.setVisible(false);
		panelCartaIntermediaJ3.setVisible(false);
		panelCartaIntermediaJ4.setVisible(false);
		panelCartaIntermediaJ5.setVisible(false);
		
	}
	public void actualizarPuntos(int jug1,int jug2) {
		lblPlataDispoCant.setText(Integer.toString(jug1));
		lblPlataDispoCant.setText(Integer.toString(jug2));
	}
	public void botonesComienzo() {
	}
	public void limpiarVista() {
	}
	public void mostrarCartas(ArrayList<String> cartas) throws IOException {
		
	}
	public void esperarJugandoOponente(String nombreTurno) {
		setTitle("Truco(TURNO OPONENTE, "+nombreTurno+")");
		btnPedirCarta.setVisible(false);
		btnPaso.setVisible(false);
	}
	public void turnoActual(String nombreTurno) {
		setTitle("Truco(TURNO ACTUAL, "+nombreTurno+")");
	}
	
	public void ganoRonda() {
		if (lblResultadoRonda1.getText().equals("")) {
			lblResultadoRonda1.setText("Ganaste la ronda");}
		else if (lblResultadoRonda2.getText().equals("")) {
			lblResultadoRonda2.setText("Ganaste la ronda");}
		else if (lblResultadoRonda3.getText().equals("")&&cartaTiradaJ1_3.getText()!="") {
			lblResultadoRonda3.setText("Ganaste la ronda");}
	}
	public void perdioRonda() {
		if (lblResultadoRonda1.getText().equals("")) {
			lblResultadoRonda1.setText("Perdiste la ronda");}
		else if (lblResultadoRonda2.getText().equals("")) {
			lblResultadoRonda2.setText("Perdiste la ronda");}
		else if (lblResultadoRonda3.getText().equals("")&&cartaTiradaJ1_3.getText()!="") {
			lblResultadoRonda3.setText("Perdiste la ronda");}
	}
	public void pardaRonda() {
		if (lblResultadoRonda1.getText().equals("")) {
			lblResultadoRonda1.setText("Ronda parda");
			lblResultadoRonda2.setText("Segunda define");}
		else if (lblResultadoRonda2.getText().equals("")) {
			lblResultadoRonda2.setText("Ronda parda");}
		else if (lblResultadoRonda3.getText().equals("")&&cartaTiradaJ1_3.getText()!="") {
			lblResultadoRonda3.setText("Ronda parda");}
	}
	public boolean isPrimeraRonda() {
		return cartaTiradaJ1_1.getText().equals("");
	}
	public void notificarCanto(String string) {
		lblNotificaciones.setVisible(true);
		lblNotificaciones.setText("El contrario canto "+string.toLowerCase());
	}
	public void ocultarNotificaciones() {
		lblNotificaciones.setVisible(false);
	}
	public void mostrarGanadorEnvido(String nombre,Integer p1, Integer p2) {
		lblNotificaciones.setText( "El ganador del tanto es "+nombre+". Los tantos fueron :"+p1+", "+p2+". ");
		lblNotificaciones.setVisible(true);
	}
	public void laManoTermino() {
		lblNotificaciones.setVisible(true);
		lblNotificaciones.setText( "La mano termino");
	}
	public void juegoTerminado(String ganador) {
		lblNotificacionFinal.setText("El juego termino, el ganador es "+ ganador);
		lblNotificaciones.setVisible(true);}
	public void pedirDeNuevoCarta() {
		this.lblNotificaciones.setVisible(true);
		lblNotificaciones.setText( "Selecciona una carta para tirar");
		
	}
	public boolean jugadoresCargados() {
		return !(jugador1.getText().equals(""));
	}
	public void mostrarCartaIntermedia(String cartaIntermedia) {
		// TODO Auto-generated method stub
		
	}
}
