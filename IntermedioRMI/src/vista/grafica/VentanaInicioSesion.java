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
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;

public class VentanaInicioSesion extends JFrame {

	private JPanel contentPane;
	private JButton btnIngresarDin;
	private JLabel lblUsuario;
	private JButton btnSiguiente;
	private JLabel lblIngresarDin;
	private JPanel panel_1;
	private JPanel panel;
	private JTextField textUsuario;
	private JFormattedTextField textDinero;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblAdvertencia;
	/**
	 * Create the frame.
	 */
	public VentanaInicioSesion() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 150);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "", "[][grow]"));
		
		btnSiguiente = new JButton("Agregar jugador");
		contentPane.add(btnSiguiente, "flowx,cell 0 1");
		SwingUtilities.getRootPane(btnSiguiente).setDefaultButton(btnSiguiente);
		
		btnIngresarDin = new JButton("Ingresar dinero");
		contentPane.add(btnIngresarDin, "cell 0 1");
		btnIngresarDin.setVisible(false);
		
		
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 0 0");
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		lblIngresarDin = new JLabel("Ingrese la cantidad de dinero que desea ingresar($)");
		panel_2.add(lblIngresarDin);
		
		lblUsuario = new JLabel("Ingrese usuario");
		panel_2.add(lblUsuario);
		lblIngresarDin.setVisible(false);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		lblAdvertencia = new JLabel("Se le quitaran $100 para iniciar el pozo");
		panel_3.add(lblAdvertencia);
		lblAdvertencia.setVisible(false);
		
		panel = new JPanel();
		contentPane.add(panel, "cell 1 0");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		panel.add(textUsuario);
		
		textDinero = new JFormattedTextField(new Integer(0));
		panel.add(textDinero);
		textDinero.setVisible(false);
		textDinero.setColumns(3);
	}
	public void onClickIniciar(ActionListener listener) {
		this.btnIngresarDin.addActionListener(listener);
	}
	public void onClickSiguiente(ActionListener listener) {
		this.btnSiguiente.addActionListener(listener);
	}
	public String getTextUsuario() {
		return this.textUsuario.getText();
	}
	public int getDinero() {
		return (int) this.textDinero.getValue();
	}
	public void nombreRepetido() {
		this.lblUsuario.setText("Ingrese usuario(El nombre de usuario ya esta usado)");
	}
	public void ingresarDin() {
		lblIngresarDin.setVisible(true);
		lblAdvertencia.setVisible(true);
		lblUsuario.setVisible(false);
		btnIngresarDin.setVisible(true);
		textDinero.setVisible(true);
		textUsuario.setVisible(false);
		SwingUtilities.getRootPane(btnIngresarDin).setDefaultButton(btnIngresarDin);
		btnSiguiente.setVisible(false);
		
	}
	public void dineroInvalido() {
		lblAdvertencia.setText("Cantidad insuficiente (Se le quitaran $100 para iniciar el pozo)");
		
	}
}
