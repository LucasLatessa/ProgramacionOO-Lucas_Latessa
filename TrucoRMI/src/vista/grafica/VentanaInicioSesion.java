package vista.grafica;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class VentanaInicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JButton btnNuevaPartida;
	private JLabel lblUsuario;
	private JButton btnVerRanking;
	/**
	 * Create the frame.
	 */
	public VentanaInicioSesion() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 110);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow]", "[][]"));
		
		lblUsuario = new JLabel("Usuario");
		contentPane.add(lblUsuario, "cell 1 0,alignx trailing");
		
		textUsuario = new JTextField();
		contentPane.add(textUsuario, "cell 3 0,growx");
		textUsuario.setColumns(10);
		
		btnVerRanking = new JButton("Ver ranking");
		contentPane.add(btnVerRanking, "cell 0 1");
		
		btnNuevaPartida = new JButton("Nueva partida");
		contentPane.add(btnNuevaPartida, "cell 3 1,alignx right");
		
		SwingUtilities.getRootPane(btnNuevaPartida).setDefaultButton(btnNuevaPartida);
		
	}
	public void onClickVerRanking(ActionListener listener) {
		this.btnVerRanking.addActionListener(listener);
	}
	public void onClickIniciar(ActionListener listener) {
		this.btnNuevaPartida.addActionListener(listener);
	}
	
	public String getGetNombreUsuario() {
		return this.textUsuario.getText();
	}
	public void nombreRepetido() {
		this.textUsuario.setText("El nombre de usuario ya esta usado");
	}
	public void esperandoOtrosJugadores() {
		this.btnNuevaPartida.setVisible(false);
		this.textUsuario.setVisible(false);
		this.lblUsuario.setText("Esperando jugadores...");
		
		
	}
}
